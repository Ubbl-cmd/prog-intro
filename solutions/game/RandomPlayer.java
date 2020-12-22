package game;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random random;

    public RandomPlayer(final Random random) {
        this.random = random;
    }

    public RandomPlayer() {
        this(new Random());
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
//            System.out.println("Position");
//            System.out.println(position);
//            System.out.println(cell + "'s move");
//            System.out.println("Enter row and column");
            int r = random.nextInt(MNKBoard.m);
            int c = random.nextInt(MNKBoard.n);
            final Move move = new Move(r, c, cell);
            if (position.isValid(move)) {
                return move;
            }
        }
    }
}
