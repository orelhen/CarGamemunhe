//packages:

package game.racers.air;

//imports:
import game.racers.Racer;
import utilities.EnumContainer;
import java.lang.String;
import static utilities.EnumContainer.Color.BLUE;

//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */

public class Helicopter extends Racer implements AerialRacer {
    private static final String CLASS_NAME = "Helicopter";
    private static final int DEFAULT_MAX_SPEED=400;
    private static final double DEFAULT_ACCELERATION=50;
    private static final EnumContainer.Color DEFUALT_color = BLUE;

    public Helicopter()
    {
        super(CLASS_NAME,DEFAULT_MAX_SPEED,DEFAULT_ACCELERATION,DEFUALT_color);
    }

    public Helicopter(String N, double MS, double ACC, EnumContainer.Color color) {
        super(N, MS, ACC, color);
    }

    /**
     * @return
     */
    @Override
    public String describeSpecific() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public String className() {
        return "Helicopter";
    }
}
