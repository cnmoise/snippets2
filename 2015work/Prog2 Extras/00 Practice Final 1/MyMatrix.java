import java.util.Scanner;

public class MyMatrix extends Matrix
{
   public MyMatrix(int[][] n)
   {
      super(n);
   }
   
   public void printRowLengths()
   {     
      int[][] it = super.getNumbers();//necessary for cleaner code
      for(int i = 0; i < it.length; i++)
      {
         System.out.println("Row " + i + ": " + it[i].length);
      }
      
   }
   public void printRowForUser()
   {
      int[][] it = super.getNumbers();//necessary for cleaner code
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Enter row index: ");//REM: match output exactly, inform user they must enter stuff

      int i = kb.nextInt();
      for(int j = 0; j < it[i].length; j++)
      {
         System.out.print(it[i][j] + ", ");
      }   
   }
   
   public int largestNumber()
   {
      int[][] it = super.getNumbers();
      int max = it[0][0];
      
      for(int r = 0; r < it.length; r++)
      {
         for(int c = 0; c < it[r].length; c++)
         {
            max = Math.max(max, it[r][c]);  
         } 
      }
      return max;
   }
}