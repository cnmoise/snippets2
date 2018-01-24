//Author: Claudiu Moise
import java.util.Scanner;

public class AverageTemperature
{
      public static void main(String[] args)

      {
            
      Scanner kb = new Scanner(System.in);
      
      int uNum;
      double avg = 0;
      int div = 0;
      double tNum = 0;
      boolean isExec = false;

      do
      {
         System.out.print("Please enter a temperature in fahrenheit or 999 to quit: ");
         uNum = kb.nextInt();
         
         if (uNum != 999)
         {
            div++;
            tNum = tNum + uNum;
            isExec = true;
            //Why is it that when I had avg = tNum/div here I was getting bad answers? 
         }         
      }
      while (uNum != 999);
      

      if (isExec)
         {
          avg = tNum/div;
          System.out.println("The average temperature is " + avg);
         }
      else
         System.out.println("No average calculated.");
           

      }

}