package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;

//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
public class Car extends Racer implements LandRacer
{

    private static final String CLASS_NAME = "Car";
    private static final int DEFAULT_WHEELS = 4;
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION =20;
    private static final Color DEFAULT_COLOR = Color.RED;
    private Wheeled wheeled;
    private EnumContainer.Engine engine = EnumContainer.Engine.FOURSTROKE;

    //constructors
    public Car()
    {
        super(CLASS_NAME ,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_COLOR);
        this.wheeled=new Wheeled(DEFAULT_WHEELS);
    }

    /**
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public Car(String name, double maxSpeed, double acceleration,Color color, int numOfWheels){
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheels);

    }

    public EnumContainer.Engine getEngine() {
        return engine;
    }

    /**
     * @param engine
     * @return
     */
    public boolean setEngine(EnumContainer.Engine engine) {
        if(engine!=null) {
            this.engine = engine;
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    @Override
    public String describeSpecific() {
        return this.wheeled.describeSpesific() + ", Engine Type: " + this.getEngine();
    }

    /**
     * @return
     */
    @Override
    public String className() {
        return "Car";
    }
}
