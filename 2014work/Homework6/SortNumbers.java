//Author: Claudiu Moise

import java.util.Scanner;

public class SortNumbers

{
   public static void main(String[] args)
      {
         int num1, num2, num3;
         
         Scanner keyboard = new Scanner(System.in);
         
         System.out.print("Please enter a number:");
         num1 = keyboard.nextInt();
         
         System.out.print("Please enter a number:");
         num2 = keyboard.nextInt();
         
         System.out.print("Please enter a number:");
         num3 = keyboard.nextInt();
         
         displaySortedNumbers(num1, num2, num3);//because return is void, the println cannot be here.
      }
   
   public static void displaySortedNumbers(int a, int b, int c)
      {
      if( a < b && a < c )
      {
          System.out.print(a);
          
          if( b < c )
          {
            System.out.print(" " +b);
            System.out.print(" " +c);
          }
            
          if( c < b )
          {
            System.out.print(" " +c);
            System.out.print(" " +b);
          }
      }
   
         
      if(b < a && b < c)
      {
          System.out.print(b);
          
          if( c < a )
          {
            System.out.print(" " +c);
            System.out.print(" " +a);
          }
            
          if( a < c )
          {
            System.out.print(" " +a);
            System.out.print(" " +c);
          }
      }

      
      if(c < a && c < b)
      {
          System.out.print(c);
          
          if( a < b )
          {
            System.out.print(" " +a);
            System.out.print(" " +b);
          }
            
          if( b < a )
          {
            System.out.print(" " +b);
            System.out.print(" " +a);
          }

      }

      }
      
      
}