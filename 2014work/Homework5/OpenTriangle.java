//Author: Claudiu Moise
import java.util.Scanner;

public class OpenTriangle
{
   public static void main(String[] args)
      {
         Scanner keyboard = new Scanner(System.in);
         int height, width = 0;
         int numSpaces = 0;
         
          System.out.print("Enter a triangle height greater than 1: ");
          height = keyboard.nextInt();
          
          for (int row = 1; row <= height; row++)
             {
                for (int col = 1; col <= row; col++) 
                {
                    if(col == 1 || row == height)
                    {
                    System.out.print("* ");
                    }
                    else
                    System.out.print("  ");
                    
                    if (col == row-1 && row != height)
                    {                    
                    System.out.print("* ");
                    }                    
                    
                }
                
                System.out.println();
             }

      }
            
 }           


  
