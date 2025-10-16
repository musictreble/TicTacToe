import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    char player1Icon;
    char player2Icon;
//    String player1IconString;
//    String player2IconString;
    char nullType = '-';
    char[][] grid = new char[3][3];
    int row;
    int col;

    public TicTacToe(){
        buildGrid();
    }

    boolean quit = false;

    public void start(){

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("2 player or 1 player?");
        System.out.println("Enter '1' for one player mode, '2' for two player mode or 'q' for quit");
        while(!quit) {

            String command = new Scanner(System.in).nextLine();

            switch (command) {
                case "1":
                    System.out.println("Would you like to be X or O?");
                    player1Icon = new Scanner(System.in).nextLine().toUpperCase().charAt(0);  //.charAt(0) means that its retriving the char in index 0 of the string
                    System.out.println("You are: " + player1Icon);
                    break;


                case "2":
                    System.out.println("Would player 1 like to be O or X?");
                    player1Icon = new Scanner(System.in).nextLine().toUpperCase().charAt(0);

//                if(player1Icon == 'X'){
//                    player2Icon = 'O';
//                }
//                else {
//                    player2Icon = 'X';
//                } --> quicker way of writing this:

                    player2Icon = player1Icon == ('X') ? 'O' : 'X';


                    System.out.println("Player1 is " + player1Icon + " and player2 is " + player2Icon);
                    TwoPlayer twoPlayer = new TwoPlayer();
                    twoPlayer.player1Icon = player1Icon;
                    twoPlayer.player2Icon = player2Icon;
                    twoPlayer.game();
                    twoPlayer.printGrid(); //prints out the results of the game
                    break;


                case "q":
                    System.out.println("Quitting...");
                    quit = true;
                    break;


                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    /**
     * Old print function - printed array out with all rows on the same line
     */
//    public void printGrid(){
//        System.out.println(Arrays.deepToString(grid));
//    }

    /**
     * Prints out 2d array in grid form with one row on top of the other. --> OLD VERSION
     */
//    public void printGrid2(){
//        for (int i = 0; i < 3; i++) {
//            System.out.println(Arrays.toString(grid[i])); //prints in matrix style
//        }
//    }

    /**
     * NEW VERSION --> simpler version of printGrid2#
     * Each row is printed on a new line
     */
    public void printGrid(){
        for(char[] row : grid){
            System.out.println(Arrays.toString(row));
        }
    }


    /**
     * enterRow() - allows user to input which row they would like their icon to go
     * @return int row
     */
    public int enterRow(){
        System.out.println("Pick a row (enter number 1-3) ");
        return tryCatchNumbers("Row");
    }

    /**
     * enterCol() - allows user to input which col they would like their icon to go
     * @return int col
     */
    public int enterCol(){
        System.out.println("Pick a column (enter number 1-3) ");
        return tryCatchNumbers("Column");

    }

    /**
     * tryCatchNumbers() - Used in both enterCol and enterRow and catches input that is not of int type
     * Saves duplication of code
     * @param rowOrCol - string value - the type of number inputted by the user that is either a row or col depending on where its being used
     *                 - Used in the Warning message
     * @return rowColNum - int value - checked rowOrCol num is returned
     */
    public int tryCatchNumbers(String rowOrCol){
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int rowColNum = scanner.nextInt();
                if (0 < rowColNum && rowColNum < 4) {
                    rowColNum = rowColNum - 1;
                    return rowColNum;
                } else {
                    System.out.println("Invalid " + rowOrCol + ", try again");
                }
            } catch (Exception e) { //if player inputs anything but a number
                System.out.println("Invalid input");
            }
        }
    }

    public void buildGrid(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                grid[i][j] = nullType;
            }
        }
    }

    public void addIcon(char icon){
        while(true) {
            printGrid();
            row = enterRow();
            col = enterCol();
            if (grid[row][col] == nullType) { //if chosen grid location is empty, insert player1's icon
                grid[row][col] = icon;
                printGrid();
                return;
            } else {
                System.out.println("Space already occupied, pick another one");
            }
        }
    }


}
