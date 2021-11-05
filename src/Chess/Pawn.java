package Chess;

class Pawn extends Piece{

    public Pawn(boolean colorIsWhite) {
        super(colorIsWhite, (char)(colorIsWhite ? '♙' : '♟'));
    }

    public boolean can_move(Board board, int x, int y, int toX, int toY) {
        int direction= 0, start_x =0 ;
        if (!super.can_move(board, x, y, toX, toY)) {
            if (y == toY) {
                if (this.colorIsWhite) {
                    direction = 1;
                    start_x = 1;
                } else {
                    direction = -1;
                    start_x = 6;
                }
                if (x + direction != toX) {
                    return x != start_x
                            || x + 2 * direction != toX
                            || board.field.get(x + direction).get(y) != null;
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

}
