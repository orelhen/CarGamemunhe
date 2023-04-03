package game.racers;

public class Wheeled //package
package game.racers;

//imports

public class Wheeled  {

    private int numOfWheels;

    //constructors
    wheeled( ){  this.numOfWheels = 0;}

    wheeled(int numOfW){this.numOfWheels = numOfW;}

    //getters
    public int getnumOfwheels(){return this.numOfWheels;}
    //setters
    public boolean setnumOfwheels(int newnum){
        if(newnum>0 && newnum<5)
        {this.numOfWheels=newnum; return true;}
        return false;}
    //methods
    public String describeSpesific(){};//?? ************************

}{
}
