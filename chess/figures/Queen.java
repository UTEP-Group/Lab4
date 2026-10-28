package chess.figures;
import enums.ChessPieceName;
import enums.ChessColor;
import enums.LocationX;
import exceptions.InvalidMoveException;
import interfaces.IntBishop;

public class Queen extends Rook implements IntBishop {
    public Queen() {
        super(ChessPieceName.QUEEN, ChessColor.WHITE, LocationX.a, 1);
    }

    public Queen(ChessColor color, LocationX col, int row) {
        this(ChessPieceName.QUEEN, color, col, row);
    }

    protected Queen(ChessPieceName name, ChessColor color, LocationX col, int row) {
        super(name, color, col, row);
    }

    @Override
    public boolean moveToBishop(LocationX X, int Y) throws InvalidMoveException {
        validateTarget(X, Y);

        int colDiff = Math.abs(X.ordinal() - get_col().ordinal());
        int rowDiff = Math.abs(Y - get_row());

        return colDiff == rowDiff && colDiff > 0;
    }

    @Override
    public boolean moveTo(LocationX X, int Y) throws InvalidMoveException {
        return super.moveTo(X, Y) || moveToBishop(X, Y);
    }

    @Override
    public String toString() {
        return get_piece_Name() + " at " + get_col() + ", " + get_row();
    }
}