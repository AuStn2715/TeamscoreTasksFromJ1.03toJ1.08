package J106;
import static J106.MicroTask2.textRedactor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextRedactorTest {
    @Test
    void test() {
        String inputText = "";
        String expectedText = "";
        Assertions.assertEquals(expectedText, textRedactor(inputText));

        inputText = "Да; и; но ((4))";
        expectedText = "";
        Assertions.assertEquals(expectedText, textRedactor(inputText));

        inputText = "Добрый день!";
        expectedText = "ДЕНЬ ДОБРЫЙ";
        Assertions.assertEquals(expectedText, textRedactor(inputText));

        inputText = "сине-зеленый";
        expectedText = "ЗЕЛЕНЫЙ СИНЕ";
        Assertions.assertEquals(expectedText, textRedactor(inputText));

        inputText = "Чашка кофе с молоком без сахара.";
        expectedText = "БЕЗ КОФЕ МОЛОКОМ САХАРА ЧАШКА";
        Assertions.assertEquals(expectedText, textRedactor(inputText));

        inputText = "Эх раз, да еще раз, да еще много-много раз!";
        expectedText = "ЕЩЕ МНОГО РАЗ";
        Assertions.assertEquals(expectedText, textRedactor(inputText));

        inputText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore" +
                " et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation CUPIDATAT DESERUNT DOLOR" +
                " DOLORE ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in" +
                " reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat" +
                " cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        expectedText = "ADIPISCING ALIQUA ALIQUIP AMET ANIM AUTE CILLUM COMMODO CONSECTETUR CONSEQUAT CULPA CUPIDATAT" +
                " DESERUNT DOLOR DOLORE DUIS EIUSMOD ELIT ENIM ESSE EST EXCEPTEUR EXERCITATION FUGIAT INCIDIDUNT IPSUM" +
                " IRURE LABORE LABORIS LABORUM LOREM MAGNA MINIM MOLLIT NISI NON NOSTRUD NULLA OCCAECAT OFFICIA PARIATUR" +
                " PROIDENT QUI QUIS REPREHENDERIT SED SINT SIT SUNT TEMPOR ULLAMCO VELIT VENIAM VOLUPTATE";
        Assertions.assertEquals(expectedText, textRedactor(inputText));
    }
}