//Author: Claudiu Moise
//User enters in numbers, program determines if the numbers make a
//Square or a rectangle, Program then increases width by 1 and runs
//determination again.

import java.util.Scanner;

public class ChangeCalc
{
   public static void main(String[] args)
   {
      
   Scanner keyboard = new Scanner(System.in);//Scanner has two n's
   int pennies, nickles, dimes, quarters;
   
   
   System.out.print("Enter the number in pennies: ");
   pennies = keyboard.nextInt();
   
   int remainingAmmount;
   
   quarters = pennies/25;
   
   remainingAmmount = pennies%25;
   dimes = remainingAmmount/10;
   
   remainingAmmount %= 10;
   
   nickles = remainingAmmount/5;
   remainingAmmount %= 5;
   
   System.out.print("Totals" + quarters + " quarters " + dimes + " dimes " + nickles + " nickles " + remainingAmmount + " pennies");
   
   }
}