package J106;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class DoubleStreamProcessor {
    public static int zeroesCount(DoubleStream stream) {
        return stream.filter(s -> s == 0.0).toArray().length;
    }
    public static boolean hasFraction(DoubleStream stream) {
        return stream.filter(s -> s % 1 != 0).toArray().length > 0;
    }
    public static double amplitude(DoubleStream stream) {
        double[] array = stream.toArray();
        OptionalDouble max = Arrays.stream(array).max();
        OptionalDouble min = Arrays.stream(array).min();
        if (max.isPresent() && min.isPresent())
            return max.getAsDouble() - min.getAsDouble();
        return Double.NaN;
    }
    public static double[] valuesGreaterThan(DoubleStream stream, double limit) {
        return stream.filter(s -> s > limit).toArray();
    }
    public static double longestValue(DoubleStream stream) {
        double[] dArray = stream.toArray();
        int maxLength = 0;
        int curLength;
        double longest = Double.NaN;
        for (int i = 0; i < dArray.length; i++) {
            curLength = String.valueOf(dArray[i]).length(); // мне кажется, что есть более элегантное решение, но я его не нашел
            if (curLength > maxLength) {
                maxLength = curLength;
                longest = dArray[i];
            }
        }
        return longest;
    }
}
