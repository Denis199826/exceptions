package validator;

import java.util.regex.Pattern;
public class UserDataFormatValidator implements UserDataValidator {
    // Шаблоны для проверки формата даты рождения и пола
    private static final Pattern BIRTH_DATE_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
    private static final Pattern GENDER_PATTERN = Pattern.compile("[fm]");

    // Метод для валидации формата данных
    @Override
    public boolean validate(String data) {
        String[] parts = data.split("\\s+");
        // Проверяем количество элементов и соответствие формату даты рождения и пола
        return parts.length == 6 &&
                BIRTH_DATE_PATTERN.matcher(parts[3]).matches() &&
                parts[5].length() == 1 &&
                GENDER_PATTERN.matcher(parts[5]).matches();
    }
}