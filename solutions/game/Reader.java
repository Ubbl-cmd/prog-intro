package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader {
    static int n = 0, m = 0, k = 0, c = 0, r = 0;
    private static Scanner in = new Scanner(System.in);

    public static int[] Input() {
        try {
            System.out.println("Введите количество кругов турнира");
            c = in.nextInt();
            System.out.println("Введите количество игроков");
            r = in.nextInt();
            if (c < 0 || r < 0) {
                System.out.println("Вы вывели отрицательные значения");
                Input();
            }

        } catch (InputMismatchException e) {
            System.out.println("Неравильный формат ввода, попробуйте ещё раз (разрешается вводить только натуральные числа)" + '\n');
            in.next();
            Input();
        }
        return new int [] {r, c};
    }
    public static String readPlayer() {
        String s = in.next();
        while (!s.equals("H") && !s.equals("S") && !s.equals("R")) {
            System.out.println("Некоректный ввод, попробуйте её раз");
            s = in.next();
        }
        return s;
    }
    public static int[] readMNK() {
        try {
            System.out.println("Введите n");
            n = in.nextInt();
            System.out.println("Введите m");
            m = in.nextInt();
            System.out.println("Введите k");
            k = in.nextInt();
            if (k > Integer.max(m, n) || n < 0 || m < 0 || k < 0) {
                System.out.println("Невозмонжно выйграть, k > max(m, n) или вы вывели отрицательные значения");
                readMNK();
            }

        } catch (InputMismatchException e) {
            System.out.println("Неравильный формат ввода, попробуйте ещё раз (разрешается вводить только натуральные числа)" + '\n');
            in.next();
            readMNK();
        }
        return new int [] {m, n, k};
    }
}
