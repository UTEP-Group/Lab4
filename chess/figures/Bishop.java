package chess.core;
import chess.enums.ChessColor;
import chess.enums.LocationX;
import chess.interfaces.IntBishop;

public class Bishop implements IntBishop {
    private ChessColor color;
    private LocationX column;
    private int row;

    public Bishop() {
        this(ChessColor.WHITE, LocationX.a, 1);
    }

    public Bishop(ChessColor color, LocationX col, int row) {
        if (color == null || !new ChessBoard().verifyCoordinate(col, row)) {
            throw new IllegalArgumentException("Invalid Bishop information");
        }
        this.color = color;
        column = col;
        this.row = row;
    }

    public ChessColor getColor() {
        return color;
    }

    public LocationX get_col() {
        return column;
    }

    public int get_row() {
        return row;
    }

    @Override
    public Boolean moveToBishop(LocationX X, int Y) {
        if (X == null || Y < 1 || Y > 8) {
            return false;
        }
        int colDiff = Math.abs(X.ordinal() - column.ordinal());
        int rowDiff = Math.abs(Y - row);
        return colDiff == rowDiff && colDiff > 0;
    }

    @Override
    public String toString() {
        return "BISHOP at " + column + ", " + row;
    }
}
