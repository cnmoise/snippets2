//Exam extra Question
//Feb. 23, 2016
//Makes a 2d array from a single integer

public class makeRagged
{
	public static void main(String[] args)
	{
      int n = 5;
      int[][] rArr = new int[n][];//REM: How to declare a RAGGED ARRAY
      
      
      for(int r = 0; r < n; r++)
         {
            rArr[r] = new int[n-r];//REM: adds our columns to the individual row
            for(int c = 0; c < rArr[r].length; c++)
            {
               rArr[r][c] = n-r-c;//5-0-3 assigns the value 2 to [0][3]
            }
         }
	}
}