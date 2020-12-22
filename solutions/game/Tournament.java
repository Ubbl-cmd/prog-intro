package game;

import static game.Reader.*;

public class Tournament  {

    public static int[] table = new int[Reader.r];
    public static void tour(int[] temp1, Player[] players, int[] temp2) {
        int n = temp2[0], m = temp2[1], k = temp2[2], r = temp1[0];
        Board board = new MNKBoard(m, n, k);
        for (int i = 1; i < r; i++) {
            for (int j = i + 1; j <= r; j++) {
                if (i != j) {
                    Game game = new Game(false, players[i - 1], players[j - 1], i, j);
                    int result;
                    result = game.play(board);
                    if (result == i) {
                        table[i - 1] += 3;
                    } else if (result == j) {
                        table[j - 1] += 3;
                    } else {
                        table[i - 1]++;
                        table[j - 1]++;
                    }
                    System.out.println("Between: " + i + " and " + j + '\n' + "Game result: " + result);
                    for (int q = 0; q < 30; q++) {
                        System.out.print('-');
                    }
                    System.out.println();
                    board.clear();
                }
            }
        }
    }
}

