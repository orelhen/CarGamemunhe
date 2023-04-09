package game.arenas.exceptions;

public class  RacerTypeException extends Exception {
    public RacerTypeException(String msg,String msg2){super("inviald racer of type ''" +msg +"'' for "+msg2);}
    //public RacerTypeException(String msg,Throwable cause){super(msg,cause);}
}
