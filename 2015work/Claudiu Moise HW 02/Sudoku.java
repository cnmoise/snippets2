//Author: Claudiu Moise || Homework 2 || Problem 2
//Determines win conditions in Sudoku (no same number is present on the same row/col)

public class Sudoku
{
	public static void main(String[] args)
	{
      int[][] b1 = { { 4, 3, 1, 6, 7, 9, 5, 2, 8 },
					   { 9, 6, 7, 2, 5, 8, 3, 4, 1 },
					   { 5, 8, 2, 1, 4, 3, 9, 6, 7 },
					   { 6, 5, 9, 8, 1, 7, 2, 3, 4 },
					   { 3, 2, 8, 5, 6, 4, 1, 7, 9 },
					   { 7, 1, 4, 9, 3, 2, 8, 5, 6 },
					   { 8, 7, 3, 4, 2, 1, 6, 9, 5 },
					   { 1, 4, 5, 3, 9, 6, 7, 8, 2 },
					   { 2, 9, 6, 7, 8, 5, 4, 1, 3 } };
		// Should print out: Sudoku solution valid? true
		System.out.println("Sudoku solution valid? " + isValid(b1));
		
      int[][] b2 = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
					   { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
		// Should print out: Sudoku solution valid? false
		System.out.println("Sudoku solution valid? " + isValid(b2));
				
		int[][] b3 = { { 1, 2, 3, 5, 6, 7, 8, 9, 4 },
					   { 4, 5, 6, 1, 8, 9, 2, 3, 7 },
					   { 7, 8, 9, 2, 3, 4, 1, 5, 6 },
					   { 2, 1, 4, 3, 5, 6, 7, 8, 9 },
					   { 3, 6, 5, 7, 9, 8, 4, 1, 2 },
					   { 8, 9, 7, 4, 1, 2, 3, 6, 5 },
					   { 5, 3, 2, 6, 4, 1, 9, 7, 8 },
					   { 6, 4, 8, 9, 7, 3, 8, 2, 1 },
					   { 9, 7, 1, 8, 2, 5, 6, 4, 3 } };
		// Should print out: Sudoku solution valid? false
		System.out.println("Sudoku solution valid? " + isValid(b3));
	}
	
	public static boolean isValid(int[][] board)
	{
	   boolean isUnique = true;
      int tst;

      
      for (int i = 0; i < board.length; i++)//executes opp until no more rows left
      {
         for (int j = 0; j < board[i].length; j++)
         {
            tst = board[i][j];//keeps tabs on the current int being tested
            
            for (int k = j+1; k < board[i].length; k++)//tests each int in the row, starting from the next one in the series
            {
               if (tst == board[i][k])//if it finds an int that matches it breaks the loop, setting isUnique to false
                  {
                  isUnique = false;
                  return isUnique;//will return false to the console and quit out
                  }
               }//end for k
         }//for j 
      }//for i
      //checks tst for similar values in the ROWs
      
      for (int i = 0; i < board[0].length; i++)//executes opp until no more cols left
      {
         for (int j = 0; j < board.length; j++)
         {
            tst = board[j][i];//keeps tabs on the current int being tested
            
            for (int k = j+1; k < board.length; k++)//tests each int in the row, HAS TO DO ALL OF IT OVER AGAIN
               {
               if (tst == board[k][i])//if it finds an int that matches it breaks the loop, setting isUnique to false
                  {
                  isUnique = false;
                  return isUnique;//will return false to the console and quit out
                  }
               }//end for k
         }//for j
       }//for i
      //checks tst for similar values in the cols

      
      
      return isUnique;
	
   }
   
}