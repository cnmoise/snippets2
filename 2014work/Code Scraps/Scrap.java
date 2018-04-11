import java.util.Scanner;

public class Scrap

{
   public static void main(String[] args)
      {
         Scanner keyboard = new Scanner(System.in);
         
         
          System.out.print("Enter a string: ");
          String uStr = keyboard.nextLine();
          int lStr = uStr.length()-1;
          System.out.print("Enter a position between 0 and"+ lStr );
          int index = keyboard.nextInt();
          
          for (int c = 0; c <= uStr.length() - 1; c++)
          {
          if ( uStr.charAt(c) != index)
            System.out.print(uStr.charAt(c));
          else
            System.out.print(uStr.charAt(c));
          }


      }
}