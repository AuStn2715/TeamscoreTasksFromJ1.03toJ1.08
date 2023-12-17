package J108;

public class AlreadyExistsException extends RuntimeException {
    private String alreadyExistingObject;
    AlreadyExistsException(String message, String existing) {
        super(message);
        alreadyExistingObject = existing;
    }
    public String getValue() {
        return alreadyExistingObject;
    }
}
