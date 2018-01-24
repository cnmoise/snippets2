//Author: Claudiu Moise
import java.util.Scanner;

public class SmallestN
{
      public static void main(String[] args)

      {
            
      Scanner kb = new Scanner(System.in);
      
      int cNum, nNum = 0;
      System.out.print("Enter a number larger than 10: ");
      cNum = kb.nextInt();
      
      int prod = 0;
      
      do
      {
            nNum++;
            prod= nNum * nNum;
            
      }
      while (prod < cNum);
      
      System.out.print("The smallest value for n that gives n * n >" +cNum +" is: " + nNum);

      }

}