package utilities;

public class Mishap {

	private boolean fixable;
    private double reductionFactor;
    private int turnsToFix;

    //constructors
    Mishap(boolean fixable,int turnsToFix,double reductionFactor){
        this.fixable =fixable;
        this. turnsToFix = turnsToFix;
        this.reductionFactor = reductionFactor;
    }
	//methods
    void nextTurn(){
        if (this.fixable){this.turnsToFix= this.turnsToFix-1;} // or minus reduction??
    }

    //getters


    //setters


    public void toString(){}



}
