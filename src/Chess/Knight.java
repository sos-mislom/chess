package Chess;

public class Knight extends Chess.Piece{
    public Knight(boolean color) {
        super(color, symbol(color));
    }

    private static char symbol(boolean color){
        if (color){
            return '\u2658';
        }else return '\u265E';
    }
}
