package dp;

import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;
/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */


public class Director {
    private RaceBuilder raceBuilder;
    public Director(RaceBuilder raceBuilder){this.raceBuilder=raceBuilder;}
    public Race getRace(){
        return raceBuilder.getRace();
    }

    /**
     * @throws RacerTypeException
     * @throws RacerLimitException
     * Building Race generated from raceBuilder
     */
    public void BuildRace() throws RacerTypeException, RacerLimitException, CloneNotSupportedException {
        raceBuilder.BuildArena();
        raceBuilder.BuildRacersList();
    }

}
