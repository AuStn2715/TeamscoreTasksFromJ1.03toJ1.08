package J106;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MicroTask2 {
    public static String textRedactor(String text) {
        return Arrays.stream(text.split("[\s-0-9()]"))
                .map(String::toUpperCase)
                .map(s -> s.replaceAll("[,.!?;]", ""))
                .filter(s -> s.length() > 2)
                .distinct()
                .sorted()
                .collect(Collectors.joining(" "));
    }
}
