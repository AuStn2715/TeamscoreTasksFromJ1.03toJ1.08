package J105;

public class MicroTask2 {
    public static String regularDefiner(String text) {
        // взял допустимые для имени с gmail, но для тестов нужно еще разрешить '_'
        if (text.matches("\\s*[a-zA-Zа-яА-Я0-9.!\"#$%^:;?*_]{6,30}@[a-zA-Z]+\\.[a-zA-Z.]+"))
            return "email";
        if (text.matches("\\s*\\+7-?\\(?[0-9]{3}\\)?-?[0-9]{3}-?[0-9]{2}-?[0-9]{2}"))
            return "телефон";
        if (text.matches("\\s*[0-9]{10}")||text.matches("\\s*[0-9]{12}"))
            return "ИНН";
        if (text.matches("\\s*[a-zA-Z][a-zA-Z0-9_$.]{7,}"))
            return "username";
        return "none";
    }
}
