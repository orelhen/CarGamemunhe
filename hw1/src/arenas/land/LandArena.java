//packages :

package arenas.land;

//imports :

import arenas.Arena;
import utilities.EnumContainer;

//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
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


    //constuctors
    public LandArena() {
        super(DEFAULT_LENGTH,8,0.5);
    }

    /**
     * @param length
     * @param maxRacers
     */
    public LandArena(double length, int maxRacers) {
        super(length, maxRacers,0.5);
    }


    /**
     * @param surface
     * @return
     */
    //getters and setters
    public boolean SetSurface (EnumContainer.Surface surface){
        if (surface!=null)
        {
            this.surface=surface;
            return true;
        }
        return false;
    }

    /**
     * @param coverage
     * @return
     */
    public boolean SetCoverage (EnumContainer.Coverage coverage){
        if (coverage!=null)
        {
            this.coverage=coverage;
            return true;
        }
        return false;
    }


}
