import java.util.Scanner;
import java.util.Arrays;

public class TwoPlayer extends TicTacToe {

    char winner;

    public TwoPlayer() {
        super();
        TicTacToe game1 = new TicTacToe();
    }

    //Main game mechanic for 2 players - allows 9 plays before game finishes

    /**
     * using addIcon function to add the players icon to it's specified place
     * prints grid after every move
     */
    public void game(){
        winner = '/';
        while (winner == '/') {
            for (int i = 0; i < 9; ) {
                System.out.print("Player1, make your move: ");
//            row = enterRow();
//            col = enterCol();
//            grid[row][col] = player1Icon;
                addIcon(player1Icon);
                Scoring scoring = new Scoring();
                printGrid();
                winner = scoring.winner();
                i++;
                System.out.print("Player2, make your move: ");
                addIcon(player2Icon);
                printGrid();
                winner = scoring.winner();
                i++;
            }
        }

        System.out.println("Game Over! The winner is " + winner);
    }




}
