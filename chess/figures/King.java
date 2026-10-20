package chess.core;
import chess.enums.ChessClass;
import chess.enums.ChessColor;
import chess.enums.LocationX;

public class King extends Queen {
    public King() {
        super(ChessClass.KING, ChessColor.WHITE, LocationX.a, 1);
    }

    public King(ChessColor color, LocationX col, int row) {
        super(ChessClass.KING, color, col, row);
    }

    @Override
    public Boolean moveTo(LocationX X, int Y) {
        if (X == null || Y < 1 || Y > 8) {
            return false;
        }
        int colDiff = Math.abs(X.ordinal() - get_col().ordinal());
        int rowDiff = Math.abs(Y - get_row());
        return colDiff <= 1 && rowDiff <= 1 && (colDiff > 0 || rowDiff > 0);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}
