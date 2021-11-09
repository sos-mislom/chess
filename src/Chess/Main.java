package Chess;

import javafx.util.Pair;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static final Scanner get_str = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        while (true) {
            boolean flag = true;
            int x = 0, y = 0, toX = 0, toY = 0;
            sout_board(board);
            System.out.println("Команды:");
            System.out.println("    exit                     -- выход");
            System.out.println("    E2-E4                    -- ход из клетки E2 в E4");
            System.out.println("    0-0-0                    -- рокировка в длинную сторону");
            System.out.println("    0-0                      -- рокировка в короткую сторону");
            if (board.current_player_color()) {
                System.out.println("ХОД БЕЛЫХ");
            } else System.out.println("ХОД ЧЕРНЫХ");
            String command = input("! Введите команду \n! ");
            if (Objects.equals(command, "0-0-0")){
                if (!board.castling0()) {
                    System.out.println("Кастлинг невозможен((");
                }
            }
            else if (Objects.equals(command, "0-0")){
                if (!board.castling7()) {
                    System.out.println("Кастлинг невозможен((");
                }
            }
            else if (command.equals("exit")){
                break;
            }else{
                char[] c = command.toLowerCase().toCharArray();
                if (c[0] >= 'a' && c[0] <= 'h' && c[1] >= '1' && c[1] <= '8' &&
                        c[3] >= 'a' && c[3] <= 'h' && c[4] >= '1' && c[4] <= '8') {
                    x =(int)(c[1]) - 49;
                    y = (int)(c[0]) - 97;
                    toX =(int)(c[4]) - 49;
                    toY = (int)(c[3]) - 97;
                    if (board.move_piece(x, y, toX, toY)){ System.out.println("Ход успешен");flag = true;}
                    else{
                        System.out.println("Координаты некорректы! Попробуйте другой ход!");
                        flag = false;
                    }
                } else {System.out.println("Недопустимая команда! Попробуйте еще раз!");}
            }
            if (flag) {
                Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> move = AI.bestMove(board, 1);
                //boolean s = board.move_piece(move.getKey().getValue(), move.getKey().getKey(), move.getValue().getValue(), move.getValue().getKey());
                //System.out.println(s);
            }
        }

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
                else System.out.print("|   "+ board.cell(i - 1, j) + "  ");
            }
            System.out.println("|");
            System.out.println("     +----+----+----+----+----+----+----+----+");
        }
        System.out.print("        ");
        for (int i = 0; i < 8; i++) {
            System.out.print((char)(i + 65) + "    ");
        }
        System.out.println();
    }

    static String input(String str_){ // Красивый инпут
        System.out.print(str_);
        return get_str.next();
    }
}