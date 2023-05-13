package gui;

//imports
import arenas.Arena;
import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;
import game.factory.RaceBuilder;
import game.racers.Racer;
import utilities.EnumContainer;
import utilities.Point;
import utilities.Program;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Comparator;
import javax.swing.table.TableRowSorter;


public class RaceFrame extends JFrame implements ActionListener {
    private static RaceBuilder builder = RaceBuilder.getInstance();
    private static JFrame MainFrame ;
    private static JFrame ResFrame;
    private static Racer racer;
    private static ArrayList<Racer> racersArr =new ArrayList<Racer>();;
    private static Arena arena;
    private ImageIcon racersImages[] = null;
    private int ArenaLength = 1000;
    private int ArenaHeight = 700;
    private int maxRacers = 8;
    private JComboBox SelectArena ;
    private JTextField ArenaLengthfield;
    private JTextField MaxRaceersfield;
    private JComboBox SelectRacer;
    private JComboBox SelectColor;
    private JTextField Namefield;
    private JTextField Speedfield;
    private JTextField Accelerationfield;
    private JPanel arenaPanel;
    private ImageIcon image;
    private  JLabel Arenapic;
    private int RacerY= 0;
    private int ActiveRacersAmount=0;
    private ArrayList<JLabel> RacerImeges = new ArrayList<JLabel>();
    private boolean RaceStarted= false;
    private boolean NewArena= false;

