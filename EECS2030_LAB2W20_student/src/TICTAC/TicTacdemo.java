package TICTAC;

import java.util.Scanner;

public class TicTacdemo {

   public static void main(String[] args) throws ArrayIndexOutOfBoundsException, UnavailableCellException
   {
      Scanner in = new Scanner(System.in);
      
      int player = 2;

      PlayTicTac ticTacToe = new PlayTicTac();

      ticTacToe.drawBoard();
      while (!ticTacToe.win( player))
      {
    	 try {
    		 
         if (player == 1)
         {
            player = 2;
         }
         else
         {
            player = 1;
         }
         
        	 
         if (player ==1)
           	System.out.print("Player " + player + " (X) choose a row and column: ");
         else System.out.print("Player " + player + " (O) choose a row and column: ");
         int row = in.nextInt();
         int column = in.nextInt();
         
         ticTacToe.choose(row, column, player);
         ticTacToe.drawBoard();
    	 }
    	 catch(UnavailableCellException | ArrayIndexOutOfBoundsException e)
    	 {
    		 if(player == 2)
    		 {
    			 player = 1;
    		 }
    		 else player = 2;
    	 }
      }
      System.out.println("Player " + player + " wins!");
   }

}



