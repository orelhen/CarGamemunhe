package factory;


//imports
import game.arenas.Arena;
import game.racers.Racer;

public class RaceBuilder {
    private static RaceBuilder instance;
    private ClassLoader classLoader;
    private Class<?> classObject;
    private Constructor<?> consctructor;


    //methods
    public Arena buildArena(String arenaType,double length,int maxRacers)
    {
        //arena type
        Arena newArena = new Arena(length,maxRacers,0); //friction
        return newArena;
    }
    public Racer buildRacer(String racerType,String name,double maxSpeed, double acceleration,utilities.EnumContainer.Color color){
        //racer type
        Racer newRacer = new Racer(name,maxSpeed,acceleration,color);
        return newRacer;
    }
    public Racer buildWheeledRacer(String racerType,String name, double maxSpeed,double acceleration,utilities.EnumContainer.Color color,int numOfWheels){
        //racer type
        Racer newRacer = new Racer(name,maxSpeed,acceleration,color);
        //num of wheels
        return newRacer;
    }
    //if needed- more methods

}
