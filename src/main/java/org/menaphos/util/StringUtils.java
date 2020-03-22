package org.menaphos.util;

import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StringUtils {

    public static final String NUMERIC_DECIMAL_REGEX = "[0-9.-]+";
    public static final String ALPHA_REGEX = "\\w+\\.?";
    public static final String PERCENT_ROUNDING_FORMAT = "#.##";

    public static String floatToPercent(float value) {
        DecimalFormat df = new DecimalFormat(PERCENT_ROUNDING_FORMAT);
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(value * 100) + "%";
    }

    public static String doubleToPercent(double value) {
        DecimalFormat df = new DecimalFormat(PERCENT_ROUNDING_FORMAT);
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(value * 100) + "%";
    }

    public static <E extends Enum<E>>String parseToSimpleString(Enum<E> tEnum) {
        return String.valueOf(tEnum.name().charAt(0)) + tEnum.name().toLowerCase().substring(1).replaceAll("_", " ");
    }

    public static URL getURLFromString(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatInteger(int value) {
        return NumberFormat.getInstance().format(value);
    }
}
