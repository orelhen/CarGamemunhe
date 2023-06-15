package dp;

import arenas.Arena;
import game.racers.Racer;

import java.util.ArrayList;

public  class  Race {
    private ArrayList<Racer> MyRacers;
    private Arena MyArena;
    public void setRacersList(ArrayList<Racer> p){
        this.MyRacers=p;
    }
    public  void setArena(Arena a)
    {
        this.MyArena=a;
    }

    public ArrayList<Racer> getMyRacers() {
        return MyRacers;
    }

    public Arena getMyArena() {
        return MyArena;
    }
}
