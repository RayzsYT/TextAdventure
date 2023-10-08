package de.rayzs.ta.util;

import java.util.Random;

public class MathUtils {

    public static final Random RANDOM = new Random();

    public static int nextInt(int min, int max) {
        return min + RANDOM.nextInt(max - min + 1);
    }
}
