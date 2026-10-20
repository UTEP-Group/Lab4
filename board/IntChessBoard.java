
package chess.core;
import chess.enums.LocationX;
import chess.interfaces.IntChessBoard;

public class ChessBoard implements IntChessBoard {
    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;

    @Override
    public Boolean verifyCoordinate(LocationX X, int Y) {
        return X != null && Y >= MIN_ROW && Y <= MAX_ROW;
    }
}
