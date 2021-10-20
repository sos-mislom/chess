package Chess;

import java.util.ArrayList;

class Board {
    private boolean colorIsWhite = true;
    static ArrayList<ArrayList<Piece>> field = new ArrayList<>();

    static ArrayList<Piece> sub_fields_of_white = new ArrayList<>();
    static ArrayList<Piece> sub_fields_of_black = new ArrayList<>();

    private int x;
    private int y;
    public Board(){
        create_array(true, sub_fields_of_white);
        create_array(false, sub_fields_of_black);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0){
                    field.get(i).set(j, sub_fields_of_white.get(j));}
                else if (i == 1){
                    field.get(i).set(j, new Pawn(true));}
                else if (i == 6){
                    field.get(i).set(j, new Pawn(false) );}
                else if (i == 7){
                    field.get(i).set(j, sub_fields_of_black.get(j));}
            }
        }
    }
    static void create_array(boolean color, ArrayList<Piece> arr){
        for (int i = 0; i < 8; i++) {
            arr.add(new Rook(color));
            arr.add(new Knight(color));
            arr.add(new Bishop(color));
            arr.add(new Queen(color));
            arr.add(new King(color));
            arr.add(new Bishop(color));
            arr.add(new Knight(color));
            arr.add(new Rook(color));
        }
    }
    public String cell(int x, int y){
        Piece piece = this.field.get(x).get(y);
        if (piece == null){
            return "  ";}
        boolean colorIsWhite = piece.get_color();
        char c;
        if (colorIsWhite){
            c = 'w';
        } else c = 'b';
        return String.valueOf(c + piece.get_symbol());
    }
    public Piece get_piece(int x, int y){
            if (correct_coords(x, y)){
                return this.field.get(x).get(y);
            }else return null;
    }
    public boolean correct_coords(int x, int y) {
        if ((x >= 0 && x < 8) && (y >= 0 && y < 8)) {
            return true;
        } else return false;
    }
}
