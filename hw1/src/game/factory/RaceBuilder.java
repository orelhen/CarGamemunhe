package game.factory;


//imports
import game.arenas.Arena;
import game.racers.Racer;
import utilities.EnumContainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RaceBuilder {
    private static RaceBuilder instance;
    private ClassLoader classLoader;
    private Class<?> classObject;
    private Constructor<?> constructor;

    public static RaceBuilder getInstance() {
        return new RaceBuilder();
    }


    //methods
    public Arena buildArena(String arenaType,double length,int maxRacers) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //getclassloader
        classLoader =ClassLoader.getSystemClassLoader();
        //arena type
        Class<?> clazz = Class.forName(arenaType);
        //get constructor
        Constructor<?> constructor = clazz.getConstructor(double.class,int.class);
        return (Arena) constructor.newInstance(length,maxRacers);
    }
    public Racer buildRacer(String racerType,String name,double maxSpeed, double acceleration,utilities.EnumContainer.Color color) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //getclassloader
        classLoader =ClassLoader.getSystemClassLoader();
        //racer type
        Class<?> clazz = Class.forName(racerType);
        //get constructor
        Constructor<?> constructor = clazz.getConstructor(String.class, double.class, double.class, EnumContainer.Color.class);

        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color);
    }
    public Racer buildWheeledRacer(String racerType,String name, double maxSpeed,double acceleration,utilities.EnumContainer.Color color,int numOfWheels) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //getclassloader
        classLoader =ClassLoader.getSystemClassLoader();
        //racer type
        Class<?> clazz = Class.forName(racerType);
        //get constructor
        Constructor<?> constructor = clazz.getConstructor(String.class, double.class, double.class, EnumContainer.Color.class, int.class);

        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color, numOfWheels);
        // car - bicycle - airplane
    }
}
