package game.arenas.exceptions;

public class  RacerTypeException extends Exception {
    //Racer type , Arena type
    public RacerTypeException(String msg,String msg2){super("inviald racer of type ''" +msg +"'' for "+msg2);}

}
