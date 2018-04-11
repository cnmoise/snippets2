import java.util.Scanner;

public class Multiples

{
   public static void main(String[] args)
      {
         Scanner keyboard = new Scanner(System.in);
         int userNum, count;
         
          System.out.print("Enter a positive number: ");
          userNum = keyboard.nextInt();
          
          int fiveNums = 0;
          
         for(count = 2; count <= userNum; count++)
         {
            if (count % 3 == 0)
               {
                     System.out.print(count + " ");
                     fiveNums++;//Tells us how many succesful runs we've had
               if (fiveNums % 5 == 0)//could also be done by saying == 5 and reset count each time
                  {
                     System.out.println();
                  }
               
               }
               
               
         }

      }
}