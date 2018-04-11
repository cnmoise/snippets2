//Author: Claudiu Moise || Homework 2 || Problem 2
//Determines win conditions in TicTacToe


public class AltTicTacToe
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
   }
	
	public static char whoWon(char[][] grid)
	{
	 char won = 'N';
		
    int row = 0, col = 0;
    int countX = 0, countO = 0;

    while (row < 3 && countX < 3 && countO < 3)//is the board complete?
    {//checks each row to see if we have a wincombo
        countX = 0;
        countO = 0;
        for (col = 0; col < 3; col++)
        {
            if (grid[row][col] == 'X')
                countX++;
            else
                countO++;
        }
        row++;
        if (countX == 3)
            won = 'X';
        if (countO == 3)
            won = 'O';
    }
    
    row = 0;//resets counters
    col = 0;
    
    while (col < 3 && countX < 3 && countO < 3)
    {//checks each col to see if we have a wincombo
        countX = 0;
        countO = 0;
        for (row = 0; row < 3; row++)
        {
            if (grid[row][col] == 'X')
                countX++;
            else
                countO++;
        }
        col++;
        if (countX == 3)
            won = 'X';
        if (countO == 3)
            won = 'O';
    }
            
    row = 0;
    countX = 0;
    countO = 0;
    for (row = 0; row < 3; row++)
    {//checks L to R diagonal
        if (grid[row][row] == 'X')
            countX++;
        else
            countO++;
    }
    if (countX == 3)
        won = 'X';
    if (countO == 3)
        won = 'O';
    
    row = 0;
    countX = 0;
    countO = 0;
    for (row = 0; row < 3; row++)
    {//checks R to L diagonal

        if (grid[row][2 - row] == 'X')
            countX++;
        else
            countO++;
    		
    if (countX == 3)
        won = 'X';
    if (countO == 3)
        won = 'O';
    }
      
    return won;
   }
 }