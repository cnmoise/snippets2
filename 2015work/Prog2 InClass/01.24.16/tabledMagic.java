import java.util.Scanner;


public class tabledMagic
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
         }
      }
      
      System.out.println("Your 2D array:");
      
      for(int row = 0; row < array.length; row++)
      {
         
         for(int col = 0; col < array[row].length; col++)
         {
            System.out.print(array[row][col] + " ");
         }
         System.out.println();
      }
   }

}