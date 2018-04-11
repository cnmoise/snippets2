//Author: Claudiu Moise || Homework 2 || Problem 2
//Determines win conditions in TicTacToe


public class TicTacToe
{
	public static void main(String[] args)
	{
		char[][] g1 = { { 'X', 'X', 'O' },
					    { 'X', 'O', 'O' },
					    { 'X', 'O', 'X' } };
		// Should print out: Player X won.
	 System.out.println("Player " + whoWon(g1) + " won.");
		
		char[][] g2 = { { 'X', 'X', 'O' },
					    { 'O', 'O', 'O' },
					    { 'X', 'O', 'X' } };
		// Should print out: Player O won.
		System.out.println("Player " + whoWon(g2) + " won.");
		
		char[][] g3 = { { 'X', 'X', 'O' },
					    { 'O', 'X', 'O' },
					    { 'X', 'O', 'X' } };
		// Should print out: Player X won.
		System.out.println("Player " + whoWon(g3) + " won.");
		
		char[][] g4 = { { 'X', 'X', 'O' },
					    { 'O', 'O', 'X' },
					    { 'X', 'O', 'X' } };
		// Should print out: Player N won.
		System.out.println("Player " + whoWon(g4) + " won.");
	}
	
	public static char whoWon(char[][] grid)
	{
		
      if(grid[0][0] == grid[0][1] && grid[0][0] == grid[0][2])
        return grid[0][0];
      
      else if(grid[1][0] == grid[1][1] && grid[1][0] == grid[1][2])
        return grid[1][0];
      
      else if(grid[2][0] == grid[2][1] && grid[2][0] == grid[2][2])
        return grid[2][0];
      //check columns
      else if(grid[0][0] == grid[1][0] && grid[0][0] == grid[2][0])
        return grid[0][0];
        
      else if(grid[0][1] == grid[1][1] && grid[0][1] == grid[2][1])
        return grid[0][1];	
        
      else if(grid[0][2] == grid[1][2] && grid[0][2] == grid[2][2])
        return grid[0][0];
      //check diagonals
      else if(grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2])
        return grid[0][0];
        
      else if(grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0])
        return grid[0][2];
      else return 'N';
	}
}