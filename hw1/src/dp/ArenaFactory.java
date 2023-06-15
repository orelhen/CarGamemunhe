package dp;

import arenas.Arena;
import arenas.air.AerialArena;
import arenas.land.LandArena;
import arenas.naval.NavalArena;
import gui.RaceFrame;

public class ArenaFactory extends RaceFrame {


    public Arena getArena(String condition,int num)
    {
        Arena choosen=null;
        if("Land".equals(condition))
            choosen=new LandArena(800,num);
        else if ("Aerial".equals(condition)) {
            choosen=new AerialArena(1500,num);
        }
        else
        {
            choosen=new NavalArena(1000,num);
        }
        return choosen;
    }

}
