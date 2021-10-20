package Chess;

public class Queen extends Chess.Piece{
    public Queen(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2655';
        }else return '\u265B';
    }
}
