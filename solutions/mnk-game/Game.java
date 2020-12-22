package game;

public class Game {
    private final boolean log;
    private final Player player1, player2;
    private int i;
    private int j;

    public Game(final boolean log, final Player player1, final Player player2, int i, int j) {
        this.i =i;
        this.j = j;
        this.log = log;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int play(Board board) {
        while (true) {
            final int result1 = movex(board, player1, i);
            if (result1 != -1) {
                System.out.println("Final position" + '\n' + board);
                return result1;
            }
            final int result2 = movex(board, player2, j);
            if (result2 != -1) {
                System.out.println("Final position" + '\n' + board);
                return result2;
            }
        }
    }

    private int movex(final Board board, final Player player, final int no) {
        final Move move = player.move(board.getPosition(), board.getCell());
        final Result result = board.makeMove(move);
        log("Player " + no + " move: " + move);
        log("Position:\n" + board);
        if (result == Result.WIN) {
            log("Player " + no + " won");
            return no;
        } else if (result == Result.LOSE) {
            log("Player " + no + " lose");
            if (no == i) {
                return j;
            } else {return i;}
        } else if (result == Result.DRAW) {
            log("Draw");
            return 0;
        } else {
            return -1;
        }
    }

    private void log(final String message) {
        if (log) {
            System.out.println(message);
        }
    }
}
