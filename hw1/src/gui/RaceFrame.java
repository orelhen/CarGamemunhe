package gui;



/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */

//imports
import arenas.Arena;
import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;
import dp.ActiveState;
import dp.BrokenState;
import dp.CompletedState;
import dp.DisabledState;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Comparator;
import java.util.Random;
import javax.swing.table.TableRowSorter;


public class RaceFrame extends JFrame implements ActionListener {
    public static RaceBuilder getBuilder() {
        return builder;
    }

    private static RaceBuilder builder = RaceBuilder.getInstance();
    private static JFrame MainFrame ;
    private static JFrame ResFrame;
    private static Racer racer;
    private static ArrayList<Racer> racersArr =new ArrayList<Racer>();;

    public static void setArena(Arena arena) {
        RaceFrame.arena = arena;
    }

    private static Arena arena;
    private ImageIcon racersImages[] = null;
    private String[] ARacernames = {};
    private int ArenaLength = 1000;
    private int ArenaHeight = 700;
    private int maxRacers = 8;
    private JComboBox SelectArena ;
    private JComboBox SelectShortcut;
    private JTextField ArenaLengthfield;
    private JTextField MaxRaceersfield;
    private JComboBox SelectRacer;
    private JComboBox SelectColor;
    private JComboBox SelectColorClone;
    private JComboBox ActiveRacersCombobox;
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

    public static LocalDateTime getStartTime() {
        return startTime;
    }
    private static LocalDateTime startTime;

    /**
     * constructor
     */
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

    /**
     * initalizing main frame
     * adding all lables,fields and buttons
     */
    //MainFrame
    public JFrame getframe() {
        setPreferredSize(new Dimension(1400 , 700));
        //setResizable(false);




        //main RaceFrame
        arenaPanel = new JPanel();
        arenaPanel.setLayout(null);
        arenaPanel.setPreferredSize(new Dimension(1000 , 700));
        arenaPanel.setVisible(true);
        add(arenaPanel, BorderLayout.WEST);

        //right side panel
        JPanel rightpanel = new JPanel();
        rightpanel.setSize(400, 700);
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

        ArenaLengthfield = new JTextField();
        rightpanel.add(ArenaLengthfield);
        ArenaLengthfield.setLocation(10, 80);
        ArenaLengthfield.setSize(150, 25);

        //Max arena racers
        JLabel MaxRaceerslable = new JLabel("Max racers number:");
        rightpanel.add(MaxRaceerslable);
        MaxRaceerslable.setLocation(15, 110);
        MaxRaceerslable.setSize(150, 15);

        MaxRaceersfield = new JTextField();
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


        //hw3
        //seperator line

        JSeparator Seperator3 = new JSeparator(SwingConstants.VERTICAL);
        rightpanel.add(Seperator3);
        Seperator3.setLocation(200, 0);
        Seperator3.setSize(10, 700);

//
        JLabel QuickClable = new JLabel("Quick Create:");
        rightpanel.add(QuickClable);
        QuickClable.setLocation(220, 15);
        QuickClable.setSize(150, 15);

        //quickCreateoptions
        String[] shortcutnames = {"Land","Air", "Naval"};
        SelectShortcut = new JComboBox(shortcutnames);
        rightpanel.add(SelectShortcut);
        SelectShortcut.setLocation(215, 30);
        SelectShortcut.setSize(150, 25);

        //Prototype btn
        //build arena btn
        JButton PrototypeBut = new JButton("Prototype");
        rightpanel.add(PrototypeBut);
        PrototypeBut.setLocation(215, 80);
        PrototypeBut.setSize(150, 30);
        PrototypeBut.addActionListener(this::Prototype);


        // active racers lable
        JLabel ActiveRacersLabel = new JLabel("Active Racers:");
        rightpanel.add(ActiveRacersLabel);
        ActiveRacersLabel.setLocation(220, 115);
        ActiveRacersLabel.setSize(150, 15);

        //ActiveRacers Combobox
        ActiveRacersCombobox = new JComboBox();
        rightpanel.add(ActiveRacersCombobox);
        ActiveRacersCombobox.setLocation(215, 130);
        ActiveRacersCombobox.setSize(150, 25);

        //Choose Color Clone lable
        JLabel ChooseColorClone = new JLabel("Clone color:");
        rightpanel.add(ChooseColorClone);
        ChooseColorClone.setLocation(215, 170);
        ChooseColorClone.setSize(150, 15);

        //CloneColor
        SelectColorClone = new JComboBox(colors);
        rightpanel.add(SelectColorClone);
        SelectColorClone.setLocation(215, 200);
        SelectColorClone.setSize(150, 25);

        //Clone btn
        JButton CloneBut = new JButton("Clone");
        rightpanel.add(CloneBut);
        CloneBut.setLocation(215, 240);
        CloneBut.setSize(150, 30);
        CloneBut.addActionListener(this::Clone);


        //ArenaFactoryBtn
        JButton FactoryBtn = new JButton("ArenaFactory");
        rightpanel.add(FactoryBtn);
        FactoryBtn.setLocation(215, 280);
        FactoryBtn.setSize(150, 30);
        FactoryBtn.addActionListener(this::CallArenaFactory);

        //BuilderBtn
        JButton Builderbtn = new JButton("Builder");
        rightpanel.add(Builderbtn);
        Builderbtn.setLocation(215, 320);
        Builderbtn.setSize(150, 30);
        Builderbtn.addActionListener(this::Builder);




        return MainFrame;
    }

