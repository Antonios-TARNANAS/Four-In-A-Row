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
        while (!game.hasWon(p1) || !game.hasWon(p2)) { // P1 plays



                                
            System.out.print("\n"+GREENp1+"P1"+RESET+" choisis une colonne -> colonne 1->7: ");
            int colonne_P1 = scanner.nextInt()-1;
            //
            boolean ilachoisiunebonnecolonneP1 = false;
            while (!ilachoisiunebonnecolonneP1) {
                try {
                    game.play(colonne_P1, p1);
                    ilachoisiunebonnecolonneP1 = true;
                } catch (IllegalArgumentException e) {
                    ilachoisiunebonnecolonneP1 = false;
                    System.out.print("\n"+GREENp1+"P1"+RESET+" choisis une  autre colonne car erreur avec celle-ci -"+RED+(colonne_P1+1)+RESET+"-  : ");
                    int colonne_mod = scanner.nextInt()-1;
                    //System.out.println(colonne_mod);
                    while (colonne_mod == colonne_P1) {
                        System.out.println(GREENp1+"P1"+RESET+" Veuillez choisir une autre colonne que "+RED+(colonne_P1+1)+RESET+" s'il vous plait:");
                        colonne_mod = scanner.nextInt()-1;

                    }
                    ilachoisiunebonnecolonneP1 = true;
                    game.play(colonne_mod, p1);
                }
            }
            //
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



                                
            System.out.print("\n"+MAGENTAp2+"P2"+RESET+" choisis une colonne -> colonne 1->7: "); // P2 plays
            int colonne_P2 = scanner.nextInt()-1;
            //
            boolean ilachoisiunebonnecolonneP2 = false;
            while (!ilachoisiunebonnecolonneP2) {
                try {
                    game.play(colonne_P2, p2);
                    ilachoisiunebonnecolonneP2 = true;
                } catch (IllegalArgumentException e) {
                    ilachoisiunebonnecolonneP2 = false;
                    System.out.print("\n"+MAGENTAp2+"P2"+RESET+" choisis une  autre colonne car erreur avec celle-ci -"+RED+(colonne_P2+1)+RESET+"-  : ");
                    int colonne_mod = scanner.nextInt()-1;
                    //System.out.println(colonne_mod);
                    while (colonne_mod == colonne_P2) {
                        System.out.println(MAGENTAp2+"P2"+RESET+" Veuillez choisir une autre colonne que "+RED+(colonne_P2+1)+RESET+" s'il vous plait:");
                        colonne_mod = scanner.nextInt()-1;

                    }
                    ilachoisiunebonnecolonneP2 = true;
                    game.play(colonne_mod, p2);
                }
            } 
            //
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
                System.out.println(RED+"\nGAME OVER"+RESET);
                
                break;
            } else {
                System.out.println("\n");
            }
        }
        scanner.close();
    }


    public static final String RESET = "\033[0m";  // Reset to default color
    public static final String RED = "\033[31m";   // Red color
    public static final String GREENp1 = "\033[32m"; // Green color
    public static final String BLUE = "\033[34m";  // Blue color
    public static final String YELLOW = "\033[33m";  // Yellow color
    public static final String MAGENTAp2 = "\033[35m";  // Magenta color


    private static final int ROWS = 6;
    private static final int COLUMNS = 7  ;

    private static final String EMPTY = "__";
    private static final String[] PLAYERS = {"_"+GREENp1+"X"+RESET, "_"+MAGENTAp2+"O"+RESET};

    



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
                System.out.print("_");
                
            }System.out.println("|");

        }
        System.out.println("  1   2   3   4   5   6   7");
    }
}
