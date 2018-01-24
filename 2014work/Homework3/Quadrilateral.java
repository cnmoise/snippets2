//Author: Claudiu Moise
//User enters in numbers, program determines if the numbers make a
//Square or a rectangle, Program then increases width by 1 and runs
//determination again.

import java.util.Scanner;

public class Quadrilateral
{
   public static void main(String[] args)
   {
      
   Scanner keyboard = new Scanner(System.in);//Scanner has two n's
   double width;
   double lenght;
   
   System.out.print("Enter the lenght: ");
   lenght = keyboard.nextDouble();
   
   System.out.print("Enter the width: ");
   width = keyboard.nextDouble();

   if (lenght == width)
      {
      System.out.println("It's a square!");
      }
   else
      {
      System.out.println("It's a rectangle!");
      }
   
   width++;//Don't forget semicolon
   System.out.println("The width is now " + width);//Concatenation
   
   if (lenght == width)
      {
      System.out.println("It's a square!");
      }
   else
      {
      System.out.println("It's a rectangle!");
      }
   
   
   }
}