package game;

import game.MNKBoard;

public class SequentialPlayer implements Player {
    @Override
    public Move move(final Position position, final Cell cell) {
        for (int r = 0; r < MNKBoard.m; r++) {
            for (int c = 0; c < MNKBoard.n; c++) {
                if (MNKBoard.cells[r][c] == Cell.E) {
//                    System.out.println("Position");
//                    System.out.println(position);
//                    System.out.println(cell + "'s move");
//                    System.out.println("Enter row and column");
                }
                final Move move = new Move(r, c, cell);
                if (position.isValid(move) ) {
                    return move;
                }
            }
        }
        throw new IllegalStateException("No valid moves");
    }
}
