//Exam Question
//Feb. 23, 2016
//takes a 2d array of random numbers
//organize all the numbers such that all evens are in the back,

public class evensFirst
{
	public static void main(String[] args)
	{
      int[][] a = new int[4][4]; //In example its actually passed into a method called evensFirst
      //a would be filled with a non-ragged array
      int[][] b = new int[a.length][a[0].length];      
      //were making a new array b to store all our things
      
      for(int r = 0; r < b.length; r++)
         {
            int j = 0;
            for(int c = 0; c < b[r].length; c++)
            {
               if(a[r][c] % 2 == 0)//checks if the number is even
               {
                  b[r][j] = a[r][c];
                  j++;//increments only if a val is even
                  //tells us where were putting this value into the b array
               }
               //only exits once all of the odd numbers have been found
            }
            
            for(int c = j; c < b[r].length; c++)//were putting the rest of the odd values into our new array
            {
            if(a[r][c] % 2 != 0)//checks if the number is odd, note were still looking in the original array
               {
                  b[r][j] = a[r][c];
                  j++;//the only thing that distinguishes the processes is our starting points
               }
            }
            //only exits once all the EVENS have been found
         }

     
	}
}