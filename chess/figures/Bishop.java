package chess.figures;
import enums.ChessColor;
import enums.LocationX;
import interfaces.IntBishop;
import exceptions.InvalidMoveException;

public class Bishop implements IntBishop {
    private ChessColor color;
    private LocationX column;
    private int row;

    public Bishop() {
        this(ChessColor.WHITE, LocationX.a, 1);
    }

    public Bishop(ChessColor color, LocationX col, int row) {
        if (color == null || col == null || row < 1 || row > 8) {
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
    public boolean moveToBishop(LocationX X, int Y) throws InvalidMoveException {
        if (X == null || Y < 1 || Y > 8) {
            throw new InvalidMoveException("Target position must be within the chessboard.");
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