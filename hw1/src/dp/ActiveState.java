package dp;

import arenas.Arena;
import game.racers.Racer;

import java.time.LocalDateTime;

public class ActiveState implements RacerState {



    @Override
    public void handleStateChange(Racer racer, Arena arena) {
        int ranking= calculateRanking(racer,arena);
        System.out.println("The current ranking of racer number "+racer.getSerialNumber()+" is: "+ranking);

    }
    private int calculateRanking(Racer racer,Arena arena) {
        int ranking=arena.getActiveRacers().size();
        for (Racer racer1: arena.getActiveRacers()) {
            if (racer.getCurrentLocation().getX()>racer1.getCurrentLocation().getX()){
                ranking--;
            }
        }
        return ranking;
    }
}
