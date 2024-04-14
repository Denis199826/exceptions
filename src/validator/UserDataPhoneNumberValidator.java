package validator;

import validator.UserDataValidator;

public class UserDataPhoneNumberValidator implements UserDataValidator {
    // Метод для валидации номера телефона
    @Override
    public boolean validate(String data) {
        try {
            // Пробуем преобразовать пятый элемент данных в число
            Long.parseLong(data.split("\\s+")[4]);
            return true; // Если успешно, возвращаем true
        } catch (NumberFormatException e) {
            return false; // В противном случае, возвращаем false
        }
    }
}
