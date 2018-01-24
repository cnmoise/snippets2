//Author: Claudiu Moise
import java.util.Scanner;

public class FizzBuzz
{
      public static void main(String[] args)
      { 
           
         String printArr[] = new String[5];
         
         printArr = fizzBuzz(10, 16);
         
         for(int i = 0; i < printArr.length; i++)
         {
            System.out.print(printArr[i] + " ");
         }
      
      }
      
      public static String[] fizzBuzz(int start, int end)
      {
         String strArr[] = new String[end-start];
         int j = 0;
         
         for(int i = start; i < end; i++)
            {
               if(i % 3 == 0 && i % 5 != 0)
                  strArr[j] = "Fizz";
               else if(i % 5 == 0 && i % 3 != 0)
                  strArr[j] = "Buzz";
               else if(i % 5 == 0 && i % 3 == 0)
                  strArr[j] = "FizzBuzz";
               else
                  strArr[j] = String.valueOf(i);
               
               j++;
            }
         
         return strArr;
      }
}

