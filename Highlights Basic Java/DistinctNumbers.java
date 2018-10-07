//Author: Claudiu Moise
import java.util.Scanner;

public class DistinctNumbers

{
   public static void main(String[] args)
   {
   Scanner kb = new Scanner(System.in);

   int[] array = new int[10];
   int numDistinct = 0;

   System.out.print("Enter ten numbers: ");
   for(int x = 0; x < array.length; x++)//be sure to think of where the values start/end 
   {
     array[x] = kb.nextInt();
   }
   
   System.out.print("The number of unique numbers is:");
   for(int i = 0; i < array.length; i++)//i will stay the same until we've gone through all the #'s in the list
   {
      boolean isNotDistinct = false;
      for(int j = 0; j < i ; j++)//j goes through the rest of the numbers in the array
      {
          if(array[i] == array[j])//if i matches another number in the array
          {
              isNotDistinct = true;
              break;
          }
      }
      if(!isNotDistinct)
      {
          numDistinct++; 
      }

   }
   System.out.print(numDistinct);//this line prints the total # of distinct numbers
   System.out.println(""); 
   System.out.print("The distinct numbers are: ");   
      for(int i = 0; i < array.length; i++)//i will stay the same until we've gone through all the #'s in the list
   {
      boolean isNotDistinct = false;
      for(int j = 0; j < i ; j++)//j goes through the rest of the numbers in the array
      {
          if(array[i] == array[j])
          {
              isNotDistinct = true;
              break;
          }
      }
      if(!isNotDistinct)
      {
          System.out.print(array[i]+" ");
      }   

   }
   
   
   }
}