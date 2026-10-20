package chess.core;
import chess.enums.ChessClass;
import chess.enums.ChessColor;
import chess.enums.LocationX;
import chess.interfaces.IntFigure;

public abstract class Figure implements IntFigure {
    private ChessClass piece_name;
    private ChessColor color;
    private LocationX column;
    private int row;

    public Figure() {
    }

    public Figure(ChessClass name, ChessColor color, LocationX col, int row) {
        set_piece_Name(name);
        setColor(color);
        set_col(col);
        set_row(row);
    }

    public ChessClass get_piece_Name() {
        return piece_name;
    }

    public ChessColor getColor() {
        return color;
    }

    public LocationX get_col() {
        return column;
    }

    public int get_row() {
        return row;
    }

    public void set_piece_Name(ChessClass name) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid piece name");
        }
        piece_name = name;
    }

    public void setColor(ChessColor color) {
        if (color == null) {
            throw new IllegalArgumentException("Invalid color");
        }
        this.color = color;
    }

    public void set_col(LocationX col) {
        if (col == null) {
            throw new IllegalArgumentException("Invalid column");
        }
        column = col;
    }

    public void set_row(int row) {
        if (row < ChessBoard.MIN_ROW || row > ChessBoard.MAX_ROW) {
            throw new IllegalArgumentException("Row must be between 1 and 8");
        }
        this.row = row;
    }
}
