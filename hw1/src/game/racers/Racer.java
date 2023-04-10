//package name
package game.racers;

//imports
import game.arenas.Arena;
import utilities.Fate;
import utilities.Point;
import utilities.EnumContainer.Color;
import utilities.Mishap;

//Racer-class
public abstract class Racer {

    private static int serial = 1; // STATIC???? not writen
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

        this.serialNumber=serial;
        if(N == this.className()){this.name = N + " #"+serialNumber;}
        else{this.name = N;}
        this.maxSpeed=MS;
        this.acceleration =ACC;
        this.color = color;
        this.serial++;
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
    public void initRace(Arena arena, Point start, Point finish)
    {
        this.arena = arena;
        this.currentLocation = start;
        this.finish = finish;
    }
    public Point move(double friction) {

        double reductionFactor = 1; //If there is no mishap, then her factor will remain one, and will not affect the CurrentSpeed.

        if (mishap != null ){
            if(mishap.isFixable()){
            reductionFactor = this.mishap.getReductionFactor();
            this.mishap.nextTurn();}
            else{ reductionFactor = this.mishap.getReductionFactor();}
        }

        if(currentSpeed<this.maxSpeed){
        setCurrentSpeed(this.currentSpeed += this.acceleration * reductionFactor * friction);
        }
        if(currentSpeed>this.maxSpeed){this.currentSpeed = this.maxSpeed;}

        if (this.mishap != null && this.mishap.isFixable() && this.mishap.getTurnsToFix() == 0){
            this.mishap = null;
        }

        if (mishap==null){
            if(Fate.breakDown()){
                setMishap(Fate.generateMishap());
                System.out.println(this.name+" Has a new mishap!"+mishap.toString());
            }
        }

        Point current = new Point(this.currentLocation.getX()+this.currentSpeed,0);
        setCurrentLocation(current);
        return this.currentLocation;

    }

    public abstract String describeSpecific();

    public String describeRacer()
    {
        if(describeSpecific()!=null) {
            return "["+this.className() +"]" +" name : " + this.getName() + ", SerialNumber: " +getSerialNumber() + ", maxSpeed : " + this.getMaxSpeed() + ", acceleration: : " + this.getAcceleration() + ", color: " +this.color +  "," + this.describeSpecific();}
        else
            return "["+this.className() +"]" +" name : " + this.getName() + ", SerialNumber: " +getSerialNumber() + ", maxSpeed : " + this.getMaxSpeed() + ", acceleration: : " + this.getAcceleration() + ", color: " +this.color;
    }

    public void introduce(){
        System.out.println(describeRacer());
    }

    public abstract String className();
    public boolean hasMishap(){
        if (this.mishap!=null)
                return true;
        return false;
    }
























}
