package game.racers.naval;


//imports:
import game.racers.Racer;
import utilities.EnumContainer;
import static utilities.EnumContainer.Color.RED;

public class RowBoat extends Racer implements NavalRacer {
    private static final String CLASS_NAME = "RowBoat";
    private static final int DEFAULT_MAX_SPEED=75;
    private static final double DEFAULT_ACCELERATION=10;
    private static final EnumContainer.Color DEFUALT_color = RED;
    private EnumContainer.BoatType boatType = EnumContainer.BoatType.SKULLING;
    private EnumContainer.Team team = EnumContainer.Team.DOUBLE;


    //constructors
    public RowBoat(){
        super(CLASS_NAME,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFUALT_color);
    }

    /**
     * @param N
     * @param MS
     * @param ACC
     * @param color
     */
    public RowBoat(String N, double MS, double ACC, EnumContainer.Color color) {
        super(N, MS, ACC, color);
    }


    /**
     * @return
     */
//setters and getters
    public EnumContainer.BoatType getBoatType() {
        return boatType;
    }

    /**
     * @param boatType
     * @return
     */
    public boolean setBoatType(EnumContainer.BoatType boatType) {
        if (boatType != null) {
            this.boatType = boatType;
            return true;
        }
        return false;
    }

    public EnumContainer.Team getTeam() {
        return team;
    }

    /**
     * @param team
     * @return
     */
    public boolean setTeam(EnumContainer.Team team) {
        if (team != null) {
            this.team = team;
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    //methods
    @Override
    public String describeSpecific() {
        return "Type: " +getBoatType() + ", Team: " + getTeam();
    }

    /**
     * @return
     */
    @Override
    public String className() {
        return "RowBoat";
    }
}
