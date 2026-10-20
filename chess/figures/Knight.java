
package chess.core;
import chess.enums.ChessClass;
import chess.enums.ChessColor;
import chess.enums.LocationX;

public class Knight extends Figure {
    public Knight() {
        super(ChessClass.KNIGHT, ChessColor.WHITE, LocationX.a, 1);
    }

    public Knight(ChessColor color, LocationX col, int row) {
        super(ChessClass.KNIGHT, color, col, row);
    }

    @Override
    public Boolean moveTo(LocationX X, int Y) {
        if (X == null || Y < 1 || Y > 8) {
            return false;
        }
        int colDiff = Math.abs(X.ordinal() - get_col().ordinal());
        int rowDiff = Math.abs(Y - get_row());
        return (colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}
