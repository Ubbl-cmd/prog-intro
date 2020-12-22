package game;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int m, n, k, c;

    public static void Input() {
        Scanner sc = new Scanner(System.in);
        try {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            c = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Неравильный формат ввода, попробуйте ещё раз");
            Input();
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Input();
        if (k > Integer.max(m, n) && n > 0 && m > 0) {
            System.out.println("Невозмонжно выйграть");
        } else {
            int[] table = new int[c];
            for (int i = 1; i <= c; i++) {
                for (int j = 1; j <= c; j++) {
                    if (i != j) {
                        Game game = new Game(false, new RandomPlayer(), new RandomPlayer(), i, j);
                        int result;
                        result = game.play(new mnkBoard(m, n, k));
                        if (result == i) {
                            table[i - 1] += 3;
                        } else if(result == j) {
                            table[j - 1] += 3;
                        } else {
                            table[i - 1]++;
                            table[j - 1]++;
                        }
                        System.out.println("Game result: " + result);
                        for (int r = 0; r < 30; r++) {
                            System.out.print('-');
                        }
                        System.out.println();
                    }
                }
            }
            for (int i = 1; i <= c; i++) {
                System.out.println("Player" + i + " - " +table[i - 1]);
            }
        }
    }
}
