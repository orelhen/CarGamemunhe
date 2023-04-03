//packages:

package game.racers.air;

//imports:

import game.racers.Racer;
import utilities.EnumContainer;

import static utilities.EnumContainer.Color.BLUE;

public class Helicopter extends Racer implements AerialRacer {
    private static final String CLASS_NAME = "Helicopter";
    private static final int DEFAULT_MAX_SPEED=400;
    private static final double DEFAULT_ACCELERATION=50;
    private static final EnumContainer.Color DEFUALT_color = BLUE;

    public Helicopter() {
    }

    public Helicopter(String N, double MS, double ACC, EnumContainer.Color color) {
        super(N, MS, ACC, color);
    }

}
