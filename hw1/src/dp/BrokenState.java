package dp;

import arenas.Arena;
import game.racers.Racer;
import gui.RaceFrame;

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

public class BrokenState implements RacerState {

    /**
     * @param racer
     * @param arena
     * broken state change, printing Brake time for each racer when Braking mid race.
     */
    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        LocalDateTime StartTime = RaceFrame.getStartTime();
        LocalDateTime BrakeDownTime = LocalDateTime.now();
        Duration duration = Duration.between(StartTime, BrakeDownTime);
        float seconds = duration.getSeconds() + duration.getNano() / 1_000_000_000f;

        System.out.println("the racer number " + racer.getSerialNumber() +" BrokeDown after : " + String.format("%.2f", seconds) + " seconds." );
    }
}
