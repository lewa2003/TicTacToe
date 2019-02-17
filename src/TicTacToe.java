import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    public static int [] field =   {0, 0, 0,
                                    0, 0, 0,
                                    0, 0, 0};

    public static void main(String[] Args) {
            boolean game_over = false;
            int current_player = 2;

            do {
                current_player = 3 - current_player;
                drawField();
                int n = getNumber();
                field[n] = current_player;
                game_over = isGameOver(n);
                if(isDraw()) {
                    drawField();
                    System.out.println("Draw");
                    return;
                }
            } while (!game_over);

            drawField();
            System.out.println();

            System.out.println("The winner is " + (current_player == 1 ? "X" : "O") + "!");

    }

    static int getNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                int n = Integer.parseInt(reader.readLine());
                if (n >= 0 && n < field.length && field[n]==0){
                    return n;
                }
                System.out.println("Choose free cell and enter its number");
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            }
            catch (IOException e) {
            }
        }
    }

    static boolean isGameOver(int n) {
        // 0 1 2
        // 3 4 5
        // 6 7 8

        int column = n%3;
        if(field[column] == field[column + 3] &&
            field[column + 3] == field[column + 6]) {
            return true;
        }

        int row = n/3 * 3;
        if(field[row] == field[row+1] &&
            field[row + 1] == field[row+2]) {
            return true;
        }

        int diag = n % 4;
        if(diag == 0) {
            if(field[diag] == field[diag + 4] &&
                field[diag + 4] == field[diag + 8]) {
                return true;
            }
        }

        if(diag == 2) {
            if(field[diag] == field[diag + 2] &&
                field[diag + 2] == field[diag + 4]) {
                return true;
            }
        }

        return false;
    }

    static void drawField() {
        for(int i = 0; i < field.length; ++i) {
            if(i % 3 == 0 && i != 0) {
                System.out.println(" " + (i-3) + (i-2) + (i-1));
            }
            if (field[i] == 0) {
                System.out.print("*");
            }
            else if(field[i] == 1) {
                System.out.print("X");
            }
            else {
                System.out.print("O");
            }
        }
        System.out.println(" 678");
    }

    static boolean isDraw() {
        for(int i : field) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}
