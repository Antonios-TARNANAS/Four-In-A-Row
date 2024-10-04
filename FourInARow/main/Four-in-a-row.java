import java.util.Scanner;

/**
 * The FourInARow class represents the game "Four in a Row" (also known as Connect Four).
 * It is a two-player connection game where players take turns dropping colored tokens into a 
 * vertically suspended grid with 6 rows and 7 columns.
 *
 * The game is won when a player successfully aligns four of their tokens consecutively in a row,
 * either horizontally, vertically, or diagonally.
 *
 * Game Details:
 * - The board is represented by a 6x7 grid.
 * - Players choose a color and take turns dropping tokens into the columns of the grid.
 * - When a token is dropped into a column, it occupies the lowest available row within that column.
 *
 * Objective:
 * - The goal of the game is to be the first player to form a sequence of four consecutive tokens
 *   in a horizontal, vertical, or diagonal direction.
 */

public class FourInARow {    
    public static void main(String[] args) {
        FourInARow game = new FourInARow();

        Scanner scanner = new Scanner(System.in);

        String p1 = PLAYERS[0];
        String p2 = PLAYERS[1];
        game.printBoard(); // initial print

        int playagain = 1;

        while (playagain==1 || (!game.hasWon(p1) && !game.hasWon(p2))) { // P1 plays



                                
            System.out.print("\n"+GREENp1+"P1"+RESET+" choisis une colonne -> colonne 1->7: ");
            int colonne_P1 = scanner.nextInt()-1;
            // recopier lignes try catch p2 dans p1
            boolean ilachoisiunebonnecolonneP1 = false;
            while (!ilachoisiunebonnecolonneP1) {
                try {
                    game.play(colonne_P1, p1);
                    ilachoisiunebonnecolonneP1 = true;
                } catch (Exception e) {
                    ilachoisiunebonnecolonneP1 = false;
                    System.out.print("\n"+GREENp1+"P1"+RESET+" choisis une  autre colonne car erreur avec celle-ci -"+RED+(colonne_P1+1)+RESET+"-  : ");
                    int colonne_mod = scanner.nextInt()-1;
                    //System.out.println(colonne_mod);
                    while (colonne_mod == colonne_P1 && !ilachoisiunebonnecolonneP1) {
                        if (colonne_mod==colonne_P1){
                            System.out.println(GREENp1+"P1"+RESET+" Veuillez choisir une autre colonne que "+RED+(colonne_P1+1)+RESET+" s'il vous plait:");
                            colonne_mod = scanner.nextInt()-1;
                        } else if (!ilachoisiunebonnecolonneP1){
                            System.out.println(GREENp1+"P1"+RESET+" Veuillez choisir une autre colonne que "+RED+(colonne_P1+1)+RESET+" s'il vous plait! Cette colonne n'est pas valide. Choix: ");
                            colonne_mod = scanner.nextInt()-1;
                        } else {
                            System.out.println(RED+"Message d'erreur : "+RESET);
                            colonne_mod = scanner.nextInt()-1;
                        }
                        

                    }
                    ilachoisiunebonnecolonneP1 = true;
                    game.play(colonne_mod, p1); // Ceci doit être entouré par un try{}__catch(){}
                }
            }
            //
            System.out.println("\n");
            game.printBoard();
            String playAgainQuote = "press [1] to play again; [0] or other to quit.";

            ///
            if (game.hasWon(p1)) {
                 
                game.printBoard();
                System.out.println("\n"+GREENp1+"P1"+RESET+ " HAS WON! ");
                System.out.println(BLUE+"\nPLAY AGAIN ?"+RESET);
                
                System.out.println(playAgainQuote);
                try{
                    playagain = scanner.nextInt();
                }catch(Exception e){
                    playagain=0;
                    game.printBoard();
                    System.out.println("\n"+GREENp1+"P1"+RESET+ " HAS WON! ");
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }
 
                
                if (playagain==1){
                    //System.out.println("!!!!!!!!!!!!!!!!!!p1 won"); for debugging
                    game = new FourInARow();
                    game.printBoard();
                }else{
                    
                    playagain=0;
                    game.printBoard();
                    System.out.println("\n"+GREENp1+"P1"+RESET+ " HAS WON! ");
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }
            } else if (game.hasWon(p2)){
                
                game.printBoard();
                System.out.println("\n"+MAGENTAp2+"P2"+RESET+ " HAS WON! ");
                System.out.println(BLUE+"\nPLAY AGAIN ?"+RESET);


                System.out.println(playAgainQuote);
                try{
                    playagain = scanner.nextInt();
                }catch(Exception e){
                    playagain=0;
                    game.printBoard();
                    System.out.println("\n"+MAGENTAp2+"P2"+RESET+ " HAS WON! ");
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }

                
                if (playagain==1){
                    //System.out.println("!!!!!!!!!!!!!!!!!!p2 won"); for debugging
                    game = new FourInARow();
                    game.printBoard();

                } else {
                    
                    playagain=0;
                    game.printBoard();
                    System.out.println("\n"+MAGENTAp2+"P2"+RESET+ " HAS WON! ");
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }
                
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
                } catch (Exception e) {
                    ilachoisiunebonnecolonneP2 = false;
                    System.out.print("\n"+MAGENTAp2+"P2"+RESET+" choisis une  autre colonne car erreur avec celle-ci -"+RED+(colonne_P2+1)+RESET+"-  : ");
                    int colonne_mod = scanner.nextInt()-1;
                    //System.out.println(colonne_mod);
                    while (colonne_mod == colonne_P2 && !ilachoisiunebonnecolonneP2) {
                        if (colonne_mod==colonne_P2){
                            System.out.println(MAGENTAp2+"P2"+RESET+" Veuillez choisir une autre colonne que "+RED+(colonne_P2+1)+RESET+" s'il vous plait:");
                            colonne_mod = scanner.nextInt()-1;
                        } else if (!ilachoisiunebonnecolonneP2){
                            System.out.println(MAGENTAp2+"P2"+RESET+" Veuillez choisir une autre colonne que "+RED+(colonne_P2+1)+RESET+" s'il vous plait! Cette colonne n'est pas valide. Choix: ");
                            colonne_mod = scanner.nextInt()-1;
                        } else {
                            System.out.println(RED+"Message d'erreur : "+RESET);
                            colonne_mod = scanner.nextInt()-1;
                        }
                        

                    }
                    ilachoisiunebonnecolonneP2 = true;
                    game.play(colonne_mod, p2); // Ceci doit être entouré par un try{}__catch(){}
                }
            } 
            //
            System.out.println("\n");
            game.printBoard();
            //String playAgainQuote = "press [1] to play again; [0] or other to quit.";

            ///

            if (game.hasWon(p1)) {
                
                game.printBoard();
                System.out.println("\n"+GREENp1+"P1"+RESET+ " HAS WON! "); 
                System.out.println(BLUE+"\nPLAY AGAIN ?"+RESET);
                
                System.out.println(playAgainQuote);
                try{
                    playagain = scanner.nextInt();
                }catch(Exception e){
                    playagain=0;
                    game.printBoard();
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }
 
                
                if (playagain==1){
                    //System.out.println("!!!!!!!!!!!!!!!!!!p1 won"); for debugging
                    game = new FourInARow();
                    game.printBoard();
                }else{
                    
                    playagain=0;
                    game.printBoard();
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }
            } else if (game.hasWon(p2)){
                
                game.printBoard();
                System.out.println("\n"+MAGENTAp2+"P2"+RESET+ " HAS WON! ");
                System.out.println(BLUE+"\nPLAY AGAIN ?"+RESET);

                System.out.println(playAgainQuote);
                try{
                    playagain = scanner.nextInt();
                }catch(Exception e){
                    playagain=0;
                    game.printBoard();
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }
                
                if (playagain==1){
                    //System.out.println("!!!!!!!!!!!!!!!!!!p2 won"); for debugging
                    game = new FourInARow();
                    game.printBoard();

                } else {
                    
                    playagain=0;
                    game.printBoard();
                    System.out.println(RED+"\n-GAME OVER-"+RESET);
                    break;
                }
                
            } else {
                System.out.println("\n");
            }
        } 
        // (!won by p1 or !won by p2) __ want to play again ==> true ==> boucle continue
        //  (false      || true     ) __ true
     
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
        if (j>COLUMNS || j<0){
            throw new IllegalArgumentException(RED+"colonne indiquée > COLUMNS ou colonne indiquée < 0"+RESET);
        }
        
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


