package game.racers.states;

import arenas.Arena;
import game.racers.Racer;
import utilities.RacerState;

import java.time.LocalDateTime;

public class BrokenState implements RacerState {
    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        LocalDateTime BrakeDownTime = LocalDateTime.now();
        System.out.println("the racer number " + racer.getSerialNumber() +":" + BrakeDownTime);
    }
}
