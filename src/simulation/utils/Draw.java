package simulation.utils;

import simulation.model.vectors.Coordinates;
import simulation.model.vectors.IVector2D;
import simulation.model.vectors.Vector2D;

import java.util.SplittableRandom;

public class Draw {
    public static boolean drawInfection(int probability) {
        SplittableRandom rand = new SplittableRandom();
        int randomInt = rand.nextInt(101);
        return randomInt <= probability;
    }
    public static int drawDurationOfInfection(int intervalBeginning, int intervalEnd) {
        SplittableRandom rand = new SplittableRandom();
        int randomDuration = rand.nextInt(intervalEnd - intervalBeginning + 1);
        return randomDuration + intervalBeginning;
    }
    public static IVector2D drawVector(double intervalBeginning, double intervalEnd) {
        SplittableRandom rand = new SplittableRandom();
        double randomX = intervalBeginning + (intervalEnd - intervalBeginning) * rand.nextDouble() / 8;
        var randomY = Math.sqrt(intervalEnd - intervalBeginning - randomX) / 8;

        return new Vector2D(randomX, randomY);
    }
    public static Coordinates drawSpawnCoords(double M, double N) {
        SplittableRandom rand = new SplittableRandom();
        double randomX = 0 + (M - 0) * rand.nextDouble();
        double randomY = 0 + (N - 0) * rand.nextDouble();

        return new Coordinates(randomX, randomY);
    }
    public static boolean drawLeavingOrNot(int probability) {
        SplittableRandom rand = new SplittableRandom();
        int randomInt = rand.nextInt(101);
        return randomInt <= probability;
    }
    public static boolean drawSpawningOrNot (int probability) {
        SplittableRandom rand = new SplittableRandom();
        int randomInt = rand.nextInt(101);
        return randomInt <= probability;
    }
}
