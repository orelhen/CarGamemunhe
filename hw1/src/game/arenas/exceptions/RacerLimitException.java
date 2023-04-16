package game.arenas.exceptions;
//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
public class RacerLimitException extends Exception {
    //Racer , Racer num
    public RacerLimitException(String msg,String msg2){super("Arena is full! (" + msg +" active racer exist). racer #" + msg2 +" was not added");}

}
