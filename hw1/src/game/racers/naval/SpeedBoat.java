package game.racers.naval;

import game.racers.Racer;
import game.racers.land.LandRacer;
import game.racers.naval.NavalRacer;
import utilities.EnumContainer;

import static utilities.EnumContainer.Color.RED;

public class SpeedBoat  extends Racer implements NavalRacer {
    private static final String CLASS_NAME = "SpeedBoat";
    private static final int DEFAULT_MAX_SPEED=170;
    private static final double DEFAULT_ACCELERATION=5;
    private static final EnumContainer.Color DEFUALT_color = RED;
    private EnumContainer.BoatType boatType = EnumContainer.BoatType.SKULLING;
    private EnumContainer.Team team = EnumContainer.Team.DOUBLE;

    //constructors
    public SpeedBoat(){
        super(CLASS_NAME,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFUALT_color);
    }
    public SpeedBoat(String N, double MS, double ACC, EnumContainer.Color color) {
        super(N, MS, ACC, color);
    }



    //setters and getters
    public EnumContainer.BoatType getBoatType() {
        return boatType;
    }

    public boolean setBoatType(EnumContainer.BoatType boatType) {
        if(boatType!=null) {
            this.boatType = boatType;
            return true;
        }
        return false;
    }

    public EnumContainer.Team getTeam() {
        return team;
    }

    public boolean setTeam(EnumContainer.Team team) {
        if(team!=null) {
            this.team = team;
            return true;
        }
        return false;
    }
    //methods
    @Override
    public String describeSpecific() {
        return "Type: " +this.getBoatType() + ", Team: " + this.getTeam();
    }
    @Override
    public String className() {
        return "SpeedBoat";
    }
}
