package J108;

public class AlreadyExistsException extends RuntimeException {
    private String alreadyExistingString;
    private int position;
    AlreadyExistsException(String existing, int position) {
        this.position = position;
        alreadyExistingString = existing;
    }
    public String getValue() {
        return alreadyExistingString;
    }
    public int getPosition() {
        return position;
    }
}
