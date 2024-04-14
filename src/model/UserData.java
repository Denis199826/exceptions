package model;

import validator.InvalidDataFormatException;

public class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    // Конструктор класса, принимающий строку с данными и создающий объект model.UserData
    public UserData(String input) throws InvalidDataFormatException {
        String[] parts = input.split("\\s+");
        // Проверяем, что количество элементов равно 6
        if (parts.length != 6) {
            throw new InvalidDataFormatException("Invalid number of data elements.");
        }

        // Заполняем поля объекта данными из входной строки
        lastName = parts[0];
        firstName = parts[1];
        middleName = parts[2];
        birthDate = parts[3];
        phoneNumber = Long.parseLong(parts[4]);
        gender = parts[5].charAt(0);
    }

    // Геттеры для доступа к полям объекта
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    // Переопределение метода toString для удобного вывода информации о пользователе
    @Override
    public String toString() {
        return "Фамилия: " + lastName + "\n" +
                "Имя: " + firstName + "\n" +
                "Отчество: " + middleName + "\n" +
                "Дата рождения: " + birthDate + "\n" +
                "Номер телефона: " + phoneNumber + "\n" +
                "Пол: " + gender;
    }
}
