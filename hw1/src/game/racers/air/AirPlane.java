package game.racers.air;
import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;

import static utilities.EnumContainer.Color.BLACK;

public class AirPlane extends Racer implements AerialRacer {
    private static final String CLASS_NAME = "Airplane";
    private static final int DEFAULT_MAX_SPEED=885;
    private static final double DEFAULT_ACCELERATION=100;
    private static final EnumContainer.Color DEFUALT_color = BLACK;
    private static final int DEFUALT_WHEELS =3;
    public Wheeled wheeled;



    //Constructors :

    public AirPlane() {
        super(CLASS_NAME,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFUALT_color);
        this.wheeled=new Wheeled(DEFUALT_WHEELS);
    }

    public AirPlane(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
        super(name,maxSpeed,acceleration,color);
        this.wheeled=new Wheeled(numOfWheels);
    }


}
