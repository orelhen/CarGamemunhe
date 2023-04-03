//package name
package game.arenas;

//imports

import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import java.util.ArrayList;


public abstract class Arena{

    private ArrayList<Racer> ActiveRacers;
    private ArrayList<Racer> CompletedRacers;
    private final double FRICTION;
    private final int MAX_RACERS;
    private final static int MIN_Y_GAP =10;
    private double length;


    //constructors
    //default
    public Arena()
    {
        this.MAX_RACERS =  0;
        this.length= 0;
        this.FRICTION = 0;
        this.ActiveRacers=null;
        this.CompletedRacers=null;
    }
    //1.1.4
    public Arena(double length, int maxRacers, double friction){

        this.MAX_RACERS =  maxRacers;
        this.length= length;
        this.FRICTION = friction;
        this.ActiveRacers=null;
        this.CompletedRacers=null;

    }


    public void addRacer(Racer newRacer) throws RacerLimitException,RacerTypeException {
        if(ActiveRacers.size()>this.MAX_RACERS){throw new RacerLimitException("error");}
        //if()???????????????????
    }

    public void initRace(){
        //for each racer determain starting point, x= default 0, y = 0+distance
        int i =0;
       // while(ActiveRacers[i]!=null){ActiveRacers[i].initRace(this,);}
        //init race for each racer
    }

    public boolean hasActiveRacers(){
        if (this.ActiveRacers!=null){return true;}
        else return false;
    }

    public void playTurn(){
        //for each player activate movement func
        //update after each game
    }


    public void crossFinishLine(Racer racer){
        //racer finish
    }


    public void showResults(){
        //print game results

    }


}



























