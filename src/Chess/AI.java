package Chess;

import javafx.util.Pair;

import java.util.*;


public class AI {
    public static Map<Pair<Integer, Integer>, Piece> board2dict(Board board, boolean exceptNone){
        Map<Pair<Integer, Integer>, Piece> list_of_figures = new Hashtable<>();

        for (int x = 1; x < 8; x++) {
            for (int y = 1; y < 8; y++) {
                if(!exceptNone || board.field.get(y).get(x) != null) {
                    list_of_figures.put(new Pair<>(x, y), board.field.get(y).get(x));
                }
            }
        }

        return list_of_figures;
    }

    public static Map<Pair<Integer, Integer>, Piece> leaveOnly(Map<Pair<Integer, Integer>, Piece> field, boolean colorIsWhite) {
        Map<Pair<Integer, Integer>, Piece> rip_figures = new Hashtable<>();
        for (Pair<Integer, Integer> k: field.keySet()){
            if (field.get(k).get_color() == colorIsWhite) {
                rip_figures.put(k, field.get(k));
            }
        }
        return rip_figures;
    }

    public static List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> getPossibleMoves(Board board, boolean colorIsWhite) {
        Map<Pair<Integer, Integer>, Piece> field = leaveOnly(board2dict(board, true), colorIsWhite);
        List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> d = new ArrayList<>();

        for (Pair<Integer, Integer> coor : field.keySet()){
            for (int pos_x = 0; pos_x < 8; pos_x++){
                for (int pos_y = 0; pos_y < 8; pos_y++){
                    Pair<Integer, Integer> pos_coor = new Pair<>(pos_x, pos_y);
                    if (coor.equals(pos_coor)) continue;
                    if (field.get(coor).can_move(board, coor.getValue(), coor.getKey(), pos_y, pos_x)){
                        d.add(new Pair<>(coor, pos_coor));
                    }
                }
            }
        }

        return d;
    }

    public static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> randomMove(Board board) {
        Random random = new java.util.Random();
        List<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>> possibleMoves = getPossibleMoves(board, true);
        int random_computer_move = random.nextInt(possibleMoves.size());
        return possibleMoves.get(random_computer_move);
    }
    public static Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> bestMove(Board board, int depth){
            if (depth == 0) return null;
            return randomMove(board);
    }
}
