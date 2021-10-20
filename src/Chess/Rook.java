package Chess;

public class Rook extends Chess.Piece{
    public Rook(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2656';
        }else return '\u265C';
    }
}
