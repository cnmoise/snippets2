//Author: Claudiu Moise
import java.util.Scanner;

public class Reverse

{
   public static void main(String[] args)
   {
   Scanner kb = new Scanner(System.in);
   
   int[] array = new int[10];//brackets signal we are declaring an array
   //number in brackets at the end states just how BIG the array is
   
   System.out.print("Enter 10 integers: ");
   for(int i = 0; i < array.length; i++)//array.length, does NOT use () as the .lenght() method used for other 
   {
      array[i] = kb.nextInt();//[i] reffers to the index at point i, which is incremented by the for loop
   }
   
   System.out.print("The reverse is: ");
   
   for(int j = array.length-1; j >= 0; j--)//we NEED to use a for loop to print out arrays
   //lenght-1 because .lenght gives the number of elements, but the number of indexes is always - 1 of that
   {
      System.out.print(array[j] + " ");

   }

   
   }
}