package interfaces;

import enums.LocationX;
import exceptions.InvalidMoveException;

public interface IntFigure {
    boolean moveTo(LocationX x, int y) throws InvalidMoveException;
}
