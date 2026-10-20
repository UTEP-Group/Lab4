package board;
import enums.LocationX;
import chess.interfaces.IntChessBoard;
import exceptions.InvalidCoordinateException;

public class ChessBoard implements IntChessBoard {
    public static final int MIN_ROW = 1;
    public static final int MAX_ROW = 8;

    @Override
    public Boolean verifyCoordinate(LocationX X, int Y) throws InvalidCoordinateException {
        if (X == null || Y < MIN_ROW || Y > MAX_ROW) {
            throw new InvalidCoordinateException("Column must be a-h and row must be 1-8.");
        }

        return true;
    }
}
