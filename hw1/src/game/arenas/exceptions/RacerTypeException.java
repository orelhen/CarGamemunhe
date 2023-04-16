package game.arenas.exceptions;
//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
public class  RacerTypeException extends Exception {
    /**
     * @param msg
     * @param msg2
     */
    //Racer type , Arena type
    public RacerTypeException(String msg,String msg2){super("inviald racer of type \"" +msg +"\" for "+msg2);}

}
