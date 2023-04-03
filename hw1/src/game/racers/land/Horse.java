package game.racers.land;

import game.racers.Racer;
import utilities.EnumContainer;

public class Horse extends Racer implements LandRacer  {
    private static final String CLASS_NAME = "Horse";
    private static final double DEFAULT_MAX_SPEED = 50;
    private static final double DEFAULT_ACCELERATION =3;
    private static final EnumContainer.Color DEFAULT_COLOR = EnumContainer.Color.BLACK;
    private EnumContainer.Breed breed = EnumContainer.Breed.THOROUGHBRED;

    public Horse()
    {
        super(CLASS_NAME,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFAULT_COLOR);
    };

    public Horse(String name, double maxSpeed, double acceleration, EnumContainer.Color color) {
        super(name,maxSpeed,acceleration,color);
    }

    public EnumContainer.Breed getBreed() {
        return breed;
    }

    public boolean setBreed(EnumContainer.Breed breed) {
        if (breed != null) {
            this.breed = breed;
            return true;
        }
        return false;
    }
}
