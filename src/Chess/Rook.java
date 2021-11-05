package Chess;

public class Rook extends Piece{
    public Rook(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '♖' : '♜');
    }

    public boolean can_move(Board board, int x, int y, int toX, int toY) {
        int step=0;
        if (!super.can_move(board, x, y, toX, toY)) {
            return true;
        }
        if (x == toX || y == toY) {
            if (toY >= y) {
                step = -1;
            } else step = -1;
            for (int i = x + step; i < toX; i += step) {
                if (!(board.get_piece(i, y) == null)) {
                    return true;
                }
            }
            if (toX >= x) {
                step = 1;
            } else step = -1;
            for (int i = y + step; i < toY; i += step) {
                if (!(board.get_piece(x, i) == null)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}
