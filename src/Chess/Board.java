package Chess;

import java.util.ArrayList;

class Board {
    private boolean colorIsWhite = true;
    ArrayList<ArrayList<Piece>> field = new ArrayList<>();
    ArrayList<Piece> sub_fields_of_white = new ArrayList<>();
    ArrayList<Piece> sub_fields_of_black = new ArrayList<>();
    ArrayList<Piece> sub_fields_of_white_pawn = new ArrayList<>();
    ArrayList<Piece> sub_fields_of_black_pawn = new ArrayList<>();
    public Board(){
        ArrayList<Piece> sub_field_of_null = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            sub_field_of_null.add(null);
        }
        for (int i = 0; i < 8; i++) {
            field.add(new ArrayList<>(sub_field_of_null));
        }
        create_array(true, sub_fields_of_white);
        create_array(false, sub_fields_of_black);
        create_array_of_pawn(true, sub_fields_of_white_pawn);
        create_array_of_pawn(false, sub_fields_of_black_pawn);
        for (int i = 0; i < 8; i++) {
                if (i == 0){
                    field.set(i, sub_fields_of_white);}
                else if (i == 1){
                    field.set(i,sub_fields_of_white_pawn);}
                else if (i == 6){
                    field.set(i,sub_fields_of_black_pawn);}
                else if (i == 7){
                    field.set(i,sub_fields_of_black);}
        }
    }
    static void create_array_of_pawn(boolean color, ArrayList<Piece> arr){
        for (int i = 0; i < 8; i++) {
            arr.add(new Pawn(color));
        }
    }
    static void create_array(boolean color, ArrayList<Piece> arr){
        arr.add(new Rook(color));
        arr.add(new Knight(color));
        arr.add(new Bishop(color));
        arr.add(new Queen(color));
        arr.add(new King(color));
        arr.add(new Bishop(color));
        arr.add(new Knight(color));
        arr.add(new Rook(color));
    }
    public Object cell(int x, int y){
        Piece piece = this.field.get(x).get(y);
        if (piece == null){
            return "  ";}
        return piece.get_symbol();
    }
    public Piece get_piece(int x, int y){
            if (correct_coords(x, y)){
                return this.field.get(x).get(y);
            }else return null;
    }
    public boolean correct_coords(int x, int y) {
        return ((0 <= x || x < 8) && (0 <= y || y < 8));
    }
    public boolean move_piece(int x, int y, int toX, int toY) {
        if (!correct_coords(x, y) || !correct_coords(toX, toY)) return false;
        if (x == toX && y == toY) return false;
        Piece piece = this.field.get(x).get(y);
        if (piece == null) return false;
        System.out.println(x+ " " + y + " " +toX+ " " + toY);
        if (!piece.can_move(this, x, y, toX, toY)) return false;

        this.field.get(x).set(y, null);
        this.field.get(toX).set(toY, piece);

        piece.set_moved();
        this.colorIsWhite = opponent(this.colorIsWhite);
        return true;
    }
    private boolean opponent(boolean colorIsWhite) {
        return !colorIsWhite;
    }

    public boolean current_player_color() {
        return this.colorIsWhite;
    }
}
