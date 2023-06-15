package utilities;

import arenas.Arena;
import game.racers.Racer;

public interface RacerState {

    public void handleStateChange(Racer racer, Arena arena);
}
