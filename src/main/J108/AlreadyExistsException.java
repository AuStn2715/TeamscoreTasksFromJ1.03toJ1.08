package J108;

public class AlreadyExistsException extends RuntimeException {
    AlreadyExistsException(String text) {
        System.err.println(text);
    }

}
