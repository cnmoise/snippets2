//Author: Claudiu Moise
import java.util.Scanner;

public class Identical

{
   public static void main(String[] args)
   {
   boolean isIdentical = true;
   
   Scanner kb = new Scanner(System.in);
   System.out.print("Enter the list length: ");
   int i = kb.nextInt();

   int[] array1 = new int[i];
   int[] array2 = new int[i];
   
      
   System.out.print("Enter list 1: ");
   for(int q = 0; q < array1.length; q++)//array.length, does NOT use () as the .lenght() method used for other 
   {
      array1[q] = kb.nextInt();//[i] reffers to the index at point i, which is incremented by the for loop
   }
   
   System.out.print("Enter list 2: ");
   
   for(int x = 0; x < array2.length; x++)//be sure to think of where the values start/end 
   {
      array2[x] = kb.nextInt();
   }
   
   for(int z = 0; z < array2.length; z++)
   {
      if(array2[z] == array1[z])//this in combo w for loop, checks each element in the index
      // to make sure its equal to its sister index
      {
         continue;//exits the if statement, without doing anything 
      }
      else
      {
         isIdentical = false;
         break;//I rhink this doesn't really do anything
      }
   }

   
   if(isIdentical)
      System.out.print("The lists are identical.");
   else
      System.out.print("The lists are not identical.");
   }
}