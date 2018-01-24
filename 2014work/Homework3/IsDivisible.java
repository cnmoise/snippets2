//Author: Claudiu Moise
//This program takes a dividend and divisor entered by the user
//and then checks to see if the dividend is divisible by the divisor

//I will start commenting my own work for study purposes
//I hope that does not inconvenience you

import java.util.Scanner;

public class IsDivisible
{
   public static void main(String[] args)
   {
   int dividend;
   int divisor;
   
   Scanner keyboard = new Scanner(System.in);
   //Don't forget to declare your keyboard!!! 
   
   System.out.print("Please enter the dividend: ");
   dividend = keyboard.nextInt();//Parentheses needed
   
   System.out.print("please enter the divisor: ");
   divisor = keyboard.nextInt();
   
   if (dividend % divisor == 0)//boolean operator
      {
      System.out.println(dividend + " is devisible by " + divisor);
      }
   else
      {
      System.out.println(dividend + " is not devisible by " + divisor);      
      }
   }
}
