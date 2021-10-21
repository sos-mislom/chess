package Chess;

public class Rook extends Piece{
    public Rook(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2656';
        }else return '\u265C';
    }
    public static boolean can_move(Board board, int x, int y, int toX, int toY) {
        int step=0;
        if (!(Piece.can_move(board, x, y, toX, toY))) {
            return false;
        }
        if (x == toX || y == toY) {
            if (toY >= y) {
                step = -1;
            } else step = -1;
            for (int i = x + step; i < toX; i += step) {
                if (!(board.get_piece(i, y) == null)) {
                    return false;
                }
            }
            if (toX >= x) {
                step = 1;
            } else step = -1;
            for (int i = y + step; i < toY; i += step) {
                if (!(board.get_piece(x, i) == null)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
