package dp;

import arenas.Arena;
import game.racers.Racer;
import gui.RaceFrame;

import java.time.Duration;
import java.time.LocalDateTime;

public class CompletedState implements RacerState {


    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        LocalDateTime StartTime = RaceFrame.getStartTime();
        LocalDateTime BrakeDownTime = LocalDateTime.now();
        Duration duration = Duration.between(StartTime, BrakeDownTime);
        float seconds = duration.getSeconds() + duration.getNano() / 1_000_000_000f;

        System.out.println("the racer number " + racer.getSerialNumber() +" has finishet in " + String.format("%.2f", seconds) + "seconds" );
    }

}
