//Authors: Claudiu Moise, Faraz Shaik, Joana Velazquez
import java.util.Scanner;

public class RockPaperScissors
{
   public static void main(String[] args)
   {
      int randNum = (int) (3 * Math.random());
      int userNum;
      Scanner keyboard = new Scanner(System.in);
      

      
      System.out.print("Choose scissors (0), rock (1), or paper (2): ");
      userNum = keyboard.nextInt();
      
      if (randNum == 0)
            {
            System.out.println("The computer is scissors.");
            }
      else if (randNum == 1)
            {
            System.out.println("The computer is rock.");
            }
      else
            System.out.println("The computer is paper.");

      if (userNum == 0)
            {
            System.out.println("You are scissors.");
            }
      else if (userNum == 1)
            {
            System.out.println("You are rock.");
            }
      else
            System.out.println("You are paper.");
            
      if (userNum == randNum)
         {
         System.out.println("It's a draw.");
         }
      else if(userNum == 0 && randNum == 1)
         {
         System.out.println("You Lost.");
         }
       else if(userNum == 1 && randNum == 2)
         {
         System.out.println("You Lost.");
         }
       else if(userNum == 2 && randNum == 0)
         {
         System.out.println("You Lost.");
         }       
       else if(userNum == 0 && randNum == 2)
         {
         System.out.println("You Win.");
         }
         else 
         {
         System.out.println("You Win.");
         }

         
         }
}