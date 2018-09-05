import java.util.Scanner;


public class sumUpColumns
{
   public static void main(String[] args)
   {
   
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter the number of rows: ");
      int r = kb.nextInt();
      System.out.print("Enter the number of columns: ");
      int c = kb.nextInt();
      
      int[][] array = new int[r][c];//beautiful
      
      for(int row = 0; row < array.length; row++)
      {
         System.out.print("Enter row " + row + ": ");
         for(int col = 0; col < array[row].length; col++)
         {
            int n = kb.nextInt();
            array[row][col] = n;
            //creates a 2D array
         }
      }
      
      System.out.println();
      
      
      for(int col = 0; col < array[0].length; col++)
      {
         int sum = 0; //sum gets reset each column
         
         for(int row = 0; row < array.length; row++)
         {
            sum += array[row][col];
            //sums up our value
         }
         System.out.println("Column " + col + ": " + sum);
      }
      
    
   }

}