package ru.noleg.task2;

import java.util.Scanner;

public class VoluteConverter {

    private static final double USD = 0.0103;
    private static final double EUR = 0.0096;
    private static final double AED = 0.0380;
    private static final double TRY = 0.3539;
    private static final double UZS = 132.6015;


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Введите сумму (в рублях) для обмена:");
        double rubles = scanner.nextDouble();

        if (rubles <= 0) {
            throw new IllegalArgumentException("Введите корректную сумму (больше нуля)!");
        }

        System.out.println("Вы ввели: " + rubles + " RUB");

        System.out.print(
                """
                        Выберите валюту для конвертации:
                        1. USD (Доллар США)
                        2. EUR (Евро)
                        3. AED (Дирхам ОЭА)
                        4. TRY (Турецкая лира)
                        5. UZS (Узбекский сум)
                        """
        );

        int enter = scanner.nextInt();
        voluteConvert(enter, rubles);
    }

    private static void voluteConvert(int enter, double rubles) {
        switch (enter) {
            case 1 -> {
                double convertToUsd = rubles * USD;
                System.out.printf("RUB %.4f -> USD %.4f%n", rubles, convertToUsd);
            }
            case 2 -> {
                double convertToEur = rubles * EUR;
                System.out.printf("RUB %.4f -> EUR %.4f%n", rubles, convertToEur);
            }
            case 3 -> {
                double convertToAed = rubles * AED;
                System.out.printf("RUB %.4f -> AED %.4f%n", rubles, convertToAed);
            }
            case 4 -> {
                double convertToTry = rubles * TRY;
                System.out.printf("RUB %.4f -> TRY %.4f%n", rubles, convertToTry);
            }
            case 5 -> {
                double convertToUzs = rubles * UZS;
                System.out.printf("RUB %.4f -> UZS %.4f%n", rubles, convertToUzs);
            }

        }
    }
}
