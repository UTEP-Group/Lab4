import board.ChessBoard;
import chess.figures.*;
import enums.ChessColor;
import enums.ChessPieceName;
import enums.LocationX;
import exceptions.InvalidCoordinateException;
import exceptions.InvalidMoveException;
import exceptions.InvalidPieceException;

import java.util.Scanner;

public class Main { 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessBoard board = new ChessBoard();
        Figure[] figures = new Figure[5]; // Stores Pawn, Rook, Knight, Queen, King
        Bishop standaloneBishop = null;

        // 1. Collect inputs for the 5 Figure array elements
        for (int i = 0; i < figures.length; i++) {
            System.out.println("\n Figure: " + (i + 1) + " of 5");
            boolean validEntry = false;
            while (!validEntry) {
                try {
                    ChessPieceName pieceName = readPieceName(scanner);
                    if (pieceName == ChessPieceName.BISHOP) {
                        System.out.println("Notice: Bishop cannot be added to Figure[] array.");
                        System.out.println("Please select PAWN, ROOK, KNIGHT, QUEEN, or KING.");
                        continue;
                    }

                    ChessColor color = readColor(scanner);
                    LocationX col = readColumn(scanner);
                    int row = readRow(scanner);

                    board.verifyCoordinate(col, row);

                    figures[i] = createFigure(pieceName, color, col, row);
                    validEntry = true;

                } catch (InvalidPieceException | InvalidCoordinateException e) {
                    System.out.println("Input Error: " + e.getMessage() + " Try again.");
                }
            }
        }

        // 2. Collect input specifically for the Standalone Bishop
        System.out.println("\nStandalone Bishop");
        boolean validBishop = false;
        while (!validBishop) {
            try {
                ChessColor color = readColor(scanner);
                LocationX col = readColumn(scanner);
                int row = readRow(scanner);

                board.verifyCoordinate(col, row);

                standaloneBishop = new Bishop(color, col, row);
                validBishop = true;

            } catch (InvalidCoordinateException e) {
                System.out.println("Input Error: " + e.getMessage() + " Try again.");
            }
        }

        // 3. Collect Target Position
        System.out.println("\nTarget Position");
        LocationX targetCol = null;
        int targetRow = -1;
        boolean validTarget = false;

        while (!validTarget) {
            try {
                targetCol = readColumn(scanner);
                targetRow = readRow(scanner);
                board.verifyCoordinate(targetCol, targetRow);
                validTarget = true;
            } catch (InvalidCoordinateException e) {
                System.out.println("Input Error: " + e.getMessage() + " Try again.");
            }
        }

        // 4. Traverse Polymorphic Array

        for (int i = 0; i < figures.length; i++) {
           Figure fig = figures[i];
           try {
               boolean canMove = fig.moveTo(targetCol, targetRow);
        
             if (canMove) {
                  System.out.println(fig.toString() + " CAN move to " + targetCol + targetRow);
              } else {
                 System.out.println(fig.toString() + " CANNOT move to " + targetCol + targetRow);
               }
        
           } catch (InvalidMoveException e) {
               System.out.println(fig.toString() + " invalid move attempt: " + e.getMessage());
           }
        }

        try {
            boolean bishopCanMove = standaloneBishop.moveToBishop(targetCol, targetRow);
            
            if (bishopCanMove) {
                System.out.println(standaloneBishop.toString() + " CAN move to " + targetCol + targetRow);
            } else {
                System.out.println(standaloneBishop.toString() + " CANNOT move to " + targetCol + targetRow);
            }
            
        } catch (InvalidMoveException e) {
            System.out.println(standaloneBishop.toString() + " invalid move : " + e.getMessage());
        }

        System.out.println("\nProgram executed and terminated successfully.");
        scanner.close();
    }

    private static ChessPieceName readPieceName(Scanner scanner) throws InvalidPieceException {
        System.out.print("Select piece name (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING): ");
        String input = scanner.next().toUpperCase();
        try {
            return ChessPieceName.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new InvalidPieceException("Invalid chess piece name '" + input + "'.");
        }
    }

    private static ChessColor readColor(Scanner scanner) {
        while (true) {
            System.out.print("Select color (WHITE, BLACK): ");
            String input = scanner.next().toUpperCase();
            try {
                return ChessColor.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid color selection. Please type WHITE or BLACK.");
            }
        }
    }

    private static LocationX readColumn(Scanner scanner) throws InvalidCoordinateException {
        System.out.print("Enter column (a-h): ");
        String input = scanner.next().toLowerCase();
        try {
            return LocationX.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new InvalidCoordinateException("Column must be a letter between 'a' and 'h'.");
        }
    }

    private static int readRow(Scanner scanner) throws InvalidCoordinateException {
        System.out.print("Enter row (1-8): ");
        try {
            int row = Integer.parseInt(scanner.next());
            if (row < 1 || row > 8) {
                throw new InvalidCoordinateException("Row must be between 1 and 8.");
            }
            return row;
        } catch (NumberFormatException e) {
            throw new InvalidCoordinateException("Row input must be an integer.");
        }
    }

    private static Figure createFigure(ChessPieceName type, ChessColor color, LocationX col, int row) {
        switch (type) {
            case PAWN:   return new Pawn(color, col, row);
            case ROOK:   return new Rook(color, col, row);
            case KNIGHT: return new Knight(color, col, row);
            case QUEEN:  return new Queen(color, col, row);
            case KING:   return new King(color, col, row);
            default:     return null;
        }
    }
}
