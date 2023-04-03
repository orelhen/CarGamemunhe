//packages :

package game.arenas.land;

//imports :

import game.arenas.Arena;
import utilities.EnumContainer;

public class LandArena extends Arena {
    private final static int DEFAULT_LENGTH =800;
    private final int DEFAULT_MAX_RACERS=8;
    private final static double DEFAULT_FRICTION =0.5;
    private EnumContainer.Coverage coverage = EnumContainer.Coverage.GRASS;
    private EnumContainer.Surface surface=EnumContainer.Surface.FLAT;

    public int getDEFAULT_MAX_RACERS() {
        return DEFAULT_MAX_RACERS;
    }

    public EnumContainer.Coverage getCoverage() {
        return coverage;
    }

    public EnumContainer.Surface getSurface() {
        return surface;
    }
    public boolean SetSurface (EnumContainer.Surface surface){
        if (surface!=null)
        {
            this.surface=surface;
            return true;
        }
        return false;
    }
    public boolean SetCoverage (EnumContainer.Coverage coverage){
        if (coverage!=null)
        {
            this.coverage=coverage;
            return true;
        }
        return false;
    }

    public LandArena() {
        super();
    }

    public LandArena(double length, int maxRacers,double friction) {
        super(length, maxRacers,friction);
    }
}
