//package:
package game.racers;
//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */

public class Wheeled  {

    private int numOfWheels;

    //constructors
    public  Wheeled( ){  this.numOfWheels = 0;}

    /**
     * @param numOfW
     */
    public  Wheeled(int numOfW){this.numOfWheels = numOfW;}

    /**
     * @return
     */
    //getters
    public int getnumOfwheels(){return this.numOfWheels;}

    /**
     * @param newnum
     * @return
     */
    //setters
    public boolean setnumOfwheels(int newnum){
        if(newnum>0 && newnum<5)
        {this.numOfWheels=newnum; return true;}
        return false;}

    /**
     * @return
     */
    //methods
    public String describeSpesific(){
        return " Number of Wheels: " + this.getnumOfwheels();
    };

}

