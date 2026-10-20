package chess.figures;
import enums.ChessPieceName;
import enums.ChessColor;
import enums.LocationX;
import exceptions.InvalidMoveException;

public class Rook extends Figure {
    public Rook() {
        super(ChessPieceName.ROOK, ChessColor.WHITE, LocationX.a, 1);
    }

    public Rook(ChessColor color, LocationX col, int row) {
        this(ChessPieceName.ROOK, color, col, row);
    }

    protected Rook(ChessPieceName name, ChessColor color, LocationX col, int row) {
        super(name, color, col, row);
    }

    @Override
    public Boolean moveTo(LocationX X, int Y) throws InvalidMoveException {
        validateTarget(X, Y);

        boolean sameRow = Y == get_row();
        boolean sameColumn = X == get_col();

        return (sameRow || sameColumn) && !(sameRow && sameColumn);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}
