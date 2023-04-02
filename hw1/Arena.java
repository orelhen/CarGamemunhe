//package name
package game.arenas;

//imports
import java.util.ArrayList;
import game.racers.Racer;


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
        //this.ActiveRacers
        //this.CompletedRacers
    }
    //1.1.4
    public Arena(double length, int maxRacers, double friction){

        this.MAX_RACERS =  maxRacers;
        this.length= length;
        this.FRICTION = friction;
        //this.ActiveRacers
        //this.CompletedRacers

    }

    //getters
    public ArrayList<Racer> GetActiveRacers() {

        return this.ActiveRacers;
    }

    public ArrayList<Racer> GetCompletedRacers() {

        return this.CompletedRacers;
    }/*
    public double GetFriction(){ }
    public int GetMaxRacers(){ }
    public int GetMinYgap(){ }
    public double Getlength(){ }
    */
    //setters
    /*
    public boolean SetActiveRacers() {}
    public boolean SetCompletedRacers(){}
    public boolean SetFriction(){}
    //finals
    //public boolean SetMaxRacers(){}
    //public boolean SetMinYgap(){}
    //public boolean Setlength(){}
   */

    public void addRacer(Racer newRacer)
    {
        //throwables
        //RacerTypeExeption
        //RacerLimitException
    }

    public void initRace(){
        //for each racer determain starting point, x= default 0, y = 0+distance

        //init race for each racer
    }

    public boolean hasActiveRacers(){
        if this.ActiveRacers!=NULL{return true;}
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



























