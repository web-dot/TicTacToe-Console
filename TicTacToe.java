import java.util.Scanner;

/**
   Simple TicTacToe:
   Steps: 
      1.Start the game and initialize the board with empty cells.
      2.Print the initial empty board.
      3.Set the current player as 'X'.
      4.While the game is not over:
         a. Prompt the current player to enter the row and column number to place their mark.
         b. Check if the input row and column number are within the valid range (0 to 2).
         c. If the cell at the input row and column is empty, place the current player's mark on the board.
         d. If the current player wins, end the game and print the winner.
         e. If the board is full and there is no winner, end the game and print a tie message.
         f. Switch the current player to the other player (if 'X', switch to 'O' and vice versa).
         Print the final board and the end of the game message.
*/



public class TicTacToe{
   private char[][] board = new char[3][3];
   private char currentPlayer;
   
   public TicTacToe(){
      currentPlayer = 'X';
      initializeBoard();
   }
   
   public void initializeBoard(){
      for(int row=0; row<3; row++){

         for(int col=0; col<3; col++){
            board[row][col] = '-';
         }
      }
   }
   
   public void printBoard(){
      System.out.println("--------------");
      for(int row=0; row<3; row++){
         System.out.print("| ");
         for(int col=0; col<3; col++){
            System.out.print(board[row][col] + " | ");
         }
         System.out.println();
         System.out.println("--------------");
      }
   }
   
   public boolean isBoardFull(){
      for(int row=0; row<3; row++){
         for(int col=0; col<3; col++){
            if(board[row][col]=='-'){
               return false;
            }
         }
      }
      return true;
   }
   
   public boolean placeMark(int row, int col){
      if(row >= 0 && row < 3 && col >= 0 && col < 3){
         if(board[row][col] == '-'){
            board[row][col] = currentPlayer;
            return true;
         }
      }
      return false;
   }
   
   public boolean checkForWin(){
      //Check for horizontal wins
      
   }
   
   public static void main(String[] args){
      TicTacToe game = new TicTacToe();
      Scanner scanner = new Scanner(System.in);
      boolean gameEnded = false;
      while(!gameEnded){
         game.printBoard();
         System.out.println("Its " + game.currentPlayer + "'s turn. Enter row and column (0-2):");
         int row = scanner.nextInt();
         int col = scanner.nextInt();
         
         if(game.placeMark(row, col)){
            if(game.checkForWin()){
               System.out.println("Game Over! " + game.currentPlayer + ");
               gameEnded = true;
            }
            else if(game.isBoardFull()){
               System.out.println("Game Over! It's a tie!");
               gameEnded = true;      
            }
            else{
               game.changePlayer();
            } 
         }
         else{
            System.out.println("Invalid move! Please try again");
         }  
      }
      game.printBoard();
   }
}