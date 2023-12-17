package J105;

import java.util.Locale;

public class UnicodeCharInfo {
    char var;
    public UnicodeCharInfo(char symbol) {
        var = symbol;
    }
    public UnicodeCharInfo(int unicodeInt) {
        var = (char) unicodeInt;
    }

    public int unicodeInt() {
        return (int) var;
    }

    public String unicodeHex() {
        String strVar = Integer.toHexString((int)var).toUpperCase();
        return "U+" + "0".repeat(4 - strVar.length()) + strVar;
    }

    public char nextChar() {
        return (char) ((int) var + 1);
    }

    public char prevChar() {
        return (char) ((int) var - 1);
    }

    int DIGIT = 0;
    int LETTER_UPPER = 1;
    int LETTER_LOWER = 2;
    int SPACE = 3;
    int OTHER = 4;
    public int charType() {
        if (Character.isDigit(var)) return 0;
        if (Character.isAlphabetic(var)) {
            if (Character.isUpperCase(var)) return 1;
            return 2;
        }
        if (Character.isSpaceChar(var)) return 3;
        return 4;
    }
    public int alphabetNumber() {
        var intVar = (int) var;
        if (intVar > 64 && intVar < 91) return intVar - 64;
        if (intVar > 96 && intVar < 123) return intVar - 96;
        return -1;
    }
}
