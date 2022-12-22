package simulation.src;

import java.util.SplittableRandom;

public class Draw {
    public static boolean draw(int probability) {
        SplittableRandom rand = new SplittableRandom();
        int randomInt = rand.nextInt(101);
        return randomInt <= probability;
    }
}
