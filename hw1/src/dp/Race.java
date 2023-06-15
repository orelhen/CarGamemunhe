package dp;

import arenas.Arena;
import game.racers.Racer;

import java.util.ArrayList;
/**
 * @author
 *
 * orel hen 316179423
 * guy aloosh 316471465
 *
 *
 */

public  class  Race {
    private ArrayList<Racer> MyRacers;
    private Arena MyArena;

    /**
     * @param p
     * setting RacerList
     */
    public void setRacersList(ArrayList<Racer> p){
        this.MyRacers=p;
    }

    /**
     * @param a
     * seting Race ARENA
     */
    public  void setArena(Arena a)
    {
        this.MyArena=a;
    }

    /**
     * Get Myracers
     * @return
     */
    public ArrayList<Racer> getMyRacers() {
        return MyRacers;
    }

    /**
     * Get Myarena
     * @return
     */
    public Arena getMyArena() {
        return MyArena;
    }
}
