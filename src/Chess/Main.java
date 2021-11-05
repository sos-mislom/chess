package Chess;

import java.util.Scanner;

public class Main {
    private static final Scanner get_str = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        while (true){
            int x=0, y=0, toX=0, toY = 0;
            sout_board(board);
            System.out.println("Команды:");
            System.out.println("    exit                     -- выход");
            System.out.println("    E2-E4                    -- ход из клетки E2 в E4");
            if (board.current_player_color()){
                System.out.println("ХОД БЕЛЫХ");
            }else System.out.println("ХОД ЧЕРНЫХ");
            String command = input("! Введите команду \n! ");
            if (command.equals("exit")){
                break;
            }else{
                char[] c = command.toLowerCase().toCharArray();
                if (c[0] >= 'a' && c[0] <= 'h' && c[1] >= '1' && c[1] <= '8' &&
                        c[3] >= 'a' && c[3] <= 'h' && c[4] >= '1' && c[4] <= '8') {
                    x =(int)(c[1]) - 49;
                    y = (int)(c[0]) - 97;
                    toX =(int)(c[4]) - 49;
                    toY = (int)(c[3]) - 97;
                    System.out.println(x + " " + y + " " + toX + " " + toY);
                    if (board.move_piece(x, y, toX, toY)){ System.out.println("Ход успешен");}
                    else{
                        System.out.println("Координаты некорректы! Попробуйте другой ход!");
                    }
                } else {System.out.println("Недопустимая команда! Попробуйте еще раз!");}
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
        System.out.print("      ");
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