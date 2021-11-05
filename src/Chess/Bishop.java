package Chess;

public class Bishop extends Piece{
    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, (char)(colorIsWhite ? '♗' : '♝'));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2657';
        }else return '\u265D';
    }
    public boolean can_move(Board board, int x, int y, int toX, int toY){
        int stepx =1, stepy=1;
        if (!super.can_move(board, x, y, toX, toY)) {
            return abs(x - toX) != abs(y - toY);
        }else {
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
        return true;
    }

    private static int abs(int n){
        if (n > 0) {return n;}
        else return -n;
    }
}
