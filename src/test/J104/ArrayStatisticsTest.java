package J104;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class ArrayStatisticsTest {
    @Test
    void test1() {
        int[] array = new int[]{};
        ArrayStatistics testObj = new ArrayStatistics(array);

        Assertions.assertArrayEquals(new int[]{}, testObj.mode());
        Assertions.assertEquals(Double.NaN, testObj.median());
        Assertions.assertEquals(Double.NaN, testObj.average());
        Assertions.assertEquals(Double.NaN, testObj.variance());
        Assertions.assertEquals(Double.NaN, testObj.geometricMean());

        Assertions.assertArrayEquals(new int[]{}, testObj.shuffle());
        Assertions.assertArrayEquals(new int[]{}, testObj.sample(1));
    }

    @Test
    void test2() {
        int[] array = new int[]{1};
        ArrayStatistics testObj = new ArrayStatistics(array);

        Assertions.assertArrayEquals(new int[]{1}, testObj.mode());
        Assertions.assertEquals(1.0, testObj.median());
        Assertions.assertEquals(1.0, testObj.average());
        Assertions.assertEquals(0.0, testObj.variance());
        Assertions.assertEquals(1.0, testObj.geometricMean());

        Assertions.assertArrayEquals(new int[]{1}, testObj.shuffle());
        Assertions.assertArrayEquals(new int[]{1, 1, 1}, testObj.sample(3));
    }

    @Test
    void test3() {
        int[] array = new int[]{1, 2, 3};
        ArrayStatistics testObj = new ArrayStatistics(array);

        Assertions.assertArrayEquals(new int[]{1, 2, 3}, testObj.mode());
        Assertions.assertEquals(2.0, testObj.median());
        Assertions.assertEquals(2.0, testObj.average());
        Assertions.assertEquals(2.0, testObj.variance());
        Assertions.assertEquals(Math.pow(6.0, 1.0/3.0), testObj.geometricMean());

        Assertions.assertFalse(Arrays.equals(testObj.shuffle(), testObj.shuffle()));
        Assertions.assertTrue(shuffleWasCorrect(array, testObj.shuffle()));

        Assertions.assertFalse(Arrays.equals(testObj.sample(5), testObj.sample(5)));
        Assertions.assertTrue(sampleWasCorrect(array, testObj.sample(5)));
    }

    @Test
    void test4() {
        int[] array = new int[]{1, 2, 2, 4, 4, 3, 5, 3, 1, 2};
        ArrayStatistics testObj = new ArrayStatistics(array);

        Assertions.assertArrayEquals(new int[]{2}, testObj.mode());
        Assertions.assertEquals(2.5, testObj.median());
        Assertions.assertEquals(2.7, testObj.average());
        Assertions.assertEquals(16.1, testObj.variance());
        Assertions.assertEquals(Math.pow(2*2*4*4*3*5*3*2, 1.0/10.0), testObj.geometricMean());

        Assertions.assertFalse(Arrays.equals(testObj.shuffle(), testObj.shuffle()));
        Assertions.assertTrue(shuffleWasCorrect(array, testObj.shuffle()));

        Assertions.assertFalse(Arrays.equals(testObj.sample(5), testObj.sample(5)));
        Assertions.assertTrue(sampleWasCorrect(array, testObj.sample(20)));
    }

    @Test
    void test5() {
        int[] array = new int[100000];
        Random rnd = new Random(0);
        for (int i = 0; i < 100000; i++) {
            array[i] = rnd.nextInt();
        }
        ArrayStatistics testObj = new ArrayStatistics(array);

        Assertions.assertArrayEquals(new int[]{-1640257612, -309898221}, testObj.mode());
        Assertions.assertEquals(-5099298.0, testObj.median());
        Assertions.assertEquals(-69425.60605, testObj.average());
        Assertions.assertEquals(1.5346179725122024E23, testObj.variance());
        Assertions.assertEquals(Double.POSITIVE_INFINITY, testObj.geometricMean());

        Assertions.assertFalse(Arrays.equals(testObj.shuffle(), testObj.shuffle()));
        Assertions.assertTrue(shuffleWasCorrect(array, testObj.shuffle()));

        Assertions.assertFalse(Arrays.equals(testObj.sample(5), testObj.sample(5)));
        Assertions.assertTrue(sampleWasCorrect(array, testObj.sample(20)));
    }


    // эти методы сделаны максимально втупую в лоб, чтобы их тоже не пришлось тестировать
    int countRepeats(int[] array, int number) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                count++;
            }
        }
        return count;
    }
    boolean shuffleWasCorrect(int[] array1, int[] array2) {
        for (int number : array1) {
            if (countRepeats(array1, number) != countRepeats(array2, number)) return false;
        }
        return true;
    }

    boolean sampleWasCorrect(int[] array1, int[] array2) {
        // в семпле черным по белому написано что элементы из оригинального массива выбираются случайно, но в маленьких
        // массивах почти всегада первые элементы идут в том же порядке
        //boolean atLeastOneNumberChangedPosition = false;
        if (array1.length > array2.length) {
            int[] temp = array1;
            array1 = array2;
            array2 = array1;
        }

        for (int j = 0; j < array1.length; j++) {
            int number = array1[j];
            boolean array2ContainsIt = false;
            for (int i = 0; i < array2.length; i++) {
                if (array2[i] == number) {
                    //if (i != j) atLeastOneNumberChangedPosition = true;
                    array2ContainsIt = true;
                    break;
                }
            }
            if (!array2ContainsIt) return false;
        }
        //if (!atLeastOneNumberChangedPosition) return false;
        return true;
    }
}