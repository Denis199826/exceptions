import model.UserData;
import util.FileManager;
import util.UserDataProcessor;
import validator.InvalidDataFormatException;
import validator.UserDataFormatValidator;
import validator.UserDataPhoneNumberValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные пользователя в формате: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
            String userDataString = scanner.nextLine(); // Считываем данные с консоли

            // Создаем объект процессора для обработки данных пользователя
            UserDataProcessor processor = new UserDataProcessor(
                    new UserDataFormatValidator(), // Валидатор формата данных
                    new UserDataPhoneNumberValidator() // Валидатор номера телефона
            );

            // Обрабатываем введенные данные и создаем объект model.UserData
            UserData userData = processor.process(userDataString);

            // Записываем данные пользователя в файл
            FileManager.writeUserDataToFile(userData);

            // Выводим данные пользователя на консоль
            System.out.println("Введенные данные пользователя:");
            System.out.println(userData.toString());
        } catch (InvalidDataFormatException e) {
            // Если возникла ошибка в формате данных, выводим сообщение об ошибке на консоль
            System.out.println("Ошибка в формате данных: " + e.getMessage());
        }
    }
}