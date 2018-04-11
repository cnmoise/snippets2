import java.util.Scanner;

public class TheU
{
   public static void main(String[] args)
      {
         Scanner keyboard = new Scanner(System.in);
         int height, width, count;
         
          System.out.print("Enter a width greater than 2: ");
          width = keyboard.nextInt();
   
   
          System.out.print("Enter a height greater than 2: ");
          height = keyboard.nextInt();
          
         for(int row = 1; row <= height; row++)//height is really number of rows
         {
                for (int col = 1; col <= width; col++)
                {
                     if ( col == 1 || col == width || row == height)
                     {
                     System.out.print("X ");
                     }
                     
                     else
                     {
                        System.out.print("  ");
                     }
                }
                
                System.out.println();
         }
               
          }
               
               
         }

  
