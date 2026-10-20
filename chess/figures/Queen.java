
package chess.core;

import chess.enums.ChessClass;
import chess.enums.ChessColor;
import chess.enums.LocationX;
import chess.interfaces.IntBishop;

public class Queen extends Rook implements IntBishop {
    public Queen() {
        super(ChessClass.QUEEN, ChessColor.WHITE, LocationX.a, 1);
    }

    public Queen(ChessColor color, LocationX col, int row) {
        this(ChessClass.QUEEN, color, col, row);
    }

    protected Queen(ChessClass name, ChessColor color, LocationX col, int row) {
        super(name, color, col, row);
    }

    @Override
    public Boolean moveToBishop(LocationX X, int Y) {
        if (X == null || Y < 1 || Y > 8) {
            return false;
        }
        int colDiff = Math.abs(X.ordinal() - get_col().ordinal());
        int rowDiff = Math.abs(Y - get_row());
        return colDiff == rowDiff && colDiff > 0;
    }

    @Override
    public Boolean moveTo(LocationX X, int Y) {
        return super.moveTo(X, Y) || moveToBishop(X, Y);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}
