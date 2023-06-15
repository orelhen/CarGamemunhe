package dp;

import arenas.Arena;
import game.racers.Racer;
/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */

public class DisabledState implements RacerState {
    /**
     * @param racer
     * @param arena
     * printing racer # disabled when Disabled State.
     * Player Stops and "Failed" is assinnged to him
     */
    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        System.out.println("the racer number " + racer.getSerialNumber() +" is disabled ");
    }
}
