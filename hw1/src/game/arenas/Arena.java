//package name
package game.arenas;

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

    public ArrayList<Racer> getActiveRacers(){return this.activeRacers;}


    public void addRacer(Racer newRacer) throws RacerLimitException,RacerTypeException {
        if(this instanceof AerialArena) { if(!(newRacer instanceof AerialRacer)){throw new RacerTypeException(""+newRacer.className(),"Aerial arena" );}}
        if(this instanceof NavalArena) { if(!(newRacer instanceof NavalRacer)){throw new RacerTypeException(""+newRacer.className(),"Naval arena");}}
        if(this instanceof LandArena) {  if(!(newRacer instanceof LandRacer) ){throw new RacerTypeException(""+newRacer.className(),"Land arena");}}
        if (getActiveRacers().size() == MAX_RACERS) {
            throw new RacerLimitException(""+ this.getMAX_RACERS(),""+newRacer.getSerialNumber());
        }
        else {
            this.activeRacers.add(newRacer);
        }

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
            racer.initRace(this, new Point(0, i * MIN_Y_GAP), new Point(this.length, i * MIN_Y_GAP));
            i++;

        }
    }
    public boolean hasActiveRacers(){
        if (getActiveRacers().size() == 0){
            return false;
        }
        return true;
    }

    public void playTurn(){
        while (this.activeRacers.size()> 0){
            for (int i=0; i < this.activeRacers.size() ; i++) {
                Point point = new Point(this.activeRacers.get(i).move(FRICTION));
                if (point.getX()>= getLength()) {
                    crossFinishLine(this.activeRacers.get(i));
                }
            }
        }
    }


    public void crossFinishLine(Racer racer){
        this.completedRacers.add(racer);
        this.activeRacers.remove(racer);
    }


    public void showResults(){
        //print game results
        for (int i = 0; i< this.completedRacers.size(); i++) {
            System.out.println("#"+i+" -> "+"name : " + this.completedRacers.get(i).getName() + ", SerialNumber: " +this.completedRacers.get(i).getSerialNumber() + ", maxSpeed : " + this.completedRacers.get(i).getMaxSpeed() + ", acceleration: : " + this.completedRacers.get(i).getAcceleration() + ", color: " +this.completedRacers.get(i).getColor() +  "," + this.completedRacers.get(i).describeSpecific());

        }
    }
}



























