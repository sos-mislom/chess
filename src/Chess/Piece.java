package Chess;

import java.util.Objects;

public class Piece {
    public boolean colorIsWhite;
    private final char symbol;
    private boolean moved;

    public Piece(boolean color, char symbol){
        this.colorIsWhite = color;
        this.moved = false;
        this.symbol = symbol;
    }
    public boolean can_move(Board board, int x, int y, int toX, int toY){
        if (correct_coords(x, y) || correct_coords(toX, toY)) return true;
        if (x == toX && y == toY) return true;
        if (!Objects.equals(board.cell(toX, toY), "  ")){
            return board.get_piece(toX, toY).get_color() == this.colorIsWhite;
        }
        return false;
    }

    public static boolean correct_coords(int x, int y) {
        return (x < 0 || x >= 8) || (y < 0 || y >= 8);
    }

    public boolean get_color(){
        return this.colorIsWhite;
    }
    public char get_symbol(){
        return this.symbol;
    }

    public void set_moved(){
        this.moved = true;
    }

    public boolean is_moved(){
        return this.moved;
    }
}