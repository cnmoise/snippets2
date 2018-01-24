//Author: Claudiu Moise
//Tried to use breakpoints because the loop was doing strange things
//Could use some help dealing with the unintuitive breakpoints
import java.util.Scanner;

public class DivisibleLines
{
      public static void main(String[] args)

      {
            
      Scanner kb = new Scanner(System.in);
      
      int divNum, nNum = 0;
      System.out.print("Enter a number larger than 20: ");
      divNum = kb.nextInt();
      
      int count = 0, divCount = 0;
      
      do
      {
         divCount++;//keeps track of all loops performed, this is our exit

            
            
            if ((divCount % 2 == 0) && (divCount % 3 != 0))
               {
                  System.out.print(divCount + " ");
                  count++;
               }
            else if((divCount % 2 != 0) && (divCount % 3 == 0))
               {
                  System.out.print(divCount + " ");
                  count++;
               }

            if(count % 10 == 0)
                {
                    System.out.println("");
                }
      }
      while(divCount != divNum);//this is our exit statement
      }

}