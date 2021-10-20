package Chess;

class Pawn extends Chess.Piece{

    public Pawn(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2659';
        }else return '\u265F';
    }

    public Pawn(boolean color, char symbol) {
        super(color, symbol);
    }
    public static boolean can_move(Board board, int x, int y, int toX, int toY) {
        int direction= 0, start_x =0 ;
        if (!(can_move( board, x, y, toX, toY))){
            return false;
        }
        if (y != toY){return false;}
        if (colorIsWhite) {
             direction = 1;
             start_x = 1;
        }
        else{
             direction = -1;
             start_x = 6;
        }
        if (x + direction == toX){
            return true;
        }
        if (x == start_x
        && x + 2 * direction == toX
        && board.field.get(x + direction).get(y) == null){
            return true;}
        else {
            return false;}
    }
}
