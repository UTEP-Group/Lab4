package chess.figures;
import enums.ChessPieceName;
import enums.ChessColor;
import enums.LocationX;
import exceptions.InvalidMoveException;

public class King extends Queen {
    public King() {
        super(ChessPieceName.KING, ChessColor.WHITE, LocationX.a, 1);
    }

    public King(ChessColor color, LocationX col, int row) {
        super(ChessPieceName.KING, color, col, row);
    }

    @Override
    public boolean moveTo(LocationX X, int Y) throws InvalidMoveException {
        validateTarget(X, Y);

        int colDiff = Math.abs(X.ordinal() - get_col().ordinal());
        int rowDiff = Math.abs(Y - get_row());

        return colDiff <= 1 && rowDiff <= 1 && (colDiff > 0 || rowDiff > 0);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}