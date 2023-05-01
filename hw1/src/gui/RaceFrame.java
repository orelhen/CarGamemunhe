package gui;


//imports
import game.arenas.Arena;
import game.arenas.air.AerialArena;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;
import game.factory.RaceBuilder;
import game.racers.Racer;
import utilities.EnumContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class RaceFrame extends JFrame implements ActionListener {
    //disable main
    private static RaceBuilder builder = RaceBuilder.getInstance();
    private static JFrame MainFrame ;
    private static ArrayList<Racer> racers;
    private static Arena arena=null;
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
    public RaceFrame() {
        super("Race");
        MainFrame =getframe();
        this.pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        racers = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {



    }
    public void BuildArenaAction(ActionEvent e) {

        int chosenArena = SelectArena.getSelectedIndex();
        String ArenaType="";
        if(chosenArena == 0){ArenaType = "air.AerialArena"; }
        if(chosenArena == 1){ArenaType = "naval.NavalArena"; }
        if(chosenArena == 2){ArenaType = "land.LandArena"; }

        //get and convert text for Len
        ArenaLength =Integer.parseInt(ArenaLengthfield.getText());
        //get and convert text for Maxracers
        maxRacers =Integer.parseInt(MaxRaceersfield.getText());

        try {
            arena = builder.buildArena("game.arenas."+ArenaType, ArenaLength, maxRacers);
            System.out.println(ArenaType+" succecfully created , Len:" + ArenaLength + " , MaxRacers:" + maxRacers );

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
            System.out.println("Unable to build arena!");
        }

    }
    public void AddRacer(ActionEvent e) {

        int newRacer = SelectRacer.getSelectedIndex();
        int newcolor = SelectColor.getSelectedIndex();
        EnumContainer.Color NewColor = null;
        if(newcolor == 0){NewColor = EnumContainer.Color.BLACK;}
        if(newcolor == 1){NewColor = EnumContainer.Color.RED;}
        if(newcolor == 2){NewColor = EnumContainer.Color.GREEN;}
        if(newcolor == 3){NewColor = EnumContainer.Color.BLUE;}
        if(newcolor == 4){NewColor = EnumContainer.Color.YELLOW;}
        
        String RacerName=Namefield.getText();
        int Mspeed = Integer.parseInt(Speedfield.getText());
        int Acc = Integer.parseInt(Accelerationfield.getText());
        if(newRacer == 0){addWR("air.Airplane",RacerName,Mspeed,Acc,NewColor);}
        if(newRacer == 1){addR("air.Helicopter",RacerName,Mspeed,Acc,NewColor);}
        if(newRacer == 2){addWR("land.Bicycle",RacerName,Mspeed,Acc,NewColor);}
        if(newRacer == 3){addWR("land.Car",RacerName,Mspeed,Acc,NewColor);}
        if(newRacer == 4){addR("land.Horse",RacerName,Mspeed,Acc,NewColor);}
        if(newRacer == 5){addR("naval.RowBoat",RacerName,Mspeed,Acc,NewColor);}
        if(newRacer == 6){addR("naval.SpeedBoat",RacerName,Mspeed,Acc,NewColor);}

        //addRacersToArena();
    }
    void addR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor ){
        try {
            racers.add(builder.buildRacer("game.racers."+ rt, name, mSpeed, 8, NewColor));
            System.out.println("new racer" + rt + " " + name + " created, ms:" + mSpeed+"  acc:" + Acc + "  colo:" + NewColor);

        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }
    void addWR(String rt,String name,int mSpeed,int Acc,EnumContainer.Color NewColor){
        try {
            racers.add(builder.buildWheeledRacer("game.racers."+rt, name, mSpeed, 1,NewColor, 3));
            System.out.println("new racer" + rt + " " + name + " created, ms:" + mSpeed+"  acc:" + Acc + "  colo:" + NewColor);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                 | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
            e1.printStackTrace();
        }
    }

    public JFrame getframe() {

        //main RaceFrame
        MainFrame = new JFrame();
        MainFrame.setLayout(null);
        MainFrame.setVisible(true);
        MainFrame.setSize(1100, 700);
        MainFrame.setResizable(false);
        MainFrame.setTitle("Race");


        //right side panel
        JPanel rightpanel = new JPanel();
        rightpanel.setBounds(900, 0, 200, 700);
        rightpanel.setBackground(Color.lightGray);
        rightpanel.setLayout(null);

        //adding new panel to main frame
        MainFrame.add(rightpanel);

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
        //StartBut.addActionListener(this);

        //Show info btn
        JButton infoBut = new JButton("Show Info");
        rightpanel.add(infoBut);
        infoBut.setLocation(10, 625);
        infoBut.setSize(150, 30);
        //infoBut.addActionListener(this);

        return MainFrame;
    }

    public static void main(String[] args){
        new RaceFrame();
    }



}

