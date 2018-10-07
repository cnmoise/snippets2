import java.util.Scanner;

public class EveryOtherChar

{
   public static void main(String[] args)
      {
         Scanner keyboard = new Scanner(System.in);
         int count;
         String word = " ";
         
          System.out.print("Enter a string: ");
          word = keyboard.nextLine();
          
          int fiveNums = 0;
          
         for(count = 0; count <= word.length() - 1; count++)//declaration is optional 
         {
            
            
            if (count % 2 == 0)
               {
                     System.out.print(word.charAt(count));//inside of charAt tells us what index to look at
                     System.out.print(" ");
                     fiveNums++;
                     
                                          
                  if (fiveNums % 5 == 0)//could also be done by saying == 5 and reset count each time
                     {
                         System.out.println();
                     }
               
               }
               
               
         }

      }
}