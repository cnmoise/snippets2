//Author: Claudiu Moise
import java.util.Scanner;

public class ReverseWords
{
      public static void main(String[] args)

      {
            
      Scanner kb = new Scanner(System.in);
      
      String userStr = "", word = "", reverse = "";
      char letter = ' ';
      int curPos = 0;
      
      System.out.print("Enter a sentence: ");
      userStr = kb.nextLine();

         do 
         {

            letter = userStr.charAt(curPos);
            word += letter;
            
            curPos++;
                   
            if (letter == ' ' || curPos == userStr.length())
            {
               for ( int i = word.length() - 1; i >= 0; i-- )
               {
                   if (word.charAt(i) != ' ')
                   {
                   reverse = reverse + word.charAt(i);
                   }
                  
               }

            System.out.println(reverse);
            word = "";
            reverse = "";
            }

         }
         while (curPos <= userStr.length()-1);
       
         }

      
}

