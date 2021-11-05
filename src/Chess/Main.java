package Chess;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        sout_board(board);
    }

    public static void sout_board(Board board) {
        System.out.println("     +----+----+----+----+----+----+----+----+");
        for (int i = 8; i > 0; i--) {
            System.out.print(" " + i + "   ");
            for (int j = 0; j < 8; j++) {
                if (board.cell(i - 1, j) == "  "){
                    System.out.print("| " + board.cell(i - 1, j) + " ");
                }
                else System.out.print("|  "+ board.cell(i - 1, j) + "  ");
            }
            System.out.println("|");
            System.out.println("     +----+----+----+----+----+----+----+----+");
        }
        System.out.print("      ");
        for (int i = 0; i < 8; i++) {
            System.out.print((char)(i + 65) + "    ");
        }
        System.out.println();
    }
}