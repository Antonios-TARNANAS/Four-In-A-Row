import java.util.Scanner;

/**
 * A class that represents a game of Four in a Row.
 * The game is played on a 6x7 board.
 * A player wins when he has 4 pieces in a row, column or diagonal.
 *
 * ForInARow is a two-player connection rack game, in which the players choose a color and
 * then take turns dropping colored tokens into a six-row, seven-column vertically suspended grid.
 * The pieces fall straight down, occupying the lowest available space within the column.
 *
 * The objective of the game is to be the first to form a horizontal,
 * vertical, or diagonal line of four of one's own tokens.
 *
 * Your task is to model the game and implement the method hasWon(char player) that returns true.
 * if the player has won the game.
 * We advise you to model the state of the game with an internal 2D array of char.
 */
public class FourInARow {
    public static void main(String[] args) {
        FourInARow game = new FourInARow();

        Scanner scanner = new Scanner(System.in);

        String p1 = PLAYERS[0];
        String p2 = PLAYERS[1];
        game.printBoard(); // initial print
        while (!game.hasWon(p1) || !game.hasWon(p2)) {



                                // P1 plays
            System.out.print("\nP1 choisis une colonne -> colonne 1->7: ");
            int colonne_P1 = scanner.nextInt()-1;
            game.play(colonne_P1, p1);
            System.out.println("\n");
            game.printBoard();
            if (game.hasWon(p1)) {
                System.out.println("\nP1 HAS WON");
                game.printBoard(); 
                System.out.println("\nGAME OVER");
                break;
            } else if (game.hasWon(p2)){
                System.out.println("\nP2 HAS WON");
                game.printBoard();
                System.out.println("\nGAME OVER");
                break;
            } else {
                System.out.println("\n");
            }



                                // P2 plays
            System.out.print("\nP2 choisis une colonne -> colonne 1->7: ");
            int colonne_P2 = scanner.nextInt()-1;
            game.play(colonne_P2, p2);
            System.out.println("\n");
            game.printBoard();
            if (game.hasWon(p1)) {
                System.out.println("\nP1 HAS WON"); 
                game.printBoard();
                System.out.println("\nGAME OVER");
                break;
            } else if (game.hasWon(p2)){
                System.out.println("\nP2 HAS WON");
                game.printBoard();
                System.out.println("\nGAME OVER");
                
                break;
            } else {
                System.out.println("\n");
            }
        }
        scanner.close();
    }
    private static final int ROWS = 6;
    private static final int COLUMNS = 7  ;

    private static final String EMPTY = " -";
    private static final String[] PLAYERS = {" X", " O"};

    // add your own instance variables here
    private String[][] board = new String[ROWS][COLUMNS];


    public FourInARow() {
        // add your own code here
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    /**
     * Play a piece in column j for the given player.
     * @param j the column index
     * @param player the player (X or O)
     * @throws IllegalArgumentException
     * 1) if j is not a valid column index
     * 2) or if the column is full
     * 3) or if the player is not X or O
     */
    public void play(int j, String player) { // j is the column index
        
        //columns numbers are beginning from 0 (just in case)
        if (player == PLAYERS[0] || player == PLAYERS[1]) {// 3)
            // valid column index?
            // column j not full?
            for (int i = 0; i < ROWS; i++) {
                if (i == 0 && board[i][j] != EMPTY) {
                    throw new IllegalArgumentException();
                }
            }
            // bad j too big or small
            if (j < 0 || COLUMNS <= j) // 
                throw new IllegalArgumentException();


            for (int i = 0; i < ROWS; i++) { // 

                if (board[i][j] != EMPTY && i!=0 && board[i-1][j] == EMPTY) {
                    board[i-1][j] = player;
                } else if (i==ROWS-1 && board[i][j] == EMPTY) {
                    board[i][j] = player;
                }
            }

        } else {
            // bad argument for player
            throw new IllegalArgumentException();
        }

    }


    /**
     * Returns true if the player has won the game.
     * @param player the player (X or O)
     * @return true if the player has won the game
     * @throws IllegalArgumentException if the player is not X or O
     */
    public boolean hasWon(String player) {

        if (player == PLAYERS[0] || player == PLAYERS[1]) {


            // win condition vertical 4
            for (int i = 0; i < ROWS-3; i++) {

                for (int j = 0; j < COLUMNS; j++) {

                    if ((board[i][j] == player) &&
                            (board[i+1][j] == player) &&
                            (board[i+2][j] == player) &&
                            (board[i+3][j] == player)) {
                        return true;
                    }
                }
            }

            // win condition horizontal 4
            for (int i = 0; i < ROWS; i++) {

                for (int j = 0; j < COLUMNS-3; j++) {

                    if (board[i][j] == player &&
                            board[i][j+1] == player &&
                            board[i][j+2] == player &&
                            board[i][j+3] == player) {
                        return true;
                    }
                }
            }

            // win condition diagonal 4 " / "
            for (int i = 0; i < ROWS-3; i++) {

                for (int j = 0; j < COLUMNS-3; j++) {

                    if (board[i][j] == player &&
                            board[i+1][j+1] == player &&
                            board[i+2][j+2] == player &&
                            board[i+3][j+3] == player) {
                        return true;
                    }
                }
            }

            // win condition diagonal 4 " \ "
            for (int i = ROWS-3; i < ROWS; i++) {

                for (int j = 0; j < COLUMNS-3; j++) {

                    if (board[i][j] == player &&
                            board[i-1][j+1] == player &&
                            board[i-2][j+2] == player &&
                            board[i-3][j+3] == player) {
                        return true;
                    }
                }
            }
            return false;


        } else {
            // bad arg for player
            throw new IllegalArgumentException();
        }

    }

    void printBoard(){
        System.out.println("\n");
        for (int i = 0; i < ROWS; i++) {
            
            for (int j = 0; j < COLUMNS; j++) {
                
                System.out.print("|"+board[i][j]);
                System.out.print(" ");
                
            }System.out.println("|");

        }
        System.out.println("  1   2   3   4   5   6   7");
    }
}
