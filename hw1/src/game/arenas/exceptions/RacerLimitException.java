package game.arenas.exceptions;

public class RacerLimitException extends Exception {
    //Racer , Recer num
    public RacerLimitException(String msg,String msg2){super("Arena is full! (" + msg +" active racer exist). racer #" + msg2 +" was not added");}

}
