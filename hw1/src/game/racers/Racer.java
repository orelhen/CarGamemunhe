//package name
package game.racers;


/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */

//imports
import arenas.Arena;
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
        this.currentLocation = new Point();
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


    /**
     * @param failureProbability
     * @return
     */
    //setters
    public boolean  setFailureProbability(double failureProbability)
    { if(failureProbability>0 ){
            this.failureProbability = failureProbability;
            return true;
        }
        return false;
    }

    /**
     * @param serialNumber
     * @return
     */
    public boolean setSerialNumber(int serialNumber) {
        if(serialNumber>0 ){
            this.serialNumber = serialNumber;
            return true;
        }
        return false;
    }

    /**
     * @param name
     * @return
     */
    public boolean setName(String name) {
        if(name!=null ){
            this.name = name;
            return true;
        }
        return false;
    }

    /**
     * @param currentLocation
     * @return
     */
    public boolean setCurrentLocation(Point currentLocation) {
        if(currentLocation != null ){
            this.currentLocation = currentLocation;
            return true;
        }
        return false;
    }

    /**
     * @param finish
     * @return
     */
    public boolean setFinish(Point finish) {
        if(finish != null ){
            this.finish = finish;
            return true;
        }
        return false;
    }

    /**
     * @param arena
     * @return
     */
    public boolean setArena(Arena arena) {
        if(arena !=null ){

            this.arena = arena;
            return true;
        }
        return false;
    }

    /**
     * @param maxSpeed
     * @return
     */
    public boolean setMaxSpeed(double maxSpeed) {
        if(maxSpeed>0 ){
            this.maxSpeed = maxSpeed;
            return true;
        }
        return false;
    }

    /**
     * @param acceleration
     * @return
     */
    public boolean setAcceleration(double acceleration) {  //???????????????????????
        if(acceleration> 0){
            this.acceleration = acceleration;
            return true;
        }
        return false;
    }

    /**
     * @param currentSpeed
     * @return
     */
    public boolean setCurrentSpeed(double currentSpeed) {
        if(currentSpeed>0){
            this.currentSpeed = currentSpeed;
            //not more the max speed.
            if(currentSpeed>getMaxSpeed()){this.currentSpeed = maxSpeed;}
            return true;
        }
        return false;
    }

    /**
     * @param color
     * @return
     */
    public boolean setColor(Color color) {
        if( color !=null){
            this.color = color;
            return true;
        }
        return false;
    }

    /**
     * @param mishap
     * @return
     */
    public boolean setMishap(Mishap mishap) {
        if(mishap !=null ){
            this.mishap = mishap;
            return true;
        }
        return false;
    }

    /**
     * @param arena
     * @param start
     * @param finish
     */
    //methods
    public void initRace(Arena arena, Point start, Point finish)
    {
        this.arena = arena;
        this.currentLocation = start;
        this.finish = finish;
    }

    /**
     * @param friction
     *
     * @return
     */
    public Point move(double friction) {

        double reductionFactor = 1;//No mishap, no reduction factor

        //handle mishap
        if (hasMishap()){
            if(getMishap().isFixable()){
            reductionFactor = getMishap().getReductionFactor();
                getMishap().nextTurn();}
            else{ reductionFactor = getMishap().getReductionFactor();}
        }

        if(getCurrentSpeed()<getMaxSpeed()){
        setCurrentSpeed(getCurrentSpeed() + getAcceleration() * reductionFactor * friction);
        }

        if (hasMishap() && getMishap().isFixable() && getMishap().getTurnsToFix() == 0){
            setMishap(null);
        }

        //generate new mishap
        if (!hasMishap()){
            if(Fate.breakDown()){
                setMishap(Fate.generateMishap());
                System.out.println(getName()+" Has a new mishap!"+getMishap().toString());
            }
        }
        //create new point and return it.
        Point current = new Point(getCurrentLocation().getX()+getCurrentSpeed(),0);
        this.setCurrentLocation(current);
        return getCurrentLocation();

    }

    /**
     * @return
     */
    public abstract String describeSpecific();

    /**
     * @return
     */
    public String PrintRacer(){return " name : " + getName() + ", SerialNumber: " +getSerialNumber() + ", maxSpeed : " + getMaxSpeed() + ", acceleration: : " + getAcceleration() + ", color: " +getColor();}

    /**
     * @return
     */
    public String describeRacer()
    {
        if(describeSpecific()!=null) {
            return "["+this.className() +"]" + PrintRacer() + "," + describeSpecific();}
        else
            return "["+this.className() +"]" + PrintRacer();
    }

    /**
     *
     */
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
