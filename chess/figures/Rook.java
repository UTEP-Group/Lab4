package chess.core;
import chess.enums.ChessClass;
import chess.enums.ChessColor;
import chess.enums.LocationX;

public class Rook extends Figure {
    public Rook() {
        super(ChessClass.ROOK, ChessColor.WHITE, LocationX.a, 1);
    }

    public Rook(ChessColor color, LocationX col, int row) {
        this(ChessClass.ROOK, color, col, row);
    }

    protected Rook(ChessClass name, ChessColor color, LocationX col, int row) {
        super(name, color, col, row);
    }

    @Override
    public Boolean moveTo(LocationX X, int Y) {
        if (X == null || Y < 1 || Y > 8) {
            return false;
        }
        boolean sameRow = Y == get_row();
        boolean sameColumn = X == get_col();
        return (sameRow || sameColumn) && !(sameRow && sameColumn);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}
