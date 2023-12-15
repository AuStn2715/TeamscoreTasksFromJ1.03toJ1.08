package J106;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import static J106.DoubleStreamProcessor.*;

public class DoubleStreamProcessorTest {
    @Test
    void test() {
        double[] array = new double[]{};
        Assertions.assertEquals(0,zeroesCount(Arrays.stream(array)));
        Assertions.assertEquals(false,hasFraction(Arrays.stream(array)));
        Assertions.assertEquals(Double.NaN,amplitude(Arrays.stream(array)));
        Assertions.assertTrue(Arrays.equals(new double[]{},valuesGreaterThan(Arrays.stream(array),0)));
        Assertions.assertEquals(Double.NaN,longestValue(Arrays.stream(array)));

        array = new double[]{1, 1, 1};
        Assertions.assertEquals(0,zeroesCount(Arrays.stream(array)));
        Assertions.assertEquals(false,hasFraction(Arrays.stream(array)));
        Assertions.assertEquals(0,amplitude(Arrays.stream(array)));
        Assertions.assertTrue(Arrays.equals(array,valuesGreaterThan(Arrays.stream(array),0)));
        Assertions.assertTrue(Arrays.equals(new double[]{},valuesGreaterThan(Arrays.stream(array),2)));
        Assertions.assertEquals(1.0,longestValue(Arrays.stream(array)));

        array = new double[]{0.1, 0.01, 0.5, 0.65, 0.9};
        Assertions.assertEquals(0,zeroesCount(Arrays.stream(array)));
        Assertions.assertEquals(true,hasFraction(Arrays.stream(array)));
        Assertions.assertEquals(0.89,amplitude(Arrays.stream(array)));
        // java приколов полна, в одном месте посчитала разницу даблов нормально, в другом нет
        Assertions.assertTrue(Arrays.equals(array,valuesGreaterThan(Arrays.stream(array),0)));
        Assertions.assertTrue(Arrays.equals(new double[]{0.65, 0.9},valuesGreaterThan(Arrays.stream(array),0.5)));
        Assertions.assertTrue(Arrays.equals(new double[]{},valuesGreaterThan(Arrays.stream(array),1)));
        Assertions.assertEquals(0.01,longestValue(Arrays.stream(array)));

        array = new double[]{0, 0, 0, 0, 0, 1, 2, -1, 12345.0987654321, 9,10,11,12,13, 14,15,16,17,18};
        Random rnd = new Random(0);
        for (int i = 9; i< 19; i++) {
            array[i] = rnd.nextDouble(-10,20);
        }
        Assertions.assertEquals(5,zeroesCount(Arrays.stream(array)));
        Assertions.assertEquals(true,hasFraction(Arrays.stream(array)));
        Assertions.assertEquals(12347.882672961956,amplitude(Arrays.stream(array)));
        Assertions.assertTrue(Arrays.equals(array,valuesGreaterThan(Arrays.stream(array),-11)));
        Assertions.assertTrue(Arrays.equals(new double[]{12345.0987654321},valuesGreaterThan(Arrays.stream(array),100)));
        Assertions.assertTrue(Arrays.equals(new double[]{},valuesGreaterThan(Arrays.stream(array),100000)));
        Assertions.assertEquals(-0.003448015700506346,longestValue(Arrays.stream(array)));
    }
}
