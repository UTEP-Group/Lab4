package chess.figures;

import enums.ChessColor;
import enums.LocationX;
import exceptions.InvalidMoveException;

public class Pawn extends Figure {

    public Pawn(ChessColor color, LocationX col, int row) {
        super("Pawn", color, col, row);
    }

    @Override
    public boolean moveTo(LocationX x, int y) throws InvalidMoveException {
        if (x == null) {
            throw new InvalidMoveException("Target column cant be null.");
        }
        boolean isSameColumn = (x == getCol());
        int currentRow = getRow();

        if (getColor() == ChessColor.WHITE) {
            if (isSameColumn && y == currentRow + 1) return true;
        } else {
            if (isSameColumn && y == currentRow - 1) return true;
        }
        return false;
    }
}