    //constructor
    public RaceFrame() {
        super("Race");
        getframe();

        this.pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    //MainFrame
    public JFrame getframe() {
        setPreferredSize(new Dimension(1200 , 700));
        //setResizable(false);

        //main RaceFrame
        arenaPanel = new JPanel();
        arenaPanel.setLayout(null);
        arenaPanel.setPreferredSize(new Dimension(1000 , 700));
        arenaPanel.setVisible(true);
        add(arenaPanel, BorderLayout.WEST);

        //right side panel
        JPanel rightpanel = new JPanel();
        rightpanel.setSize(200, 700);
        rightpanel.setLocation(1000,0);
        rightpanel.setBackground(Color.lightGray);
        rightpanel.setLayout(null);
        //adding new panel to main frame
        add(rightpanel);


        //Choose Arena ComboBox
        JLabel ChooseArenalable = new JLabel("Choose arena:");
        rightpanel.add(ChooseArenalable);
        ChooseArenalable.setLocation(15, 10);
        ChooseArenalable.setSize(150, 15);

        String[] Arenanames = {"AerialArena", "NavalArena", "LandArena"};
        SelectArena = new JComboBox(Arenanames);
        rightpanel.add(SelectArena);
        SelectArena.setLocation(10, 30);
        SelectArena.setSize(150, 25);


        // arena size
        JLabel ArenaLenlable = new JLabel("Arena length:");
        rightpanel.add(ArenaLenlable);
        ArenaLenlable.setLocation(15, 60);
        ArenaLenlable.setSize(150, 15);

        ArenaLengthfield = new JTextField("1400");
        rightpanel.add(ArenaLengthfield);
        ArenaLengthfield.setLocation(10, 80);
        ArenaLengthfield.setSize(150, 25);

        //Max arena racers
        JLabel MaxRaceerslable = new JLabel("Max racers number:");
        rightpanel.add(MaxRaceerslable);
        MaxRaceerslable.setLocation(15, 110);
        MaxRaceerslable.setSize(150, 15);

        MaxRaceersfield = new JTextField("12");
        rightpanel.add(MaxRaceersfield);
        MaxRaceersfield.setLocation(10, 130);
        MaxRaceersfield.setSize(150, 25);

        //build arena btn
        JButton buildArenaBut = new JButton("Build arena");
        rightpanel.add(buildArenaBut);
        buildArenaBut.setLocation(10, 175);
        buildArenaBut.setSize(150, 30);
        buildArenaBut.addActionListener(this::BuildArenaAction);

        //seperator line
        JSeparator Seperator1 = new JSeparator(SwingConstants.HORIZONTAL);
        rightpanel.add(Seperator1);
        Seperator1.setLocation(0, 220);
        Seperator1.setSize(200, 10);


        //Choose Racer ComboBox
        JLabel ChooseRacerlable = new JLabel("Choose Racer:");
        rightpanel.add(ChooseRacerlable);
        ChooseRacerlable.setLocation(15, 230);
        ChooseRacerlable.setSize(150, 15);

        String[] Racernames = {"Airplane", "Helicopter", "Bicycle", "Car", "Horse", "RowBoat", "SpeedBoat"};
        SelectRacer = new JComboBox(Racernames);
        rightpanel.add(SelectRacer);
        SelectRacer.setLocation(10, 250);
        SelectRacer.setSize(150, 25);


        //Choose Color ComboBox
        JLabel ChooseColorlable = new JLabel("Choose color:");
        rightpanel.add(ChooseColorlable);
        ChooseColorlable.setLocation(15, 290);
        ChooseColorlable.setSize(150, 15);

        String[] colors = {"Black", "Red", "Green", "Blue", "Yellow"};
        SelectColor = new JComboBox(colors);
        rightpanel.add(SelectColor);
        SelectColor.setLocation(10, 310);
        SelectColor.setSize(150, 25);

        //Racer name
        JLabel Namelable = new JLabel("Racers name:");
        rightpanel.add(Namelable);
        Namelable.setLocation(15, 350);
        Namelable.setSize(150, 15);

        Namefield = new JTextField("RacerX");
        rightpanel.add(Namefield);
        Namefield.setLocation(10, 370);
        Namefield.setSize(150, 25);


        //Max speed
        JLabel Maxspeedlable = new JLabel("Max speed:");
        rightpanel.add(Maxspeedlable);
        Maxspeedlable.setLocation(15, 410);
        Maxspeedlable.setSize(150, 15);

        Speedfield = new JTextField("15");
        rightpanel.add(Speedfield);
        Speedfield.setLocation(10, 430);
        Speedfield.setSize(150, 25);

        //Acceleration
        JLabel Accelerationlable = new JLabel("Acceleration:");
        rightpanel.add(Accelerationlable);
        Accelerationlable.setLocation(15, 470);
        Accelerationlable.setSize(150, 15);

        Accelerationfield  = new JTextField("2");
        rightpanel.add(Accelerationfield);
        Accelerationfield.setLocation(10, 490);
        Accelerationfield.setSize(150, 25);

        //add Racer arena btn
        JButton addRacerBut = new JButton("Add Racer");
        rightpanel.add(addRacerBut);
        addRacerBut.setLocation(10, 530);
        addRacerBut.setSize(150, 30);
        addRacerBut.addActionListener(this::AddRacer);

        //seperator line
        JSeparator Seperator2 = new JSeparator(SwingConstants.HORIZONTAL);
        rightpanel.add(Seperator2);
        Seperator2.setLocation(0, 570);
        Seperator2.setSize(200, 10);


        //Start Race btn
        JButton StartBut = new JButton("Start Race");
        rightpanel.add(StartBut);
        StartBut.setLocation(10, 585);
        StartBut.setSize(150, 30);
        StartBut.addActionListener(this::StartAction);

        //Show info btn
        JButton infoBut = new JButton("Show Info");
        rightpanel.add(infoBut);
        infoBut.setLocation(10, 625);
        infoBut.setSize(150, 30);
        infoBut.addActionListener(this::ShowRes);

        return MainFrame;
    }
    //methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    //Add arne ON-CLICK
    public void BuildArenaAction(ActionEvent e) {
        if(RaceStarted==false) {
            NewArena= true;
            int chosenArena = SelectArena.getSelectedIndex();
            String ArenaType = "";
            String ImageType = "";
            if (chosenArena == 0) {
                ArenaType = "air.AerialArena";
                ImageType = "AerialArena";
            }
            if (chosenArena == 1) {
                ArenaType = "naval.NavalArena";
                ImageType = "NavalArena";
            }
            if (chosenArena == 2) {
                ArenaType = "land.LandArena";
                ImageType = "LandArena";
            }

            try {
                //get and convert text for Len
                ArenaLength = Integer.parseInt(ArenaLengthfield.getText());
                //get and convert text for Maxracers
                maxRacers = Integer.parseInt(MaxRaceersfield.getText());
                if ((int)maxRacers > 20 || (int)maxRacers < 1)
                    throw new IllegalArgumentException("Error");
                if ((int)ArenaLength > 3000 || (int)ArenaLength < 100)
                    throw new IllegalArgumentException("Error");
                arena = builder.buildArena("arenas." + ArenaType, ArenaLength, maxRacers);
                ArenaImage(ImageType, ArenaLength, maxRacers * 70 +30);
                RacerY = 0;
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                     | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {

                JOptionPane.showMessageDialog(this, "Inviald input values! Please try again.");
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Race Started - wait for finish");
    }
    public void ArenaImage(String Atype,int W,int H){
        //add image
        arenaPanel.removeAll();
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("icons/"+Atype+".jpg").getImage()
                .getScaledInstance(W+70, H, Image.SCALE_DEFAULT));
        Arenapic = new JLabel(imageIcon1);
        Arenapic.setLocation(0, 0);
        Arenapic.setSize(W+70, H);
        if(H<700)
            this.setSize(270+W,700);
        else this.setSize(270+W,H);
        arenaPanel.setPreferredSize(new Dimension(W+70 , H));
        arenaPanel.add(Arenapic);
        setResizable(false);
        ActiveRacersAmount = 0;
        RaceStarted = false;
        RacerImeges = new ArrayList<JLabel>();
    }
    //Add racer ON-CLICK
    public void AddRacer(ActionEvent e) {
        if(RaceStarted==false){
        try {
            if(arena==null||NewArena==false){throw new IllegalArgumentException("Please build arena first to add racers!");}
            int newRacer = SelectRacer.getSelectedIndex();
            int newcolor = SelectColor.getSelectedIndex();

            EnumContainer.Color NewColor = null;
            if (newcolor == 0)
                NewColor = EnumContainer.Color.BLACK;
            if (newcolor == 1)
                NewColor = EnumContainer.Color.RED;
            if (newcolor == 2)
                NewColor = EnumContainer.Color.GREEN;
            if (newcolor == 3)
                NewColor = EnumContainer.Color.BLUE;
            if (newcolor == 4)
                NewColor = EnumContainer.Color.YELLOW;

            String RacerName = Namefield.getText();

            int Mspeed = Integer.parseInt(Speedfield.getText());
            if(Mspeed<=0){throw new IllegalArgumentException("ivaild input values for Racer ,please try again.");}
            int Acc = Integer.parseInt(Accelerationfield.getText());
            if(Acc<=0){throw new IllegalArgumentException("ivaild input values for Racer ,please try again.");}

            if (newRacer == 0)
                addWR("air.Airplane", RacerName, Mspeed, Acc, NewColor,3);
            if (newRacer == 1)
                addR("air.Helicopter", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 2)
                addWR("land.Bicycle", RacerName, Mspeed, Acc, NewColor,2);
            if (newRacer == 3)
                addWR("land.Car", RacerName, Mspeed, Acc, NewColor,4);
            if (newRacer == 4)
                addR("land.Horse", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 5)
                addR("naval.RowBoat", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 6)
                addR("naval.SpeedBoat", RacerName, Mspeed, Acc, NewColor);

            racer.setCurrentLocation(new Point(0,70*ActiveRacersAmount));
            addRacersToArena();
        }
        catch (IllegalArgumentException e1){
            JOptionPane.showMessageDialog(this,e1.getMessage());
        }}
        else
        JOptionPane.showMessageDialog(this,"Race Started - wait for finish");
    }
    public void RacerImage(String RacerType,String RacerColor,int CurrentX,int CurrentY) {
        //add image for racerz
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("icons/" + RacerType + RacerColor + ".png").getImage()
                .getScaledInstance(70, 70, Image.SCALE_DEFAULT));
        JLabel picLabel1 = new JLabel(imageIcon2);
        picLabel1.setLocation(CurrentX, CurrentY);
        picLabel1.setSize(70, 70);
        RacerImeges.add(picLabel1);
        Arenapic.add(picLabel1);
        setResizable(true);
    }

    //add racers methods
    public void addR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor){
        try {
            racer=builder.buildRacer("game.racers."+ rt, name, mSpeed, Acc, NewColor);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this,"Unable To add Racer");
        }
    }
    public void addWR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor,int Numofwheels){
        try {
            racer=builder.buildWheeledRacer("game.racers."+rt, name, mSpeed, Acc,NewColor, Numofwheels);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this,"Unable To add Racer");
        }
    }
    public void addRacersToArena() {
            try {
                arena.addRacer(racer);
                RacerImage(racer.className(),racer.getColor().toString(),(int)racer.getCurrentLocation().getX(),(int)racer.getCurrentLocation().getY());
                ActiveRacersAmount =arena.getActiveRacers().size();
            } catch (RacerLimitException e) {
                JOptionPane.showMessageDialog(this,"[Error] " + e.getMessage());

            } catch (RacerTypeException e) {
                JOptionPane.showMessageDialog(this,"[Error] " + e.getMessage());
            }
    }
    //Start Racer Btn ON-CLICK
    public void StartAction(ActionEvent e) {
        if(arena !=null) {
            if (ActiveRacersAmount != 0){
                if(RaceStarted == false) {
                    if (NewArena == true) {
                        NewArena = false;
                        RaceStarted = true;
                        racersArr = arena.getActiveRacers();
                        for (Racer racer : racersArr) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    while (racer.getCurrentLocation().getX() < arena.getLength()) {
                                        racer.move(arena.getFRICTION());
                                        try {
                                            Thread.sleep(30);
                                        } catch (InterruptedException ex) {
                                            ex.printStackTrace();
                                        }
                                        UpdateRaceFrame();
                                    }
                                    arena.crossFinishLine(racer);
                                }
                            }).start();
                            UpdateRaceFrame();
                        }
                    } else
                        JOptionPane.showMessageDialog(this,"Race has ended - create new arena");
                }else
                    JOptionPane.showMessageDialog(this, "Race in progress - wait for finish" );
            }else
            JOptionPane.showMessageDialog(this, "Please add Racer to Arena ");
        }else
            JOptionPane.showMessageDialog(this, "Please Build arena first");
    }

    //Show results ON-CLICK
    public class AbsurvablleThread extends Thread {
        private volatile boolean running = true;
        @Override
        public void run() {
            while (running) {
                showRes();
                running=false;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void showRes() {
            ResFrame = new JFrame("Racer information");
            DefaultTableModel table = new DefaultTableModel(0, 5);
            String[] row = {"name", "speed", "Mspeed", "location", "finish"};
            table.addRow(row);
            JTable table2 = new JTable(table);
            JScrollPane scrollPane = new JScrollPane(table2);

            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(table);
            table2.setRowSorter(sorter);
            int counter = 1;
            for (Racer racer : arena.getCompletedRacers()) {
                int location = (int) racer.getCurrentLocation().getX();
                if(location >= arena.getLength()) location = (int) arena.getLength();
                String[] tempRow = {racer.getName(), String.valueOf((int)racer.getCurrentSpeed()), String.valueOf(racer.getMaxSpeed()), String.valueOf(location), "Yes"};
                table.addRow(tempRow);
                counter++;
            }
            for (Racer racer : arena.getActiveRacers()) {
                int location = (int) racer.getCurrentLocation().getX();
                if(location < arena.getLength()){
                String[] tempRow = {racer.getName(), String.valueOf((int)racer.getCurrentSpeed()), String.valueOf(racer.getMaxSpeed()), String.valueOf(location), "No"};
                table.addRow(tempRow);
                counter++;
                }
            }
            ResFrame.add(scrollPane, BorderLayout.CENTER);
            ResFrame.setSize(500,300);
            ResFrame.setLocation(850, 500);
            ResFrame.setVisible(true);
        }

    }
    public void ShowRes(ActionEvent e){
        if(arena != null&& ActiveRacersAmount>0) {
            AbsurvablleThread thread = new AbsurvablleThread();
            thread.start();
        }
        else JOptionPane.showMessageDialog(this,"No race in progress");
    }

    //update Frame progression
    private void UpdateRaceFrame() {
        int didnotfinish =0;
        ArrayList<Racer> racerARR= arena.getActiveRacers();
        for(int i =0;i<ActiveRacersAmount;i++) {
            if (racerARR.get(i).getCurrentLocation().getX() < arena.getLength() ){
            RacerImeges.get(i).setLocation((int)racerARR.get(i).getCurrentLocation().getX(), (int) racerARR.get(i).getCurrentLocation().getY());
            didnotfinish++;}
            else RacerImeges.get(i).setLocation((int)arena.getLength(), (int) racerARR.get(i).getCurrentLocation().getY());
        }
        if(didnotfinish == 0)RaceStarted=false;
    }
    public static void main(String[] args){
        new RaceFrame();
    }
}


