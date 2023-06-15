package game.racers.states;

import arenas.Arena;
import game.racers.Racer;
import utilities.RacerState;

public class DisabledState implements RacerState {
    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        System.out.println("the racer number " + racer.getSerialNumber() +" is disabled ");
    }
}
