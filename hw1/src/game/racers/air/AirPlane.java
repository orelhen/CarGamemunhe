package game.racers.air;
import game.racers.Racer;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;

import static utilities.EnumContainer.Color.BLACK;

public class AirPlane extends Racer {
    private static final String CLASS_NAME = "Airplane";
    private static final int DEFAULT_MAX_SPEED=885;
    private static final double DEFAULT_ACCELERATION=100;
    private static final EnumContainer.Color DEFUALT_color = BLACK;
    private static final int DEFUALT_WHEELS =3;



    //Constructors :

    public AirPlane() {
    }

    public AirPlane(String name, double maxSpeed, double acceleration, Color color, int numOfWheels) {
        super(name,maxSpeed,acceleration,color,numOfWheels);
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name != null) {
            this.name = name;
            return true;
        }
        return false;
    }

}
