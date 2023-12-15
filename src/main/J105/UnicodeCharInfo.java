package J105;

import java.util.Locale;

public class UnicodeCharInfo {
    char var;
    public UnicodeCharInfo(char symbol) {
        var = symbol;
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
    //ToDo
    public String charType() {
        return "";
    }
    public int alphabetNumber() {
        return 0;
    }
}
