//Author: Claudiu Moise
import java.util.Scanner;

public class ReverseSentence
{
      public static void main(String[] args)

      {
            
      Scanner kb = new Scanner(System.in);
      
      String userStr = "", revStr = "";
      char letter;
      
      System.out.print("Enter a sentence: ");
      userStr = kb.nextLine();

      for ( int curPos = userStr.length() - 1 ; curPos >= 0 ; curPos-- )//careful about <,>
         {
         letter = userStr.charAt(curPos);
            if (letter == 'a')
               {
               revStr += '@';
               }
            else if (letter == 'e')
               {
               revStr += '$';
               }
            else if (letter == 'o')
               {
               revStr += '0';
               }
            else if (letter == ' ' )
               {
               revStr += '-';
               }
            else
               {
               revStr += letter;
               }

         }

       /*revStr = revStr.replaceAll("a", "@");
      revStr = revStr.replaceAll("e", "$");
      revStr = revStr.replaceAll("o", "0");
      revStr = revStr.replaceAll(" ", "-");*/
      //wanted to use this, too many errors to bother with
      System.out.println(revStr);
      
      }

}