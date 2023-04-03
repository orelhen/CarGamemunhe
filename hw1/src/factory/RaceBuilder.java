package factory;


//imports
import game.arenas.Arena;
import game.racers.Racer;

public class RaceBuilder {
    private static RaceBuilder instance;
    private ClassLoader classLoader; // *****************************
    private Class<?> classObject;
    private Constructor<?> consctructor;


    //methods
    public Arena buildArena(String arenaType,double length,int maxRacers)
    {
        //arena type
        Class<?> clazz = Class.forName(arenaType);
        //get constructor
        Constructor<?> constructor = clazz.getConstructor(double.class,int.class);

        return (Arena) constructor.newInstance(length,maxRacers,0);  //friction******************************
    }
    public Racer buildRacer(String racerType,String name,double maxSpeed, double acceleration,utilities.EnumContainer.Color color){
        //racer type
        Class<?> clazz = Class.forName(racerType);
        //get constructor
        Constructor<?> constructor = clazz.getConstructor(String.class, double.class, double.class, Color.class);

        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color);
    }
    public Racer buildWheeledRacer(String racerType,String name, double maxSpeed,double acceleration,utilities.EnumContainer.Color color,int numOfWheels){
        //racer type
        Class<?> clazz = Class.forName(racerType);
        //get constructor
        Constructor<?> constructor = clazz.getConstructor(String.class, double.class, double.class, Color.class, int.class);

        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color, numOfWheels);
        // car - bicycle - airplane
    }


}
