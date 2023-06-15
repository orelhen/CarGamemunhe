package dp;

import arenas.Arena;
import game.racers.Racer;

import java.time.LocalDateTime;
/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */

public class ActiveState implements RacerState {

    /**
     * @param racer
     * @param arena
     * ActiveStatechange handeling, informing us of player location mid race
     * Printing current location for each active Racer
     */
    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        int ranking= calculateRanking(racer,arena);
        System.out.println("The current ranking of racer number "+racer.getSerialNumber()+" is: "+ranking);

    }

    /**
     * @param racer
     * @param arena
     * returning position of Racer when racer return to active state
     * @return
     */
    private int calculateRanking(Racer racer,Arena arena) {
        int Rank=0;
        for (Racer racer1: arena.getActiveRacers()) {
            if (racer.getCurrentLocation().getX()<=racer1.getCurrentLocation().getX()){
                Rank++;
            }
        }
        return Rank;
    }
}
