package interfaces;

import enums.LocationX;
import exceptions.InvalidMoveException;

public interface IntBishop {
    boolean moveToBishop(LocationX x, int y) throws InvalidMoveException;
}
