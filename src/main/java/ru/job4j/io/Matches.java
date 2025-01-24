package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;

        while (true) {
            for (int i = 0; i < count; i++) {
                System.out.print("| ");
            }
            System.out.println();
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + "введите число от 1 до 3");
            int matches = Integer.parseInt(input.nextLine().trim());
            if (matches < 1 || matches > 3) {
                System.out.println("Ошибка!");
                continue;

            }
            turn = !turn;
            count = count - matches;
            if (count == 1) {
                System.out.println("Игрок выиграл" + player);
                break;
            }
        }
    }
}