/*
Author: Claudiu Moise
This is a program that converts pounds to kilograms
*/
import java.util.Scanner;

public class PoundsToKilograms
{
   public static void main(String[] args)
   {
   double poundAmount, kiloAmount;
   Scanner keyboard = new Scanner(System.in);
   
   System.out.print("Enter a number in pounds: ");
   poundAmount = keyboard.nextDouble();
   kiloAmount = .454 * poundAmount;
   System.out.println("In kilograms, that is: " + kiloAmount + ".");
      }
}