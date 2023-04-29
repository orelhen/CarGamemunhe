package gui;


//imports
import game.arenas.air.AerialArena;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;

import javax.swing.*;
import java.awt.*;

public class RaceFrame  {
    public static void main(String[] args){


        //main RaceFrame
        JFrame frame = new JFrame();
        frame.setTitle("Race");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(1100,700);

        //right side panel
        JPanel rightpanel = new JPanel();
        rightpanel.setBounds(900,0,200,700);
        rightpanel.setVisible(true);
        rightpanel.setBackground(Color.lightGray);
        frame.add(rightpanel);

        //Choose Arena ComboBox
        String[] Arenanames =  {"AerialArena", "NavalArena", "LandArena"};
        JComboBox SelectArena = new JComboBox(Arenanames);
        rightpanel.add(SelectArena);
        SelectArena.setBounds(10,100,100,50);
        SelectArena.setVisible(true);




    }



}
