package Chess;

public class Rook extends Piece{
    public Rook(boolean colorIsWhite) {
        super(colorIsWhite, colorIsWhite ? '♖' : '♜');
    }

    public boolean can_move(Board board, int x, int y, int toX, int toY) {
        if (x == toX || y == toY) {
            if (x == toX) {
                if (y > toY) {
                    for (int i = y - 1; i > toY; i--)
                        if (!(board.field.get(x).get(i) == null)) return false;
                } else if (y < toY) {
                    for (int i = y + 1; i < toY; i++)
                        if (!(board.field.get(x).get(i) == null)) return false;
                }
            } else {
                if (x > toX) {
                    for (int i = x - 1; i > toX; i--)
                        if (!(board.field.get(i).get(y) == null)) return false;
                } else {
                    for (int i = x + 1; i < toX; i++)
                        if (!(board.field.get(i).get(y) == null)) return false;
                }
            }
            return true;
        }
        return false;
    }
}
