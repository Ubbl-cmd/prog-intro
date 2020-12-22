package game;

import java.io.PrintStream;
import java.util.Scanner;
public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(final Scanner in) {
        this.in = in;
    }

    public HumanPlayer() {
        this(new Scanner(System.in));
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
            int r = in.nextInt();
            int c = in.nextInt();
            final Move move = new Move(r, c, cell);
            if (position.isValid(move)) {
                return move;
            }
        }
    }
}
