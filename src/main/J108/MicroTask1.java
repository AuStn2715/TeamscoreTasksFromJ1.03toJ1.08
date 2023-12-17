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
                    int i = list.indexOf(input) + 1; // пусть нумерация идёт по человечески с 1ого введенного текста
                    throw new AlreadyExistsException(input, i);
                }
                list.add(input);
            }
            catch (AlreadyExistsException exp) {
                System.err.println(exp.getMessage() + exp.getValue() + " под номером " + exp.getPosition());
            }
        }
    }
}
