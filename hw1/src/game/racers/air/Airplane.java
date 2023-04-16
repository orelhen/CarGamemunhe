package game.racers.air;

//imports
import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;
import static utilities.EnumContainer.Color.BLACK;

//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
public class Airplane extends Racer implements AerialRacer {
    private static final String CLASS_NAME = "Airplane";
    private static final int DEFAULT_MAX_SPEED=885;
    private static final double DEFAULT_ACCELERATION=100;
    private static final EnumContainer.Color DEFUALT_color = BLACK;
    private static final int DEFUALT_WHEELS =3;
    public Wheeled wheeled;



    //Constructors :

    public Airplane() {
        super(CLASS_NAME,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFUALT_color);
        this.wheeled=new Wheeled(DEFUALT_WHEELS);
    }

    /**
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     */
    public Airplane(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheels);
    }
//getters


    public Wheeled getWheeled() {
        return wheeled;
    }

    /**
     * @return
     */
    //methods
    @Override
    public String describeSpecific() {
        return getWheeled().describeSpesific() ;
    }

    /**
     * @return
     */
    @Override
    public String className() {
        return "AirPlane";
    }
}
