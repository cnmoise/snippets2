//Author: Claudiu Moise
// 
// Given two almost identical lists of prisoner IDs x and y where one of the lists contains an additional ID, 
// write a function answer(x, y) that compares the lists and returns the additional ID 

import java.util.*;

public class solutionScratch
{
	public static void main(String[] args)
	{
      // List<Integer> x = Arrays.asList(13, 5, 6, 2, 5);
//       List<Integer> y = Arrays.asList(5, 2, 5, 13);
//       
//       List<Integer> z = Arrays.asList(14, 27, 1, 4, 2, 50, 3, 1);
//       List<Integer> z2 = Arrays.asList(2, 4, -4, 3, 1, 1, 14, 27, 50);
// 
//       System.out.println("\nOdd one out: " + answer(x, y));
//       
//       System.out.println("\nOdd one out: " + answer(z, z2));
      
      System.out.println("\nWith Arrays ");

      
      int[] xA2 = {13, 5, 6, 2, 5};
      int[] yA2 = {5, 2, 5, 13};
      int[] zA2 = {14, 27, 1, 4, 2, 50, 3, 1};
      int[] z2A2 = {2, 4, -4, 3, 1, 1, 14, 27, 50};
      
      System.out.println("\nOdd one out: " + answer2(xA2, yA2));
      System.out.println("\nOdd one out: " + answer2(zA2, z2A2)); 
   }
   
  public static int answer(List<Integer> x, List<Integer> y){
  
      System.out.println("\nUnsorted x");
      for (int i=0; i<x.size(); i++) 
            System.out.print(x.get(i)+" ");
     
      QuickSortV2(x, 0, x.size()-1);
      
      System.out.println("\nQSx");
      for (int i=0; i<x.size(); i++) 
            System.out.print(x.get(i)+" ");
     
     
      System.out.println("\nUnsorted y");
      for (int i=0; i<y.size(); i++) 
            System.out.print(y.get(i)+" ");     
    
      QuickSortV2(y, 0, y.size()-1);
      
      System.out.println("\nQSy");
      for (int i=0; i<y.size(); i++) 
            System.out.print(y.get(i)+" ");
            
      for(int i=0; i+1 <= x.size() && i+1 <= y.size(); i++){
         
         if (x.get(i) != y.get(i)){
         
            // System.out.println("\nxlist " + x.get(i) + " ylist " + y.get(i));
            if (y.size() < x.size())
               return x.get(i);
            else
               return y.get(i);
         }
            
      }
            
      return -1;
  }
  
  public static int answer2(int[] x, int[] y){
  
      System.out.println("\nUnsorted x");
      for (int i=0; i<x.length; i++) 
            System.out.print(x[i]+" ");
     
      QuickSortV4(x, 0, x.length-1);
      
      System.out.println("\nQSx");
      for (int i=0; i<x.length; i++) 
            System.out.print(x[i]+" ");
     
     
      System.out.println("\nUnsorted y");
      for (int i=0; i<y.length; i++) 
            System.out.print(y[i]+" ");     
    
      QuickSortV4(y, 0, y.length-1);
      
      System.out.println("\nQSy");
      for (int i=0; i<y.length; i++) 
            System.out.print(y[i]+" ");
            
      for(int i=0; i+1 <= x.length && i+1 <= y.length; i++){
         
         if (x[i] != y[i]){
         
            // System.out.println("\nxlist " + x.get(i) + " ylist " + y.get(i));
            if (y.length < x.length)
               return x[i];
            else
               return y[i];
         }
            
      }
            
      return -1;
  }
  
   
   public static void QuickSortV2(List<Integer> inList, int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(inList, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            QuickSortV2(inList, low, pi-1); 
            QuickSortV2(inList, pi+1, high); 
        } 
    }
   
   public static int partition(List<Integer> inList, int low, int high) 
    { 
        int pivot = inList.get(high);  
        int i = (low-1); // index of smaller element 
        int temp = 0;
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (inList.get(j) <= pivot) 
            { 
                i++; 
  
//                ToFill.get(Position) = Value
//                Change to
//                ToFill.set(Position, Value);
  
                // swap arr[i] and arr[j] 
                temp = inList.get(i); 
                inList.set(i, inList.get(j)); 
                inList.set(j, temp); 
            }
        } 
        
  
        // swap arr[i+1] and arr[high] (or pivot) 
        temp = inList.get(i+1); 
        inList.set(i+1, inList.get(high)); 
        inList.set(high, temp);

        return i+1; 
    }
    
    public static int partition2(int arr[], int low, int high) 
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
    public static void QuickSortV4(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition2(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            QuickSortV4(arr, low, pi-1); 
            QuickSortV4(arr, pi+1, high); 
        } 
    }
    
}