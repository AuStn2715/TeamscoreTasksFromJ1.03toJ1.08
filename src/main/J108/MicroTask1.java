package J108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MicroTask1 {
    public static void main(String[] args) throws AlreadyExistsException {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String input;
        while (true) {
            try {
                input = in.next();
                if (!list.isEmpty() && list.contains(input)) {

                    throw new AlreadyExistsException("Введённый вами текст уже был введён: ", input);
                }
                list.add(input);
            }
            catch (AlreadyExistsException exp) {
                int i = list.indexOf(exp.getValue()) + 1; // пусть нумерация идёт по человечески с 1ого введенного текста
                System.err.println(exp.getMessage() + exp.getValue() + " под номером " + i);
            }
        }
    }
}
