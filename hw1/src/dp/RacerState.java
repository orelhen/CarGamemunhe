package dp;

import arenas.Arena;
import game.racers.Racer;

import java.time.Duration;
import java.time.LocalDateTime;

public interface RacerState {

    public void handleStateChange(Racer racer, Arena arena);

}
