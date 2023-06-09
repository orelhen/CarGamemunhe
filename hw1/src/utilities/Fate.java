package utilities;
//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
import java.util.Random;

public class Fate {

	private static Random rand = new Random();

	public static boolean breakDown() {
		return rand.nextBoolean();
	}

	public static boolean generateFixable() {
		return rand.nextInt(500) > 10;
	}

	public static Mishap generateMishap() {
		return new Mishap(generateFixable(), generateTurns(), generateReduction());
	}

	private static float generateReduction() {
		return rand.nextFloat();
	}

	private static int generateTurns() {
		return rand.nextInt(10) + 1;
	}

	public static void setSeed(int seed) {
		rand.setSeed(seed);
	}

}
