package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import utilities.EnumContainer;
import utilities.EnumContainer.Color;

public class Car extends Racer implements LandRacer
{

    private static final String CLASS_NAME = "car";
    private static final int DEFAULT_WHEELS = 4;
    private static final double DEFAULT_MAX_SPEED = 400;
    private static final double DEFAULT_ACCELERATION =20;
    private static final Color DEFAULT_COLOR = Color.RED;
    private Wheeled wheeled;
    private EnumContainer.Engine engine = EnumContainer.Engine.FOURSTROKE;

    //constructors
    public Car(){

    };
    public Car(String name, double maxSpeed, double acceleration,Color color, int numOfWheels){


    }





}
