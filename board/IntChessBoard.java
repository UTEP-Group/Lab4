package chess.interfaces;
import enums.LocationX;
import exceptions.InvalidCoordinateException;

public interface IntChessBoard {
    Boolean verifyCoordinate(LocationX X, int Y) throws InvalidCoordinateException;
}
