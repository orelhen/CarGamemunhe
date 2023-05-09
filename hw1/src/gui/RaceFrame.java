package gui;


//imports
import arenas.Arena;
import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;
import game.factory.RaceBuilder;
import game.racers.Racer;
import utilities.EnumContainer;
import utilities.Point;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;


public class RaceFrame extends JFrame implements ActionListener {
    //disable main
    private static RaceBuilder builder = RaceBuilder.getInstance();
    private static JFrame MainFrame ;
    private static JFrame ResFrame;

    private static ArrayList<Racer> racers;
    private static Arena arena;
    private ImageIcon racersImages[] = null;
    private boolean raceStarted = false;
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
        racers = new ArrayList<>();
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
        RacerImeges = new ArrayList<JLabel>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void BuildArenaAction(ActionEvent e) {

        int chosenArena = SelectArena.getSelectedIndex();
        String ArenaType="";
        String ImageType ="";
        if (chosenArena == 0) {
            ArenaType = "air.AerialArena";
            ImageType="AerialArena";
        }
        if (chosenArena == 1) {
            ArenaType = "naval.NavalArena";
            ImageType="NavalArena";
        }if (chosenArena == 2) {
            ArenaType = "land.LandArena";
            ImageType="LandArena";
        }

        //get and convert text for Len
        ArenaLength =Integer.parseInt(ArenaLengthfield.getText());
        //get and convert text for Maxracers
        maxRacers =Integer.parseInt(MaxRaceersfield.getText());


        try {
            if(maxRacers>20 || maxRacers <1){ throw new IllegalArgumentException("Error");  }
            if(ArenaLength>3000 || ArenaLength <100){ throw new IllegalArgumentException("Error");  }
            arena = builder.buildArena("arenas."+ArenaType, ArenaLength, maxRacers);
            ArenaImage(ImageType,ArenaLength,maxRacers*70);
            RacerY = 0;
            System.out.println(ArenaType+" succecfully created , Len:" + ArenaLength + " , MaxRacers:" + maxRacers );

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {

            JOptionPane.showMessageDialog(this,"Inviald input values! Please try again.");
        }
    }
    public void AddRacer(ActionEvent e) {
        try {
            String RacerType="";
            String RacerColor="";
            if(arena==null){throw new IllegalArgumentException("Error");}
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
            int Acc = Integer.parseInt(Accelerationfield.getText());

            if (newRacer == 0)
                addWR("air.Airplane", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 1)
                addR("air.Helicopter", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 2)
                addWR("land.Bicycle", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 3)
                addWR("land.Car", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 4)
                addR("land.Horse", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 5)
                addR("naval.RowBoat", RacerName, Mspeed, Acc, NewColor);
            if (newRacer == 6)
                addR("naval.SpeedBoat", RacerName, Mspeed, Acc, NewColor);

            racers.get(0).setCurrentLocation(new Point(0,70*ActiveRacersAmount));
            addRacersToArena();
            racers = new ArrayList<>();
        }
        catch (IllegalArgumentException e1){
            JOptionPane.showMessageDialog(this,"Please build arena first and add racers!");
        }
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
    void addR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor){
        try {
            racers.add(builder.buildRacer("game.racers."+ rt, name, mSpeed, Acc, NewColor));
            System.out.println("new racer" + rt + " " + name + " created, ms:" + mSpeed+"  acc:" + Acc + "  colo:" + NewColor);

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this,"Unable To add Racer");
        }
    }
    void addWR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor){
        try {
            racers.add(builder.buildWheeledRacer("game.racers."+rt, name, mSpeed, Acc,NewColor, 3));
            System.out.println("new racer created " + rt + " " + name + "  ms:" + mSpeed+"  acc:" + Acc + "  colo:" + NewColor);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this,"Unable To add Racer");
        }
    }

    public void StartAction(ActionEvent e) //Start Racer Btn ON-CLICK
    {
        arena.initRace();
        for (Racer racer :  arena.getActiveRacers()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (racer.getCurrentLocation().getX()< arena.getLength()) {
                        racer.move(arena.getFRICTION());
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        UpdateRaceFrame();
                    }
                }
            }).start();
            UpdateRaceFrame();
        }
    }
    public class AbsurvablleThread extends Thread {
        private volatile boolean running;

        public AbsurvablleThread() {
            this.running = true;
        }

        @Override
        public void run() {
            while (running) {
                // Perform your thread's logic here
                showRes();

                // Sleep for a certain duration (e.g., 1 second)
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void stopThread() {
            running = false;
        }
        public void showRes() {
            JFrame resFrame = new JFrame("Racer information");
            DefaultTableModel table = new DefaultTableModel(0, 5);
            String[] row = {"name", "speed", "Mspeed", "location", "finish"};
            table.addRow(row);
            JTable table2 = new JTable(table);
            JScrollPane scrollPane = new JScrollPane(table2);

            resFrame.add(scrollPane, BorderLayout.CENTER);
            resFrame.setSize(500, 500);
            resFrame.setLocation(850, 500);
            resFrame.setVisible(true);

            int counter = 1;
            String Finish = "";
            for (Racer racer : arena.getCompletedRacers()) {
                if(racer.getCurrentLocation().getX() < arena.getLength())
                    Finish = "No";
                else Finish = "Yes";
                String[] tempRow = {racer.getName(), String.valueOf(racer.getCurrentSpeed()), String.valueOf(racer.getMaxSpeed()), String.valueOf(racer.getCurrentLocation().getX()), Finish};
                table.addRow(tempRow);
                counter++;
            }
            for (Racer racer : arena.getActiveRacers()) {
                if(racer.getCurrentLocation().getX() < arena.getLength())
                    Finish = "No";
                else Finish = "Yes";
                String[] tempRow = {racer.getName(), String.valueOf(racer.getCurrentSpeed()), String.valueOf(racer.getMaxSpeed()), String.valueOf(racer.getCurrentLocation().getX()), Finish};
                table.addRow(tempRow);
                counter++;
            }

        }
    }

    public void ShowRes(ActionEvent e){
        AbsurvablleThread thread = new AbsurvablleThread();
        thread.start();
    }

    //RaceInfo Btn ON-CLICK


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

        ArenaLengthfield = new JTextField("1000");
        rightpanel.add(ArenaLengthfield);
        ArenaLengthfield.setLocation(10, 80);
        ArenaLengthfield.setSize(150, 25);

        //Max arena racers
        JLabel MaxRaceerslable = new JLabel("Max racers number:");
        rightpanel.add(MaxRaceerslable);
        MaxRaceerslable.setLocation(15, 110);
        MaxRaceerslable.setSize(150, 15);

        MaxRaceersfield = new JTextField("8");
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

        Namefield = new JTextField();
        rightpanel.add(Namefield);
        Namefield.setLocation(10, 370);
        Namefield.setSize(150, 25);


        //Max speed
        JLabel Maxspeedlable = new JLabel("Max speed:");
        rightpanel.add(Maxspeedlable);
        Maxspeedlable.setLocation(15, 410);
        Maxspeedlable.setSize(150, 15);

        Speedfield = new JTextField();
        rightpanel.add(Speedfield);
        Speedfield.setLocation(10, 430);
        Speedfield.setSize(150, 25);

        //Acceleration
        JLabel Accelerationlable = new JLabel("Acceleration:");
        rightpanel.add(Accelerationlable);
        Accelerationlable.setLocation(15, 470);
        Accelerationlable.setSize(150, 15);

        Accelerationfield  = new JTextField();
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

    public static void main(String[] args){
        new RaceFrame();
    }

    private void addRacersToArena() {
        for (Racer racer : racers) {
            try {
                arena.addRacer(racer);
                RacerImage(racer.className(),racer.getColor().toString(),(int)racer.getCurrentLocation().getX(),(int)racer.getCurrentLocation().getY());
                ActiveRacersAmount++;
            } catch (RacerLimitException e) {
                JOptionPane.showMessageDialog(this,"[Error] " + e.getMessage());

            } catch (RacerTypeException e) {
                JOptionPane.showMessageDialog(this,"[Error] " + e.getMessage());
            }
        }
    }
    private void UpdateRaceFrame() {
        ArrayList<Racer> racerARR= arena.getActiveRacers();
        for(int i =0;i<ActiveRacersAmount;i++) {
            if (racerARR.get(i).getCurrentLocation().getX() < arena.getLength() )
            RacerImeges.get(i).setLocation((int)racerARR.get(i).getCurrentLocation().getX(), (int) racerARR.get(i).getCurrentLocation().getY());
            else RacerImeges.get(i).setLocation((int)arena.getLength(), (int) racerARR.get(i).getCurrentLocation().getY());
        }
    }

}


