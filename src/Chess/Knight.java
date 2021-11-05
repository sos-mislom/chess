package Chess;

public class Knight extends Piece{
    public Knight(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '♘' : '♞');
    }

    public boolean can_move(Board board, int x, int y, int toX, int toY){
        if (!super.can_move(board, x, y, toX, toY)) {
            return (abs(toX - x) != 2 || abs(toY - y) != 1) &&
                    (abs(toX - x) != 1 || abs(toY - y) != 2);
        }
        return true;
    }

    private static int abs(int n){
        if (n > 0) {return n;}
        else return -n;
    }
}
