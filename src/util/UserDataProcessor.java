package util;

import model.UserData;
import validator.InvalidDataFormatException;
import validator.UserDataValidator;

public class UserDataProcessor {
    private UserDataValidator[] validators; // Массив валидаторов данных

    // Конструктор класса, принимающий массив валидаторов
    public UserDataProcessor(UserDataValidator... validators) {
        this.validators = validators;
    }

    // Метод для обработки входных данных и создания объекта model.UserData
    public UserData process(String input) throws InvalidDataFormatException {
        // Проверяем данные с помощью каждого валидатора
        for (UserDataValidator validator : validators) {
            // Если данные не прошли валидацию, выбрасываем исключение с сообщением об ошибке
            if (!validator.validate(input)) {
                throw new InvalidDataFormatException("Invalid user data format.");
            }
        }
        // Если данные прошли все проверки, создаем объект model.UserData и возвращаем его
        return new UserData(input);
    }
}
