package Chess;

public class Knight extends Chess.Piece{
    public Knight(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2658';
        }else return '\u265E';
    }
    public static boolean can_move(Board board, int x, int y, int toX, int toY){
        if (Piece.can_move(board, x, y, toX, toY)) {
            return (abs(toX - x) == 2 && abs(toY - y) == 1) ||
                    (abs(toX - x) == 1 && abs(toY - y) == 2);
        }
        return false;
    }

    private static int abs(int n){
        if (n > 0) {return n;}
        else return -n;
    }
}
