import java.util.Scanner;


public class diagonalSum
{
   public static void main(String[] args)
   {
   
      Scanner kb = new Scanner(System.in);
      System.out.println("Enter a 4-by-4 matrix row by row: ");
      //int rc = kb.nextInt();
      
      double[][] array = new double[4][4];
            
      //allows user to input a 2D array
      for(int row = 0; row < array.length; row++)
      {
         for(int col = 0; col < array[row].length; col++)
         {
            int mElem = kb.nextInt();
            array[row][col] = mElem;
         }
       }
      
      //sum funct
      for(int col = 0; col < array[0].length; col++)
      {
         int sum = 0; //sum gets reset each column
         
         //create an If to check if row and col are equal to eachother
         for(int row = 0; row < array.length; row++)
         {
            sum += array[row][col];
            //sums up our value
         }
         System.out.println("Column " + col + ": " + sum);
      }

    
   }

}