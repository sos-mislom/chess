package Chess;

public class Bishop extends Chess.Piece{
    public Bishop(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2657';
        }else return '\u265D';
    }
}
