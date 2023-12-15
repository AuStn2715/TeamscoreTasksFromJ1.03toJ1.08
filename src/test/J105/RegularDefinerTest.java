package J105;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static J105.MicroTask2.regularDefiner;

public class RegularDefinerTest {
    @Test
    void test() {
        Assertions.assertEquals("email",regularDefiner("user.name@example.com"));
        Assertions.assertEquals("none",regularDefiner("@example.com"));
        Assertions.assertEquals("username",regularDefiner("user.name.example.com"));
        Assertions.assertEquals("none",regularDefiner("user.name@example"));
        Assertions.assertEquals("email",regularDefiner("user_name1@some.example.com"));
        Assertions.assertEquals("телефон",regularDefiner("+7-(123)-456-78-90"));
        Assertions.assertEquals("телефон",regularDefiner("+7(123)456-78-90"));
        Assertions.assertEquals("телефон",regularDefiner("+7-123-456-78-90"));
        Assertions.assertEquals("телефон",regularDefiner(" +71234567890"));
        Assertions.assertEquals("none",regularDefiner("71234567890"));
        Assertions.assertEquals("ИНН",regularDefiner("1234567890"));
        Assertions.assertEquals("ИНН",regularDefiner("000000000000"));
        Assertions.assertEquals("none",regularDefiner("7777-8888-9999"));
        Assertions.assertEquals("username",regularDefiner("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.$1234_"));
        Assertions.assertEquals("username",regularDefiner("     aaaa1111"));
        Assertions.assertEquals("none",regularDefiner("a"));
        Assertions.assertEquals("none",regularDefiner("qwerty 456"));
        Assertions.assertEquals("none",regularDefiner("4abc"));
        Assertions.assertEquals("none",regularDefiner("$asdfghjk"));
        Assertions.assertEquals("none",regularDefiner(""));
    }
}
