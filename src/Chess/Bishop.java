package Chess;

public class Bishop extends Piece{
    public Bishop(boolean colorIsWhite) {
        super(colorIsWhite, (colorIsWhite ? '♗' : '♝'));
    }

    public boolean can_move(Board board, int x, int y, int toX, int toY){
        int stepx=0, stepy=0;
        if (!super.can_move(board, x, y, toX, toY)) {
            return false;
        }
        if (!(abs( toX-x) == abs(toY-y))){
            return false;
        }
        if (toY >= y) {stepx = 1;} else stepx = -1;
        if (toX >= x) {stepy = 1;}else stepy = -1;
        for (int i = 1; i < abs(toX - x); i++) {
            if (!(board.get_piece(x + i * stepy, y + i * stepx) == null))
                return false;
        }
        return true;
    }

    private static int abs(int n){
        if (n > 0) {return n;}
        else return -n;
    }
}
