package game.factory;

//imports
import game.arenas.Arena;
import game.racers.Racer;
import utilities.EnumContainer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 */

public class RaceBuilder {
    private static RaceBuilder instance;
    private ClassLoader classLoader;
    private Class<?> classObject;
    private Constructor<?> constructor;

    public static RaceBuilder getInstance() {
        return new RaceBuilder();
    }


    /**
     * @param arenaType
     * @param length
     * @param maxRacers
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    // methods - java reflection
    public Arena buildArena(String arenaType,double length,int maxRacers) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //classloader

        classLoader =ClassLoader.getSystemClassLoader();
        //arena type

        classObject = Class.forName(arenaType);

        //constructor
        constructor = classObject.getConstructor(double.class,int.class);
        return (Arena) constructor.newInstance(length,maxRacers);
    }


    /**
     * @param racerType
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @return
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public Racer buildRacer(String racerType,String name,double maxSpeed, double acceleration,utilities.EnumContainer.Color color) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //getclassloader
        classLoader =ClassLoader.getSystemClassLoader();

        //racer type
        classObject = Class.forName(racerType);

        //get constructor
        constructor = classObject.getConstructor(String.class, double.class, double.class, EnumContainer.Color.class);
        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color);
    }


    /**
     * @param racerType
     * @param name
     * @param maxSpeed
     * @param acceleration
     * @param color
     * @param numOfWheels
     * @return
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    // car - bicycle - airplane
    public Racer buildWheeledRacer(String racerType,String name, double maxSpeed,double acceleration,utilities.EnumContainer.Color color,int numOfWheels) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //classloader
        classLoader =ClassLoader.getSystemClassLoader();

        //racer type
        classObject = Class.forName(racerType);

        //constructor
        constructor = classObject.getConstructor(String.class, double.class, double.class, EnumContainer.Color.class, int.class);
        return (Racer) constructor.newInstance(name, maxSpeed, acceleration, color, numOfWheels);

    }
}
