package dp;

import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;


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
    public void BuildRace() throws RacerTypeException, RacerLimitException {
        raceBuilder.BuildArena();
        raceBuilder.BuildRacersList();
    }

}
