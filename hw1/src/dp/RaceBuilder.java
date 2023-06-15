package dp;

import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;

public interface RaceBuilder {

    public void BuildRacersList() throws RacerTypeException, RacerLimitException;
    public void BuildArena();
    public Race getRace();
}
