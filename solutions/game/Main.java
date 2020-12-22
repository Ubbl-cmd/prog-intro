package game;

import static game.Reader.*;
import static game.Tournament.tour;
import java.util.Map;
public class Main {

    protected static Map <String, Player> map;
    public static void main(String[] args) {
        int[] temp = Input();
        map = Map.of("H", new HumanPlayer(),
                "R", new RandomPlayer(),
                "S", new SequentialPlayer());
        Player[] players = new game.Player[r];
        for (int i = 0; i < r; i++) {
            int num = i + 1;
            System.out.println("Введите тип " + num + " игрока ('H', 'R' or 'S')");
            players[i] = map.get(readPlayer());
        }
        for (int i = 0; i < c; i++) {
            tour(temp, players,readMNK());
        }
        int[] table = Tournament.table;
        for (int i = 1; i <= table.length; i++) {
            System.out.println("Player " + i + " - " + table[i - 1]);
        }
    }
}
