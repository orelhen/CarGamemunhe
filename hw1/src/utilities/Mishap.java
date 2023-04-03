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

    public boolean isFixable() {
        return fixable;
    }



    public double getReductionFactor() {
        return reductionFactor;
    }

    public int getTurnsToFix() {
        return turnsToFix;
    }


    //setters
    public void setReductionFactor(double reductionFactor) {
        this.reductionFactor = reductionFactor;
    }
    public void setTurnsToFix(int turnsToFix) {
        this.turnsToFix = turnsToFix;
    }
    public void setFixable(boolean fixable) {
        this.fixable = fixable;
    }


    public String toString() {
        return "Mishap{" + "fixable=" + fixable + ", reductionFactor=" + reductionFactor +", turnsToFix=" + turnsToFix +'}';
    }
}
