//package name
package game.racers;

//imports
import game.arenas.Arena;
import utilities.Point;
import utilities.EnumContainer.Color;
import utilities.Mishap;

//Racer-class
public abstract class Racer {


    private int serialNumber;
    private String name;
    private Point currentLocation;
    private Point finish;
    private Arena arena;
    private double maxSpeed;
    private double acceleration;
    private double currentSpeed;
    private double failureProbability;
    private Color color;
    private Mishap mishap;


    //constructor

    public Racer(String N, double MS, double ACC,Color color)
    {
        this.name = N;
        this.maxSpeed=MS;
        this.acceleration =ACC;
        this.color = color;
    }

    //getters

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public Point getFinish() {
        return finish;
    }

    public Arena getArena() {
        return arena;
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getFailureProbability() {
        return failureProbability;
    }

    public Color getColor() {
        return color;
    }

    public Mishap getMishap() {
        return mishap;
    }


    //setters
    public boolean  setFailureProbability(double failureProbability) //??????????????
    {
        if(failureProbability>0 ){
            this.failureProbability = failureProbability;
            return true;
        }
        return false;

    }

    public boolean setSerialNumber(int serialNumber) {//??????????????
        if(serialNumber>0 ){
            this.serialNumber = serialNumber;
            return true;
        }
        return false;
    }

    public boolean setName(String name) {
        if(name!=null ){
            this.name = name;
            return true;
        }
        return false;
    }

    public boolean setCurrentLocation(Point currentLocation) {
        if(currentLocation != null ){
            this.currentLocation = currentLocation;
            return true;
        }
        return false;
    }

    public boolean setFinish(Point finish) {
        if(finish != null ){
            this.finish = finish;
            return true;
        }
        return false;
    }

    public boolean setArena(Arena arena) {
        if(arena !=null ){

            this.arena = arena;
            return true;
        }
        return false;
    }
    public boolean setMaxSpeed(double maxSpeed) {
        if(maxSpeed>0 ){
            this.maxSpeed = maxSpeed;
            return true;
        }
        return false;
    }

    public boolean setAcceleration(double acceleration) {  //???????????????????????
        if(acceleration> 0){
            this.acceleration = acceleration;
            return true;
        }
        return false;
    }

    public boolean setCurrentSpeed(double currentSpeed) {
        if(currentSpeed>0){
            this.currentSpeed = currentSpeed;
            return true;
        }
        return false;
    }

    public boolean setColor(Color color) {
        if( color !=null){
            this.color = color;
            return true;
        }
        return false;
    }

    public boolean setMishap(Mishap mishap) {
        if(mishap !=null ){
            this.mishap = mishap;
            return true;
        }
        return false;
    }



    //methods
    public void initRace(Arena arena, Point start, Point finish) {}
    public Point move(double friction) {}
    public String describeSpecific(){}
    public String describeRacer(){}

    public void intreduce(){}

    public String className(){}

    public boolean hasMishap(){}




































}
