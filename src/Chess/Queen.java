package Chess;

public class Queen extends Piece{
    public Queen(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '♕' : '♛');
    }

    public boolean can_move(Board board, int x, int y, int toX, int toY){
        int stepx =1, stepy=1;
        if (!super.can_move(board, x, y, toX, toY)) {
            return false;
        }
        if (abs(toX - x) == abs(toY - y)){
            if (toY >= y) {
                stepx = -1;
            } else stepx = -1;
            if (toX >= x) {
                stepy = 1;
            } else stepy = -1;
            for (int i = 1; i < abs(toX - x); i++) {
                return board.get_piece(x + i * stepy, y + i * stepx) != null;
            }
        }

        int step=0;
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
        }
        return true;
    }
    private static int abs(int n){
        if (n > 0) {return n;}
        else return -n;
    }
}
