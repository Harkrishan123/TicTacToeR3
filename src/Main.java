import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static boolean gameFinished = false;


    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        String re1 = "([0-2])";
        String re2 = "(,)";
        String re3 = "([0-2])";

        Pattern p = Pattern.compile(re1 + re2 + re3, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        do {
            game.printBoard();

            System.out.print("Player '" + game.getCurrentPlayer() + "' input the coordinate where you want to place your mark: ");
            String move = in.nextLine();
            Matcher m = p.matcher(move);
            if(m.find()) {
                int row = Character.getNumericValue(move.charAt(0));
                int col = Character.getNumericValue(move.charAt(2));

                if (game.validMove(row,col)) {
                    game.insertMark(row, col);
                    game.nextPlayer();
                }

                if (game.checkWinner()) {
                    game.nextPlayer();
                    gameFinished = true;
                    game.printBoard();
                    System.out.println("Player" + game.getCurrentPlayer() + "wins the game!");

                } else if (game.checkDraw()) {
                    gameFinished = true;
                    game.printBoard();
                    System.out.println("We have a draw!");
                }

            }
            else{
                System.out.println("Please enter a valid coordinate");
            }

        } while (!gameFinished);
    }
}
