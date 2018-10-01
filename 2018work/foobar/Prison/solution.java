/*
Author: Claudiu Moise
Email: claudiu.moise@gmail.com

Hi Google! Looking forwards to meeting your team at Northeastern Illinois University!
Thanks for the easter egg, it's by far the most energizing interview application I've seen

To learn more about me & see if I'm a good fit for your company check out my: 

Resume:
    https://tinyurl.com/yafqpmz3
Personal website:
    http://homepages.neiu.edu/~cnmoise/site/ 
Github:
   https://github.com/cnmoise
LinkedIn:
   https://www.linkedin.com/in/cnmoise/
*/

import java.util.*;

public class solution
{
	public static void main(String[] args)
	{
      int[] xA2 = {13, 5, 6, 2, 5};
      int[] yA2 = {5, 2, 5, 13};
      int[] zA2 = {14, 27, 1, 4, 2, 50, 3, 1};
      int[] z2A2 = {2, 4, -4, 3, 1, 1, 14, 27, 50};
      
      System.out.println("\nOdd one out: " + answer(xA2, yA2));
      System.out.println("\nOdd one out: " + answer(zA2, z2A2)); 

   }
   
  public static int answer(int[] x, int[] y){
      QuickSort(x, 0, x.length-1);
      QuickSort(y, 0, y.length-1);
      
      for(int i=0; i+1 <= x.length && i+1 <= y.length; i++){
         if (x[i] != y[i]){
            if (y.length < x.length)
               return x[i];
            else
               return y[i];
         }           
      }  
      return -1;
  }
   
   public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    }
    
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public static void QuickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            QuickSort(arr, low, pi-1); 
            QuickSort(arr, pi+1, high); 
        } 
    } 
}