package game.arenas;

import game.arenas.air.Arena;
import game.utilities.EnumContainer;
import utilities.EnumContainer;


public class NavalArena extends Arena {
    private final static int DEFAULT_LENGTH =1000;
    private EnumContainer.Water water = EnumContainer.Water.SWEET;
    private  EnumContainer.Surface surface=EnumContainer.Surface.FLAT;
    private  EnumContainer.Body body=EnumContainer.Body.LAKE;


    //constructors :


    public NavalArena() {
    }

    public NavalArena(double length, int maxRacers, double friction) {
        super(length, maxRacers, friction);
    }


    public double getDEFAULT_FRICTION() {
        double DEFAULT_FRICTION = 0.5;
        return DEFAULT_FRICTION;
    }

    public int getDEFAULT_MAX_RACERS() {
        int DEFAULT_MAX_RACERS = 5;
        return DEFAULT_MAX_RACERS;
    }

    public EnumContainer.Water getWater() {
        return water;
    }

    public EnumContainer.Surface getSurface() {
        return surface;
    }

    public EnumContainer.Body getBody() {
        return body;
    }

    public boolean SetWater (EnumContainer.Water water){
        if (water!=null)
        {
            this.water=water;
            return true;
        }
        return false;
    }
    public boolean SetSurface (EnumContainer.Surface surface){
        if (water!=null)
        {
            this.surface=surface;
            return true;
        }
        return false;
    }
    public boolean SetBody(EnumContainer.Body body){
        if (water!=null)
        {
            this.body=body;
            return true;
        }
        return false;
    }
}


