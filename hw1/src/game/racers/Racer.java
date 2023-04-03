//package name
package game.racers;

//imports
import game.arenas.Arena;
import utilities.Point;
import utilities.EnumContainer.Color;

//Racer-class
public abstract class Racer {


    private int serialNumber;
    private String name;
    private Point currentLocation;
    private Arena arena;
    private double maxSpeed;
    private double acceleration;
    private double currentSpeed;
    private double failureProbability;
    private Color color;
    //private Mishap mishap;

    //constructors
    public Racer() {
        this.serialNumber =0;// +1 everytime
        this.name = "noname";
        this.currentLocation = null;
        //this.arena = null;
        this.maxSpeed = 0;
        this.acceleration =0;
        this.currentSpeed = 0;
        this.failureProbability = 0;
        //this.enum COLOR;

        //this.mishap;
    }

    public Racer(String N, double MS, double ACC,Color color)
    {
        this.serialNumber =0;// +1 everytime
        this.name = N;
        this.currentLocation = null;
        //this.arena = null;
        this.maxSpeed = MS;
        this.acceleration =ACC;
        this.currentSpeed = 0;
        this.failureProbability = 0;
        this.Color=color;
        //this.mishap;
    }

    //getters


    //setters


    //methods
    public void initRace(Arena arena, Point start, Point finish) { }
    public Point move(double friction) { }


}
