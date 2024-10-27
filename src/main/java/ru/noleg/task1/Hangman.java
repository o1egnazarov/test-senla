package ru.noleg.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    private static final List<String> WORDS = new ArrayList<>() {{
        add("радуга");
        add("дружба");
        add("компьютер");
        add("ноутбук");
        add("java");
    }};

    private static final String[] HANGMAN_STAGES = {
            """
           +---+
           |   |
               |
               |
               |
               |
        =========
        """,
            """
           +---+
           |   |
           O   |
               |
               |
               |
        =========
        """,
            """
           +---+
           |   |
           O   |
           |   |
               |
               |
        =========
        """,
            """
           +---+
           |   |
           O   |
          /|   |
               |
               |
        =========
        """,
            """
           +---+
           |   |
           O   |
          /|\\  |
               |
               |
        =========
        """,
            """
           +---+
           |   |
           O   |
          /|\\  |
          /    |
               |
        =========
        """,
            """
           +---+
           |   |
           O   |
          /|\\  |
          / \\  |
               |
        =========
        """
    };

    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        int random = (int) (Math.random() * WORDS.size());
        String word = WORDS.get(random);

        int lives = 6;


        StringBuilder mysteriousWord = new StringBuilder("_".repeat(word.length()));

        while (lives >= 0) {

            if (lives == 0) {
                displayHangman(lives);
                System.out.printf("Вы проиграли! Загаданное слово было: %s\n", word);
                return;
            }

            if (mysteriousWord.toString().equals(word)) {
                System.out.printf("Поздравляем! Вы угадали слово: %s\n", mysteriousWord);
                return;
            }

            displayHangman(lives);
            System.out.printf("Счетчик жизней: %d\n", lives);
            System.out.printf("Загаданное слово: %s\n", mysteriousWord);
            System.out.print("Введите букву: ");
            char letter = scanner.next().charAt(0);

            boolean contain = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    mysteriousWord.setCharAt(i, letter);
                    contain = true;
                }
            }

            if (!contain) {
                lives--;
            }

        }
    }

    private static void displayHangman(int stage) {
        System.out.println(HANGMAN_STAGES[6 - stage]);
    }
}
