package Chess;

public class King extends Piece{
    public King(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '♔' : '♚');
    }

    public boolean can_move(Board board, int x, int y, int toX, int toY){
        if (!super.can_move(board, x, y, toX, toY)) {
            return abs(x - toX) > 1 || abs(y - toY) > 1;
        }
        return true;
    }

    private static int abs(int n){
        if (n > 0) {return n;}
        else return -n;
    }
}
