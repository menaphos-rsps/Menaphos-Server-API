package org.menaphos.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class MathUtils {

    public static double difference(double a, double b) {
        return a - b;
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static double angle(double theta) {
        return Math.toDegrees(theta);
    }

    public static double theta(double y, double x) {
        return Math.atan2(y,x);
    }

    public static final long generateId() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextLong(10_000_000_000L, 100_000_000_000L);
    }

    public static double getPercentFromFloat(float value) {
        DecimalFormat df = new DecimalFormat(StringUtils.PERCENT_ROUNDING_FORMAT);
        df.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(df.format(value * 100));
    }

}
