package dp;

import arenas.Arena;
import game.racers.Racer;

import java.time.Duration;
import java.time.LocalDateTime;
/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */

public interface RacerState {

    /**
     * @param racer
     * @param arena
     * Interface for Handeling state function
     */
    public void handleStateChange(Racer racer, Arena arena);

}
