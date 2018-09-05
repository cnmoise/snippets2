public class arrayDiff
{
	public static void main(String[] args)
	{
   /*int[][] a = {{2, -3, -1, 4},
                {1, 2, 3, 4}};
   int[][] b = {{5, 1, 2, 3},
                {-1, 1, 3, 2}};*/
   int[][] a = {{2, -5}, {-1}, {0, -5, 5}};
   int[][] b = {{1, -1}, {-1}, {-1, 9, 3}};
   int[][] br = new int[a.length][];
   //int i = 0;
   
   for (int r = 0; r < br.length; r++)
      {
      int cols = a[r].length; //this checks how many cols there are in a row
      br[r] = new int[cols]; //this tells the prog, hey add (col) columns at row (r)
      //Another example:
      //int[][] jaggedArray = new int[3][];//we know we have 3 rows,
      //jaggedArray[0] = new int[5]; //here we say the first row will have 5 columns
      //jaggedArray[1] = new int[4]; //the 2nd row has 4 colums
      //jaggedArray[2] = new int[2]; //ETC.
      
         for(int c = 0; c < br[r].length; c++)
            {
               br[r][c] = Math.abs(a[r][c] - b[r][c]);
            }
      
      }
      
      //i = 0;
      
      for (int r = 0; r < br.length; r++)
      {
      for(int c = 0; c < br[r].length; c++)//be sure your inner loop reffers to column.length
         {
            System.out.print(br[r][c] + " ");
         }
         System.out.println();
      }
	}
   
}