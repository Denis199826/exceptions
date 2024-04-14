package util;

import model.UserData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class FileManager {
    // Метод для записи данных пользователя в файл
    public static void writeUserDataToFile(UserData userData) {
        String filename = userData.getLastName() + ".txt"; // Формируем имя файла
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            // Записываем данные пользователя в файл
            writer.write(userData.getLastName() + " " +
                    userData.getFirstName() + " " +
                    userData.getMiddleName() + " " +
                    userData.getBirthDate() + " " +
                    userData.getPhoneNumber() + " " +
                    userData.getGender() + "\n");
            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IOException e) {
            // В случае ошибки выводим сообщение об ошибке и стек-трейс
            System.err.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }
}
