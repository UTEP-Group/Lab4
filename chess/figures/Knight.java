package chess.figures;
import enums.ChessPieceName;
import enums.ChessColor;
import enums.LocationX;
import exceptions.InvalidMoveException;

public class Pawn extends Figure {
    public Pawn() {
        super(ChessPieceName.PAWN, ChessColor.WHITE, LocationX.a, 1);
    }

    public Pawn(ChessColor color, LocationX col, int row) {
        super(ChessPieceName.PAWN, color, col, row);
    }

    @Override
    public Boolean moveTo(LocationX X, int Y) throws InvalidMoveException {
        validateTarget(X, Y);

        if (X != get_col()) {
            return false;
        }

        if (getColor() == ChessColor.WHITE) {
            return Y == get_row() + 1;
        }

        return Y == get_row() - 1;
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}