                                //System.out.print("|--  "+board[i][j]+"  --|");
                                //System.out.print("|--  "+board[i+1][j]+"  --|");
                                //System.out.print("|--  "+board[i+2][j]+"  --|");
                                //System.out.print("|--  "+board[i+3][j]+"  --|");

                                board[i][j]=YELLOW+board[i][j]+RESET;
                                board[i+1][j]=YELLOW+board[i+1][j]+RESET;
                                board[i+2][j]=YELLOW+board[i+2][j]+RESET;
                                board[i+3][j]=YELLOW+board[i+3][j]+RESET;




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


                                board[i][j]=YELLOW+board[i][j]+RESET;
                                board[i][j+1]=YELLOW+board[i][j+1]+RESET;
                                board[i][j+2]=YELLOW+board[i][j+2]+RESET;
                                board[i][j+3]=YELLOW+board[i][j+3]+RESET;


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


                                board[i][j]=YELLOW+board[i][j]+RESET;
                                board[i+1][j+1]=YELLOW+board[i+1][j+1]+RESET;
                                board[i+2][j+2]=YELLOW+board[i+2][j+2]+RESET;
                                board[i+3][j+3]=YELLOW+board[i+3][j+3]+RESET;


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


                                board[i][j]=YELLOW+board[i][j]+RESET;
                                board[i-1][j+1]=YELLOW+board[i-1][j+1]+RESET;
                                board[i-2][j+2]=YELLOW+board[i-2][j+2]+RESET;
                                board[i-3][j+3]=YELLOW+board[i-3][j+3]+RESET;

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
