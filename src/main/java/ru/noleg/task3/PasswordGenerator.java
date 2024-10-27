package ru.noleg.task3;

import java.util.Scanner;

public class PasswordGenerator {

    private static final String CHARACTERS =
            "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz`~!@#$%^&*()_-+={}[]|\\:;\"'<>,.?/";

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("Генерация пароля с фиксированной длинной (от 8 до 12).");
        System.out.println("Введите длину пароля:");

        int length = scanner.nextInt();


        if (length < 8 || length > 12) {
            throw new IllegalArgumentException("\"Пароль должен быть от 8 до 12 символов!\"");
        }

        var password = generatePassword(length);

        System.out.printf("Пароль: %s успешно сгенерирован!", password);

    }

    private static StringBuilder generatePassword(int length) {
        var password = new StringBuilder();
        int random;
        for (int i = 0; i < length; i++) {
            random = (int) (Math.random() * CHARACTERS.length());
            password.append(CHARACTERS.charAt(random));
        }

        return password;
    }

}
