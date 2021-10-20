package Chess;

import java.util.ArrayList;

class Board {
    private boolean colorIsWhite = true;
    public static ArrayList<ArrayList<Piece>> field = new ArrayList<ArrayList<Piece>>();
    public ArrayList<Piece> sub_field = new ArrayList<>();
    private int x;
    private int y;
    public Board(){
        for (int i = 0; i < 8; i++) {
            this.sub_field.add(null);
        }
        for (int j = 0; j < 8; j++) {
            this.field.add(this.sub_field);
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
