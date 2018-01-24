//Author: Claudiu Moise
//This is an attempt to create and implement a bubble sort
//The program should take an array of digits and sort them from largest to smallest

public class BubbleSort
{
	public static void main(String[] args)
	{
      boolean hasSwapped = true;
      int arr[] = {84, 69, 76, 86, 94, 91};
      int temp = 0;
      
      while(hasSwapped)
      {
         hasSwapped = false;
         for(int i = 0; i < arr.length - 1; i++)//-1 so we don't go out of bounds
         {
            if(arr[i] < arr[i+1])
            {
               temp = arr[i];
               arr[i] = arr[i+1];
               arr[i+1] = temp;
               hasSwapped = true;
            }//nested for
         }
         //if no swaps are needed
      }
      
      for(int i = 0; i < arr.length; i++)
      {
      System.out.print(arr[i] + " ");
      }
   }
}