    /**
     * @param e the event to be processed
     * overide
     */
    //methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * @param e
     * build arena button - on click
     * checking all inputs of build arena action
     * trying to create an arena object
     * calling arena image func.
     */
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
                ActiveRacersCombobox.removeAllItems();
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                     | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {

                JOptionPane.showMessageDialog(this, "Inviald input values! Please try again.");
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Race Started - wait for finish");
    }

    /**
     * adding new arena image to frame by input.
     * handle vaild arena sizes required
     * @param Atype
     * @param W
     * @param H
     */
    public void ArenaImage(String Atype,int W,int H){
        //add image
        arenaPanel.removeAll();
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("icons/"+Atype+".jpg").getImage()
                .getScaledInstance(W+70, H, Image.SCALE_DEFAULT));
        Arenapic = new JLabel(imageIcon1);
        Arenapic.setLocation(0, 0);
        Arenapic.setSize(W+70, H);
        if(H<700)
            this.setSize(470+W,700);
        else this.setSize(470+W,H);
        arenaPanel.setPreferredSize(new Dimension(W+70 , H));
        arenaPanel.add(Arenapic);
        setResizable(false);
        ActiveRacersAmount = 0;
        RaceStarted = false;
        RacerImeges = new ArrayList<JLabel>();
    }

    /**
     * add racer button - on click
     * checking all imputs of add racer action
     * trying to create a racer object
     * calling addr or addwr
     * calling racer image function
     * @param e
     */
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
            if(e1.getMessage()== "ivaild input values for Racer ,please try again."||e1.getMessage() =="Please build arena first to add racers!")
                JOptionPane.showMessageDialog(this,e1.getMessage());
            else
                JOptionPane.showMessageDialog(this,"please fill Racer information fields.");
        }}
        else
        JOptionPane.showMessageDialog(this,"Race Started - wait for finish.");
    }

    /**
     * adding new racer image to frame by input
     * handle vailed racer inputs
     * @param RacerType
     * @param RacerColor
     * @param CurrentX
     * @param CurrentY
     */
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

    /**
     * creating a racer acording to inputs
     * calling addRacerstoarena
     * @param rt
     * @param name
     * @param mSpeed
     * @param Acc
     * @param NewColor
     */
    //add racers methods
    public void addR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor){
        try {
            racer=builder.buildRacer("game.racers."+ rt, name, mSpeed, Acc, NewColor);
            racer.setArena(arena);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this,"Unable To add Racer");
        }
    }

    /**
     * creating a wheeled racer acording to inputs
     * calling addRacerstoarena
     * @param rt
     * @param name
     * @param mSpeed
     * @param Acc
     * @param NewColor
     * @param Numofwheels
     */
    public void addWR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor,int Numofwheels){
        try {
            racer=builder.buildWheeledRacer("game.racers."+rt, name, mSpeed, Acc,NewColor, Numofwheels);
            racer.setArena(arena);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1)
        {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(this,"Unable To add Racer");
        }
    }

    /**
     *adding new instance of racer to arena created.
     * handle invaild inputs
     */
    public void addRacersToArena() {
            try {
                arena.addRacer(racer);

                //clone racer name and add to combobox
                String[] newArray = new String[ARacernames.length + 1];
                for (int i = 0; i < ARacernames.length; i++) {
                    newArray[i] = ARacernames[i];
                }
                newArray[newArray.length - 1] = racer.getName();
                ARacernames = newArray;
                ActiveRacersCombobox.addItem(racer.getName());


                RacerImage(racer.className(),racer.getColor().toString(),(int)racer.getCurrentLocation().getX(),(int)racer.getCurrentLocation().getY());
                ActiveRacersAmount =arena.getActiveRacers().size();
            } catch (RacerLimitException e) {
                JOptionPane.showMessageDialog(this,"[Error] " + e.getMessage());

            } catch (RacerTypeException e) {
                JOptionPane.showMessageDialog(this,"[Error] " + e.getMessage());
            }
    }

    /**
     * start racer button -  on click
     * handles all invaild starting situations
     * for each racer active, starts a new runnable thread
     * initialzing race
     * @param e
     */
    //Start Racer Btn ON-CLICK
    public void StartAction(ActionEvent e) {
        if(arena !=null) {
            if (ActiveRacersAmount != 0){
                if(RaceStarted == false) {
                    if (NewArena == true) {
                        NewArena = false;
                        RaceStarted = true;
                        System.out.println("New Race Started");
                        startTime = LocalDateTime.now();
                        //update raceFrame Thread - 30 miliseconds refreshrate
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (RaceStarted) {
                                    UpdateRaceFrame();
                                    try {
                                        Thread.sleep(30);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            }
                        }).start();

                        for (Racer racer : arena.getActiveRacers()) {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    while (racer.getCurrentLocation().getX() < arena.getLength()) {
                                        //activate RacerMove Thread - 100 miliseconds refreshrate
                                        if(!(racer.getState() instanceof DisabledState)){
                                        racer.move(arena.getFRICTION());}

                                        try {
                                            Thread.sleep(100);
                                        } catch (InterruptedException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    arena.crossFinishLine(racer);
                                    racer.setState(new CompletedState());
                                    racer.getState().handleStateChange(racer, arena);

                                }
                            }).start();
                        }
                    } else
                        JOptionPane.showMessageDialog(this,"Race has ended - create new arena.");
                }else
                    JOptionPane.showMessageDialog(this, "Race in progress - wait for finish." );
            }else
            JOptionPane.showMessageDialog(this, "Please add Racer to Arena.");
        }else
            JOptionPane.showMessageDialog(this, "Please Build arena first.");
    }

    /**
     * absurvable thread for showRes button
     * thread collects all information from race data
     * opens a new window to absurve, showing all invormation
     * and then stop.
     */
    //Show results ON-CLICK
    public class AbsurvablleThread extends Thread {
        private volatile boolean running = true;
        @Override
        public void run() {

            while (running) {
                showRes();
                running = false;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        public void showRes() {

            //result frame
            ResFrame = new JFrame("Racer information");
            ResFrame.setLocation(50, 500);
            ResFrame.setResizable(false);

            DefaultTableModel tableModel = new DefaultTableModel(0, 5) ;

            String[] row = {"name", "speed", "Mspeed", "location", "Result"};

            tableModel.setColumnIdentifiers(row);
            JTable table = new JTable(tableModel);

            // Create a TableRowSorter and associate it with the table model
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
            table.setRowSorter(sorter);
            // Set custom comparator for the "location" column
            sorter.setComparator(3, (o1, o2) -> {
                String s1 = o1.toString();
                String s2 = o2.toString();
                if (s1.equalsIgnoreCase("Location")) s1 = "-1"; // Treat "Location" as a lower value
                if (s2.equalsIgnoreCase("Location")) s2 = "-1";
                Integer i1 = Integer.parseInt(s1);
                Integer i2 = Integer.parseInt(s2);
                return i2.compareTo(i1); // Compare in reverse order for descending sort
            });

            JScrollPane scrollPane = new JScrollPane(table);

            int counter = 1;
            for (Racer racer : arena.getCompletedRacers()) {
                int location = (int) racer.getCurrentLocation().getX();
                if(location >= arena.getLength()) location = (int) arena.getLength();
                String[] tempRow = {racer.getName(), String.valueOf((int)racer.getCurrentSpeed()), String.valueOf(racer.getMaxSpeed()), String.valueOf(location),"#"+String.valueOf(counter)+" Racer"};
                tableModel.addRow(tempRow);
                counter++;
            }
            for (Racer racer : arena.getActiveRacers()) {
                int location = (int) racer.getCurrentLocation().getX();
                String racerstate = "";
                if(racer.getState() instanceof DisabledState){
                    racerstate ="Failed";
                }
                if(location < arena.getLength()){
                String[] tempRow = {racer.getName(), String.valueOf((int)racer.getCurrentSpeed()), String.valueOf(racer.getMaxSpeed()), String.valueOf(location), racerstate};
                tableModel.addRow(tempRow);
                counter++;
                //racer.getState().handleStateChange(racer,arena);
                }

            }

            ResFrame.add(scrollPane, BorderLayout.CENTER);
            ResFrame.setSize(500,300);
            ResFrame.setVisible(true);

            //sort by location

            sorter.toggleSortOrder(3);
        }

    }

    /**
     * show results button - on click
     * handles vaild results situations
     * creates a new absurvabble thread - show res thread
     * @param e
     */
    public void ShowRes(ActionEvent e){
        if(arena != null&& ActiveRacersAmount>0) {
            AbsurvablleThread thread = new AbsurvablleThread();
            thread.start();
        }
        else
            JOptionPane.showMessageDialog(this,"No race in progress.");
    }

    /**
     * update frame
     * moves all racer images location acording to initialized race data by threads
     * when racer cross finishline, notices that the race had ended
     */
    //update Frame progression
    public void UpdateRaceFrame() {
        int didnotfinish =0;
        ArrayList<Racer> racerARR= arena.getActiveRacers();
        for(int i =0;i<ActiveRacersAmount;i++) {
            if (racerARR.get(i).getCurrentLocation().getX() < arena.getLength() && (racerARR.get(i).getState() instanceof ActiveState
                    || racerARR.get(i).getState() instanceof BrokenState)){
            RacerImeges.get(i).setLocation((int)racerARR.get(i).getCurrentLocation().getX(), (int) racerARR.get(i).getCurrentLocation().getY());
            didnotfinish++;}

        }
        if(didnotfinish == 0)RaceStarted=false;

    }



//PART 3

    /**
     * @param e
     *Prototype btn on-click
     *Reciving Arena info and creating a prototype Racer for Requested input
     *generating random color , adding position to Cloned name
     */
    public void Prototype(ActionEvent e)
    {
        // works only for Air race
        if(RaceStarted==false){

            int Quick = SelectShortcut.getSelectedIndex();
            String Racertype = "";
            if (Quick == 1) {Racertype="air.Helicopter";}
            if (Quick == 2) {Racertype="naval.RowBoat";}
            if (Quick == 0) {Racertype="land.Car";}

            Random rand = new Random();

            int newcolor = rand.nextInt(5);
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

            try {
                if(arena==null||NewArena==false){throw new IllegalArgumentException("Please build arena first to add racers!");}

                if(Quick == 0){
                    addWR(Racertype, "Protytpe " + ActiveRacersAmount, 15, 3,NewColor,4);
                }else
                    addR(Racertype, "Protytpe " + ActiveRacersAmount, 15, 3, NewColor);
                racer.setCurrentLocation(new Point(0,70*ActiveRacersAmount));
                addRacersToArena();
                 }
            catch (IllegalArgumentException e1){
                if(e1.getMessage()== "ivaild input values for Racer ,please try again."||e1.getMessage() =="Please build arena first to add racers!")
                    JOptionPane.showMessageDialog(this,e1.getMessage());
                else
                    JOptionPane.showMessageDialog(this,"please fill Racer information fields.");
            }}
        else
            JOptionPane.showMessageDialog(this,"Race Started - wait for finish.");
    }

    /**
     * @param e
     * Clone btn on-click reciving inputs and cloning req Racer
     */
    public void Clone(ActionEvent e)
    {
        int CloneRacer = ActiveRacersCombobox.getSelectedIndex();
        if(RaceStarted==false ){
            try {
                int newcolor = SelectColorClone.getSelectedIndex();
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

                if(arena==null||NewArena==false){throw new IllegalArgumentException("Please build arena first to add racers!");}
                if(ActiveRacersAmount==0){throw new IllegalArgumentException("No Racer to clone");}
                racer = (Racer) arena.getActiveRacers().get(CloneRacer).clone();
                racer.setCurrentLocation(new Point(0,70*ActiveRacersAmount));
                racer.setColor(NewColor);
                racer.setName(racer.getName() + " "+ ActiveRacersAmount);
                addRacersToArena();
            }
            catch (CloneNotSupportedException | IllegalArgumentException e1){
                if(e1.getMessage()== "ivaild input values for Racer ,please try again."||e1.getMessage() =="Please build arena first to add racers!"||e1.getMessage() =="No Racer to clone")
                    JOptionPane.showMessageDialog(this,e1.getMessage());
                else
                    JOptionPane.showMessageDialog(this,"please fill Racer information fields.");
            }}
        else
            JOptionPane.showMessageDialog(this,"Race Started - wait for finish.");

    }

    /**
     * @param e
     *  Builder btn on-click calling ArenaFactory
     *  creating required arena
     */
    public void CallArenaFactory(ActionEvent e){
        if(RaceStarted==false) {
            NewArena = true;
            int Quick = SelectShortcut.getSelectedIndex();
            String ArenaType = "";
            String ImageType = "";
            if (Quick == 1) {
                ArenaType = "air.AerialArena";
                ImageType = "AerialArena";
            }
            if (Quick == 2) {
                ArenaType = "naval.NavalArena";
                ImageType = "NavalArena";
            }
            if (Quick == 0) {
                ArenaType = "land.LandArena";
                ImageType = "LandArena";
            }
            try {
                arena = builder.buildArena("arenas."+ArenaType , 1000, 10);
                ArenaImage(ImageType, 1000, 10 * 70 +30);
                RacerY = 0;
                ActiveRacersCombobox.removeAllItems();
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                     | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {

                JOptionPane.showMessageDialog(this, "Inviald input values! Please try again.");
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Race Started - wait for finish");

        }

    /**
     * @param e
     * Builder btn on-click calling ArenaFactory
     * then generating Prototypes for current arena
     *
     */
    public void Builder(ActionEvent e)
    {
        if(RaceStarted==false) {
        CallArenaFactory(e);
        for(int i = 0 ;i< arena.getMAX_RACERS();i++) {
            Prototype(e);
        }}
        else
            JOptionPane.showMessageDialog(this,"Race Started - wait for finish");
    }

}



