//demo for lin search and binary search
//need to complete

import java.util.*;//to sue toString

public class BinarySearch
{
   public static void main(String[] args)
   {
      int[] myArray = {10, 20, 5, 3, 17, 14, 21, 18};
      System.out.println("Orig Array" + Arrays.toString(myArray));
      
      System.out.print("Enter a num to search for: ");
      Scanner in = new Scanner(System.in);
      int value = in.nextInt();
      
      System.out.println("Lin search result" + linearSearch(myArray, value)));

   }
   
   public static boolean linearSearch(int[]numArray, int value)//aka sequential
   {
      for(int i = 0; i < numArray.length; i++)
         if (numArray[i]== value)//executes loop until we find someting
            return true;
         //otherwise we dead
         return false;
   }
   
   public static boolean binarySearchIter(int[] numArray, int value)
   {
      int first = 0;
      int last = numArray.length-1;//bounds of our search space
      
      while(first <= last)
      {
         int mid = (first + last)/2;
         
         if(value < numArray[mid])//we need to change which elem is our last if we find the number in the first half
            last = mid - 1;
         else if (value > numArray[])//vice versa
            first = mid + 1;
         else
            return true;
      }
   
   }
   
   public static boolean binarySearchRecHelper(int[] numArray, int value, int first, int last)
   {
      if(first > last)
         return false;
         
      int mid = (first + last)/2;
      
      if(value< numArray[mid])
         return binarySearchHelper(numArray, value, 
   
   }

}