package J108;

public class AlreadyExistsException extends RuntimeException {
    private String alreadyExistingString;
    private int position;
    AlreadyExistsException(String existing, int position) {
        super("Введенный вами текст уже был введён: ");
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
