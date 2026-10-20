package chess.figures;
import enums.ChessPieceName;
import enums.ChessColor;
import enums.LocationX;
import exceptions.InvalidMoveException;

public class Knight extends Figure {
    public Knight() {
        super(ChessPieceName.KNIGHT, ChessColor.WHITE, LocationX.a, 1);
    }

    public Knight(ChessColor color, LocationX col, int row) {
        super(ChessPieceName.KNIGHT, color, col, row);
    }

    @Override
    public Boolean moveTo(LocationX X, int Y) throws InvalidMoveException {
        validateTarget(X, Y);

        int colDiff = Math.abs(X.ordinal() - get_col().ordinal());
        int rowDiff = Math.abs(Y - get_row());

        return (colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}
