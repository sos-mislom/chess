package Chess;

public class King extends Chess.Piece{
    public King(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2654';
        }else return '\u265A';
    }
}
