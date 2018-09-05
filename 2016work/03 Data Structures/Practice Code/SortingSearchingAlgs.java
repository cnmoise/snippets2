import java.util.*;

public class SortingSearchingAlgs
{
   public static void main(String[] args)
   {
      int[] myArray = {};//ELEMENTS
      System.out.println(Arrays.toString(myArray));
      
      int[] testArray = myArray.clone();//copies the thing
      //cool method
      
      
   }
   
   //find the smallest elem in spec range
   public static int minIndex(int[] numArray, int first, int last)
   {
      int indexOfMin = first;
      
      for(int i = first + 1; i <= last; i++)
         if(numArray[i] < numArray[indexOfMin])
            indexOfMin = i;
            
      return indexOfMin;
   }

   public static void selectionSort(int[] numArray)
   {
      init last = numArray.length - 1;
      for(int i = 0; i < last; i++)
      {
         int indexOfMin = minIndex(numArray, i, last);
         int temp = numArray[i];
         numArray[i] = numArray[indexOfMin];
         
      }
   }
   
   public static void mergeSort(int[] numArray)
   {
      mergeSortRec(numArray, 0, numArray.length - 1);
   }
   
   //helper method
   public static void mergeSortRec(int[] numArray, int first, int last)
   {
      if (first < last)
      {
         int midIndex = (first + last)/2; //key in creating more divided arrays, aka a floor function
         mergeSortRect(numArray, first, minIndex);
         mergeSortRect(numArray, minIndex + 1, last);//right half, think of the positions when we div the array
         merge(numArray, first, last);
      }
   }
   
   //merge the two halves
   public static void merge(int[] numArray, int first, int last)
   {
      int midIndex = (first + last)/2;
      int n = last - first + 1;//gives size of the aux array?
      int[] tempArray = new int[n]; //merge the halves into a temp arr
      int i1 = first;
      int i2 = midIndex + 1;//
      int j = 0; //next open pos
      
      //as long as neither i1/i2 are past their range, we can take the smaller one and put it in the temp array
      while(i1 <= midIndex && i2 <= last)
      {
         if(numArray[i1] < numArray[i2])
         {
            tempArray[j] = numArray[i1];
            i1++;
         }
         else
         {
            tempArray[j] = numArray[i2];
            i2++;
         }
         
         j++;
         
         //copy the remaining elems of the second half, this will always kind of happen
         while(i2 <= last)
         {
            tempArray[j] = numArray[i2];
            i2++;
            j++;
         }
         
         for(j = 0; j < n; j++)
            numArray[first + j] = tempArray[j];
      }
   }
   
   //helper method
   public static void quickSortRec(int[] numArray, int first, int last)
   {
      if(first< last)
      {
         int splitPoint;
         
         splitPoint = split(numArray, first, last);
         
         //quicksort left subsect
         quickSortRec(numArray, first, splitPoint - 1);//gives elem before middle
         //quicksort left subsect
         quickSortRec(numArray, first, splitPoint + 1);//gives elem after middle
      }
   }
   
   public static void quickSort(int[] numArray)
   {
   
   }
}