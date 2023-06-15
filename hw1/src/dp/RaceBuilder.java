package dp;

import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;
/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 */

public interface RaceBuilder {

    /**
     * @throws RacerTypeException
     * @throws RacerLimitException
     */
    public void BuildRacersList() throws RacerTypeException, RacerLimitException;

    /**
     *
     */
    public void BuildArena();

    /**
     * @return
     */
    public Race getRace();
}
