//Author: Claudiu Moise
import java.util.Scanner;

public class MidtermRev2
{
      public static void main(String[] args)

      {
            
      Scanner kb = new Scanner(System.in);
      
      int size;
      System.out.print("Enter a size: ");
      size = kb.nextInt();
      		
      for (int row = 1; row <= size; row++)
      {
          for (int col = 1; col <= size; col++)
          {
              if (col == 1 || col == size)
                  System.out.print("*");
              else if (row > 1 && row <= (size/2 + 1))//after * reaches mid point, the program does not print stars further down the middle columns
              {
                   if (col == row || col == (size - row + 1))
                      System.out.print("*");
                   else
                       System.out.print(" ");
              }
              else
                  System.out.print(" ");
          }
          System.out.println();
      }
   }
}