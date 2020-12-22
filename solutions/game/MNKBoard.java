package game;

import java.util.Arrays;
import java.util.Map;

public class MNKBoard implements Board, Position {
    static int enu = 0;
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    public static Cell[][] cells;
    private Cell turn;
    private Move move;
    public static int m;
    public static int n;
    public static int k;

    public MNKBoard(final int m,final int n,final int k) {
        cells = new Cell[m][n];
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        MNKBoard.m = m;
        MNKBoard.n = n;
        MNKBoard.k = k;
        enu = 0;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public Cell getCell() {
        return turn;
    }

    @Override
    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;
        } else {
            enu++;
        }
        cells[move.getRow()][move.getColumn()] = move.getValue();

        this.move = move;

        if (hasWon()) {
            enu = 0;
            return Result.WIN;
        }
        if (enu == n * m) {
            enu = 0;
            return Result.DRAW;
        }
        turn = turn == Cell.X ? Cell.O : Cell.X;
        return Result.UNKNOWN;
    }

    private boolean hasWon() {
        return keker(1, 0) >= k
                || keker(0, 1) >= k
                || keker(1, 1) >= k
                || keker(1, -1) >= k;
    }

    private int keker(int i, int j) {
        int res = 1;
        int r = move.getRow() + i;
        int c = move.getColumn() + j;
        while (inside(r, c) && cells[r][c] == turn) {
            r += i;
            c += j;
            res++;
        }
        r = move.getRow() - i;
        c = move.getColumn() - j;
        while (inside(r, c) && cells[r][c] == turn) {
            r -= i;
            c -= j;
            res++;
        }
        return res;
    }

    private boolean inside(int r, int c) {
        return (r < m && c < n) && (r >= 0 && c >= 0);
    }

    @Override
    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < m
                && 0 <= move.getColumn() && move.getColumn() < n
                && cells[move.getRow()][move.getColumn()] == Cell.E
                && turn == getCell();
    }

    @Override
    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        sb.append(" ".repeat(Integer.toString(n).length()));
        for (int i = 0; i < n; i++) {
            sb.append(i);
            sb.append(" ".repeat(Integer.toString(n).length() - Integer.toString(i).length() + 1));
        }
        for (int r = 0; r < m; r++) {
            sb.append("\n");
            sb.append(r);
            sb.append(" ".repeat(Integer.toString(n).length() - Integer.toString(r).length() + 1));
            for (int c = 0; c < n; c++) {
                sb.append(SYMBOLS.get(cells[r][c]));
                sb.append(" ".repeat(Integer.toString(n).length()));
            }
        }
        return sb.toString();
    }
    @Override
    public void clear () {
        for (int i  = 0; i < m; i ++) {
            for (int j = 0;  j < n; j ++) {
                cells[i][j] = Cell.E;
            }
        }
    }
}
