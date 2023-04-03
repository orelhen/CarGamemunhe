//package name
package game.arenas;

//imports

import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import utilities.Point;

import java.util.ArrayList;


public abstract class Arena{

    private ArrayList<Racer> activeRacers;
    private ArrayList<Racer> completedRacers;
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
        this.activeRacers= new ArrayList<Racer>();
        this.completedRacers= new ArrayList<Racer>();
    }
    //1.1.4
    public Arena(double length, int maxRacers, double friction){

        this.MAX_RACERS =  maxRacers;
        this.length= length;
        this.FRICTION = friction;
        this.activeRacers= new ArrayList<Racer>();
        this.completedRacers= new ArrayList<Racer>();

    }

    public ArrayList<Racer> getActiveRacers(){return this.activeRacers;}


    public void addRacer(Racer newRacer) throws RacerLimitException,RacerTypeException {

        if(newRacer == null){
            throw new RacerTypeException("RacerTypeExeption");
        } else if (getActiveRacers().size() == MAX_RACERS) {
            throw new RacerLimitException("RacerLimitException");
        }
        else {
            this.activeRacers.add(newRacer);
        }

    }

    public void initRace() {
        //for each racer determain starting point, x= default 0, y = 0+distance
        //init race for each racer
        int i = 0;
        for (Racer racer : this.getActiveRacers()) {
            racer.initRace(this, new Point(0, i * MIN_Y_GAP), new Point(this.length, i * MIN_Y_GAP));
            i++;

        }
    }
    public boolean hasActiveRacers(){
        if (this.activeRacers!=null){return true;}
        else return false;
    }

    public void playTurn(){
        for (Racer racer : this.getActiveRacers()) {
            racer.move(FRICTION);
        }

    }


    public void crossFinishLine(Racer racer){
        //racer finish
    }


    public void showResults(){
        //print game results
        for (int i = 0; i< this.completedRacers.size(); i++) {
            System.out.printf(i+": ");
            this.completedRacers.get(i).introduce();
        }
    }


}



























