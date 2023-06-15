package dp;

import arenas.Arena;
import gui.RaceFrame;
import game.factory.RaceBuilder;

import java.lang.reflect.InvocationTargetException;

public class Factory extends RaceFrame {


    public void factorymethod (int x)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Arena arr = getBuilder().buildArena("arenas.air.AerialArena" , 1000, 10);
        setArena(arr);

    }

}
