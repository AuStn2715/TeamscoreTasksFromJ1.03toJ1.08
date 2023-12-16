package J104;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayStatistics {
    private final int[] array;
    private int[] sortedArray = null;
    public ArrayStatistics(int[] array) {
        this.array = array;
    }
    private void sortArray() {
        if(sortedArray == null) sortedArray = Arrays.stream(array).sorted().toArray();
    }
    private boolean arrayIsEmpty() {
        if (array.length < 1) return true;
        return false;
    }

    public int[] mode() {
        if (arrayIsEmpty()) return new int[]{};

        Map<Integer, Integer> valueByCounter = new HashMap<>();
        for (int value : array) {
            int counter = valueByCounter.getOrDefault(value, 0);
            counter++;
            valueByCounter.put(value, counter);
        }
        int maxRepeats = 0;
        int curRepeats;
        var entrySet = valueByCounter.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            curRepeats = entry.getValue();
            if (curRepeats >= maxRepeats) {
                maxRepeats = curRepeats;
            }
            //else entrySet.remove(entry);
            // если нужно будет ускорить поиск значений удаляя не максимальные - нужно применить строчку ниже, но пока
            // не разобрался как, работает так - пускай работает
            //Set<String> set = Collections.newSetFromMap(new ConcurrentHashMap<>());
        }
        int outputSize = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == maxRepeats) outputSize++;
        }
        int[] output = new int[outputSize];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() == maxRepeats) {
                output[i] = entry.getKey();
                i++;
            }
        }

        return output;
    }

    public double median() {
        if (arrayIsEmpty()) return Double.NaN;

        if (array.length % 2 == 1) {
            int middle = array.length / 2;
            sortArray();
            return sortedArray[middle];
        }

        int middle = array.length / 2; // число справа от центра
        sortArray();

        /*
        (определение медианы с вики) "Если в выборке чётное число элементов, медиана может быть не определена однозначно:
        тогда для числовых данных чаще всего используют полусумму двух соседних значений" пусть возвращает даже дробное
         */
        return (sortedArray[middle] + sortedArray[middle - 1]) / 2.0;
    }
    public double average(){
        if(arrayIsEmpty()) return Double.NaN;

        return IntStream.of(array).average().getAsDouble();
    }
    public double variance() {
        if (arrayIsEmpty()) return Double.NaN;

        double average = average();
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + Math.pow((array[i] - average), 2);
        }
        return sum;
    }
    public double geometricMean() {
        if (arrayIsEmpty()) return Double.NaN;

        double result = 1;
        for (int i = 0; i < array.length; i++) {
            result = result * array[i];
        }
        result = Math.pow(result, 1.0 / array.length);
        return result;
    }
    public int[] shuffle() {
        if (arrayIsEmpty()) return new int[]{};

        Random rnd = new Random();
        int[] newArray = array.clone();
        for (int i = newArray.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            int temp = newArray[i];
            newArray[i] = newArray[j];
            newArray[j] = temp;
        }
        return newArray;
    }
    public int[] sample(int size) {
        if (arrayIsEmpty()) return new int[]{};

        Random rnd = new Random();
        int[] newArray = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[rnd.nextInt(array.length)];
        }
        return newArray;
    }
}
