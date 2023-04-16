//package name
package game.arenas;

/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */

//imports

import game.arenas.air.AerialArena;
import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.arenas.land.LandArena;
import game.arenas.naval.NavalArena;
import game.racers.Racer;
import game.racers.air.AerialRacer;
import game.racers.land.LandRacer;
import game.racers.naval.NavalRacer;
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

//getters

public ArrayList<Racer> getActiveRacers(){return this.activeRacers;}

    public ArrayList<Racer> getCompletedRacers() {
        return completedRacers;
    }
    public double getFRICTION() {
        return FRICTION;
    }

    public double getLength() {
        return length;
    }

    public int getMAX_RACERS() {
        return MAX_RACERS;
    }

    public void initRace() {
        //for each racer determain starting point, x= default 0, y = 0+distance
        //init race for each racer
        int i = 0;
        for (Racer racer : this.getActiveRacers()) {
            racer.initRace(this, new Point(0, i * MIN_Y_GAP), new Point(getLength(), i * MIN_Y_GAP));
            i++;

        }
    }
    public boolean hasActiveRacers(){
        if (getActiveRacers().size() > 0){
            return true;
        }
        return false;
    }
//methods
public void addRacer(Racer newRacer) throws RacerLimitException,RacerTypeException {
        //checking racer type
    if(this instanceof AerialArena) { if(!(newRacer instanceof AerialRacer)){throw new RacerTypeException(""+newRacer.className(),"Aerial arena" );}}
    if(this instanceof NavalArena) { if(!(newRacer instanceof NavalRacer)){throw new RacerTypeException(""+newRacer.className(),"Naval arena");}}
    if(this instanceof LandArena) {  if(!(newRacer instanceof LandRacer) ){throw new RacerTypeException(""+newRacer.className(),"Land arena");}}
    //checking arena limits
    if (getActiveRacers().size() == getMAX_RACERS()) {
        throw new RacerLimitException(""+ this.getMAX_RACERS(),""+newRacer.getSerialNumber());
    }
    else {
       getActiveRacers().add(newRacer);
    }

}
    public void playTurn(){
        //while has active racers, game continues until finish
        while (hasActiveRacers()){
            for (int i=0; i < getActiveRacers().size() ; i++) {
                Point point = new Point(getActiveRacers().get(i).move(getFRICTION()));
                if (point.getX()>= getLength()) {
                    crossFinishLine( getActiveRacers().get(i));
                }
            }
        }
    }

    public void crossFinishLine(Racer racer){
        getCompletedRacers().add(racer);
        getActiveRacers().remove(racer);
    }

    public void showResults(){
        //print game results
        for (int i = 0; i<  getCompletedRacers().size(); i++) {
            System.out.println("#"+i+" -> "+  getCompletedRacers().get(i).PrintRacer() +  "," +  getCompletedRacers().get(i).describeSpecific());

        }
    }
}



























