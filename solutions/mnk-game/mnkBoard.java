package game;

import java.util.Arrays;
import java.util.Map;

public class mnkBoard implements Board, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.E, '.'
    );

    public static Cell[][] cells;
    public Cell turn;
    public static int m;
    public static int n;
    public static int k;

    public mnkBoard(int m, int n, int k) {
        this.cells = new Cell[m][n];
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
        this.m = m;
        this.n = n;
        this.k = k;
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
        }

        cells[move.getRow()][move.getColumn()] = move.getValue();

        int inDiag11 = 0;
        int inDiag12 = 0;
        int inDiag21 = 0;
        int inDiag22 = 0;
        int empty = 0;
        for (int u = 0; u < this.m; u++) {
            int inRow = 0;
            int inColumn = 0;
            for (int v = 0; v < this.n; v++) {
                if (cells[u][v] == turn) {
                    inRow++;
                    if (inRow == this.k) {
                        return Result.WIN;
                    }
                } else  {
                    inRow = 0;
                }
                if (v < this.m && u < this.n && cells[v][u] == turn) {
                    inColumn++;
                    if (inColumn == this.k) {
                        return Result.WIN;
                    }
                } else {
                    inColumn = 0;
                }
                if (cells[u][v] == Cell.E) {
                    empty++;
                }
                for (int j = 0; j < this.k; j++) {
                    if (u + j < m && v + j < n && cells[u+j][v+j] == turn) {
                        inDiag11++;
                        if (inDiag11 + inDiag12 == this.k && (inDiag11 == 0 || inDiag12 == 0)) {
                            return Result.WIN;
                        } else if (inDiag11 + inDiag12 - 1 == this.k) {
                            return Result.WIN;
                        }
                    } else {
                        inDiag11 = 0;
                    }
                    if (u + j < m && v - j >= 0 && cells[u+j][v-j] == turn) {
                        inDiag21++;
                        if (inDiag21 + inDiag22 == this.k && (inDiag21 == 0 || inDiag22 == 0)) {
                            return Result.WIN;
                        } else if (inDiag21 + inDiag22 - 1 == this.k) {
                            return Result.WIN;
                        }
                    } else {
                        inDiag21 = 0;
                    }
                    if (u - j >= 0 && v + j < n && cells[u-j][v+j] == turn) {
                        inDiag22++;
                        if (inDiag21 + inDiag22 == this.k && (inDiag21 == 0 || inDiag22 == 0)) {
                            return Result.WIN;
                        } else if (inDiag21 + inDiag22 - 1 == this.k) {
                            return Result.WIN;
                        }
                    } else {
                        inDiag22 = 0;
                    }
                    if (u - j >= 0 && v - j >= 0 && cells[u-j][v-j] == turn) {
                        inDiag12++;
                        if (inDiag11 + inDiag12 == this.k && (inDiag11 == 0 || inDiag12 == 0)) {
                            return Result.WIN;
                        } else if (inDiag11 + inDiag12 - 1 == this.k) {
                            return Result.WIN;
                        }
                    } else {
                        inDiag12 = 0;
                    }
                }
            }
        }
        if (empty == 0) {
            return Result.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return Result.UNKNOWN;
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
        for (int i = 0; i < this.n; i++) {
            sb.append(Integer.toString(i));
        }
        for (int r = 0; r < this.m; r++) {
            sb.append("\n");
            sb.append(r);
            for (int c = 0; c < this.n; c++) {
                sb.append(SYMBOLS.get(cells[r][c]));
            }
        }
        return sb.toString();
    }
}
