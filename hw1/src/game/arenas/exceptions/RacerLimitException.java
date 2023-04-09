package game.arenas.exceptions;

public class RacerLimitException extends Exception {
    public RacerLimitException(String msg,String msg2){super("Arena is full! (" + msg +" active racer exist). racer #" + msg2 +" was not added");}
   // Arena is full! (4 active racers exist). racer #13 was not added
}
