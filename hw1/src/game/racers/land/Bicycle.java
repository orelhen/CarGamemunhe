package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;

//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
public class Bicycle extends Racer implements LandRacer{
    private static final String CLASS_NAME = "Bicycle";
    private static final int DEFAULT_WHEELS = 2;
    private static final double DEFAULT_MAX_SPEED = 270;
    private static final double DEFAULT_ACCELERATION =10;
    private static final EnumContainer.Color DEFAULT_COLOR = EnumContainer.Color.GREEN;
    private EnumContainer.BicycleType bicycleType = EnumContainer.BicycleType.MOUNTAIN;
    private Wheeled wheeled;

    public Bicycle()
    {
        super(CLASS_NAME,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_COLOR);
        this.wheeled=new Wheeled(DEFAULT_WHEELS);
    }

    /**
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public Bicycle(String name, double maxSpeed, double acceleration, EnumContainer.Color color, int numOfWheels) {
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheels);
    }

    public EnumContainer.BicycleType getBicycleType() {
        return bicycleType;
    }

    /**
     * @param bicycleType
     * @return
     */
    public boolean setBicycleType(EnumContainer.BicycleType bicycleType) {
        if (bicycleType!=null) {
            this.bicycleType = bicycleType;
            return true;
        }
        return false;
    }

    public Wheeled getWheeled() {
        return wheeled;
    }

    /**
     * @return
     */
    @Override
    public String describeSpecific() {
        return getWheeled() .describeSpesific() + ", Bicycle Type: " + getBicycleType();
    }

    /**
     * @return
     */
    @Override
    public String className() {
        return "Bicycle";
    }
}

