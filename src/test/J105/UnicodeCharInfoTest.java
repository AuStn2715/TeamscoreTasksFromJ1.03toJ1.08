package J105;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;;

public class UnicodeCharInfoTest {
    @Test
    void test1() {
        var chr = new UnicodeCharInfo('0');
        Assertions.assertEquals(48, chr.unicodeInt());
        Assertions.assertEquals("U+0030", chr.unicodeHex());
        Assertions.assertEquals('1', chr.nextChar());
        Assertions.assertEquals('/', chr.prevChar());
        Assertions.assertEquals(chr.DIGIT, chr.charType());
        Assertions.assertEquals(-1, chr.alphabetNumber());
    }
    @Test
    void test2() {
        var chr = new UnicodeCharInfo('N');
        Assertions.assertEquals(78, chr.unicodeInt());
        Assertions.assertEquals("U+004E", chr.unicodeHex());
        Assertions.assertEquals('O', chr.nextChar());
        Assertions.assertEquals('M', chr.prevChar());
        Assertions.assertEquals(chr.LETTER_UPPER, chr.charType());
        Assertions.assertEquals(14, chr.alphabetNumber());
    }
    @Test
    void test3() {
        var chr = new UnicodeCharInfo('z');
        Assertions.assertEquals(122, chr.unicodeInt());
        Assertions.assertEquals("U+007A", chr.unicodeHex());
        Assertions.assertEquals('{', chr.nextChar());
        Assertions.assertEquals('y', chr.prevChar());
        Assertions.assertEquals(chr.LETTER_LOWER, chr.charType());
        Assertions.assertEquals(26, chr.alphabetNumber());
    }
    @Test
    void test4() {
        var chr = new UnicodeCharInfo('Ж');
        Assertions.assertEquals(1046, chr.unicodeInt());
        Assertions.assertEquals("U+0416", chr.unicodeHex());
        Assertions.assertEquals('З', chr.nextChar());
        Assertions.assertEquals('Е', chr.prevChar());
        Assertions.assertEquals(chr.LETTER_UPPER, chr.charType());
        Assertions.assertEquals(-1, chr.alphabetNumber());
    }
    @Test
    void test5() {
        var chr = new UnicodeCharInfo(32); // я без понятия как эти пробелы самому печатать, их тем более тут 2 разных
        Assertions.assertEquals(32, chr.unicodeInt());
        Assertions.assertEquals("U+0020", chr.unicodeHex());
        Assertions.assertEquals('!', chr.nextChar());
        Assertions.assertEquals('', chr.prevChar());
        Assertions.assertEquals(chr.SPACE, chr.charType());
        Assertions.assertEquals(-1, chr.alphabetNumber());
    }
    void test6() {
        var chr = new UnicodeCharInfo(9);
        Assertions.assertEquals(9, chr.unicodeInt());
        Assertions.assertEquals("U+0009", chr.unicodeHex());
        Assertions.assertEquals((char)10, chr.nextChar());
        Assertions.assertEquals((char)8, chr.prevChar());
        Assertions.assertEquals(chr.SPACE, chr.charType());
        Assertions.assertEquals(-1, chr.alphabetNumber());
    }
    void test7() {
        var chr = new UnicodeCharInfo('&');
        Assertions.assertEquals(38, chr.unicodeInt());
        Assertions.assertEquals("U+0026", chr.unicodeHex());
        Assertions.assertEquals('\'', chr.nextChar());
        Assertions.assertEquals('%', chr.prevChar());
        Assertions.assertEquals(chr.OTHER, chr.charType());
        Assertions.assertEquals(-1, chr.alphabetNumber());
    }
    void test8() {
        var chr = new UnicodeCharInfo('λ');
        Assertions.assertEquals(954, chr.unicodeInt());
        Assertions.assertEquals("U+03BB", chr.unicodeHex());
        Assertions.assertEquals('μ', chr.nextChar());
        Assertions.assertEquals('κ', chr.prevChar());
        Assertions.assertEquals(chr.OTHER, chr.charType());
        Assertions.assertEquals(-1, chr.alphabetNumber());
    }
}
