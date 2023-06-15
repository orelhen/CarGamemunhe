package dp;

import arenas.Arena;
import game.racers.Racer;

public class CompletedState implements RacerState {
    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        System.out.println("the racer number " + racer.getSerialNumber() +" has finishet" );
    }
}
