package utilities;

//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */


public class Mishap {

    private boolean fixable;
    private double reductionFactor;
    private int turnsToFix;

    /**
     * @param fixable
     * @param turnsToFix
     * @param reductionFactor
     */
    //constructors
    Mishap(boolean fixable,int turnsToFix,double reductionFactor){
        this.fixable =fixable;
        this. turnsToFix = turnsToFix;
        this.reductionFactor = reductionFactor;

    }

    /**
     *
     */
    //methods
    public void nextTurn(){
        if (getTurnsToFix()>0)
            setTurnsToFix(getTurnsToFix()-1);

    }

    /**
     * @return
     */
    public String toString() {
        return "(" + fixable + ", " + turnsToFix + ", " + String.format("%.2f", reductionFactor) + ")";
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


}
