package dp;

import arenas.exceptions.RacerLimitException;
import arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import game.racers.air.Helicopter;
import utilities.EnumContainer;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */


/**
 * Generating AirRace
 * creating new Air arena size 1000 and with 10 Racer Prototypes
 */
public class AirRaceBuilder implements RaceBuilder {
    private ArenaFactory FactoryArena =new ArenaFactory();
    private Race race;
    private int num=10;
    private ArrayList<Racer> newActiveRacers;
    //constructor

    public AirRaceBuilder(){
        this.newActiveRacers=new ArrayList<>();
        this.race=new Race();
    }

    /**
     * calling arena factory method to build arena
     */
    @Override
    public void BuildArena() {
        race.setArena(FactoryArena.getArena("Land",this.num));
    }

    /**
     * @throws RacerTypeException
     * @throws RacerLimitException
     * @throws CloneNotSupportedException
     * genereating 10 random colored prototypes for race
     */
    @Override
    public void BuildRacersList() throws RacerTypeException, RacerLimitException, CloneNotSupportedException {

        Helicopter airRacer=new Helicopter("Prototype",250,20, EnumContainer.Color.BLACK);
        this.newActiveRacers.add(airRacer);
        for(int i=0;i<this.num-1;i++)
        {

            Random rand = new Random();
            int newcolor = rand.nextInt(5);
            EnumContainer.Color NewColor = null;
            if (newcolor == 0)
                NewColor = EnumContainer.Color.BLACK;
            if (newcolor == 1)
                NewColor = EnumContainer.Color.RED;
            if (newcolor == 2)
                NewColor = EnumContainer.Color.GREEN;
            if (newcolor == 3)
                NewColor = EnumContainer.Color.BLUE;
            if (newcolor == 4)
                NewColor = EnumContainer.Color.YELLOW;

            Racer copy = (Racer) airRacer.clone();
            copy.upgrade(NewColor);
            this.newActiveRacers.add(copy);

        }
        for(int i=0;i<this.num;i++)
        {
            race.getMyArena().addRacer(this.newActiveRacers.get(i));
        }
        race.setRacersList(this.newActiveRacers);
        race.getMyArena().initRace();
    }
    public Race getRace() { return this.race;}

}
