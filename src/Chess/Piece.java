package Chess;

import java.util.Objects;

public class Piece {
    public static boolean colorIsWhite;
    private static char symbol;
    private static boolean moved;

    public Piece(boolean color, char symbol){
        colorIsWhite = color;
        moved = false;
        Piece.symbol = symbol;
    }
    public static boolean can_move(Board board, int x, int y, int toX, int toY){
        if (!correct_coords(x, y) || !correct_coords(x, y)) return false;
        if (x == toX && y == toY)return false;
        if (Objects.equals(board.cell(toX, toY), "  ")){
            return board.get_piece(toX, toY).get_color() != colorIsWhite;
        }
        return true;
    }
    public static boolean correct_coords(int x, int y) {
        return (x >= 0 && x < 8) && (y >= 0 && y < 8);
    }

    public static boolean get_color(){
        return colorIsWhite;
    }
    public static char get_symbol(){
        return symbol;
    }
    public static boolean can_attack(Board board, int x, int y, int toX, int toY){
        return can_move(board, x, toX, y, toY);
    }

    public static void set_moved(){
        moved = true;
    }

    public static boolean is_moved(){
        return moved;
    }
}