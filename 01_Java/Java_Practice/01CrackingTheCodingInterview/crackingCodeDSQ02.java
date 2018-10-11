//import arrays
import java.util.Arrays;


//need class name to start
public class crackingCodeDSQ02
{
   //only in naked Java
   public static void main(String[] args){
//        int[] myArray = {10, 20, 5, 3, 17, 14, 25, 18, 9, 6, 15, 4, 13};
       int[] myArray1 = {'z', 'z', 'a', 's'};       
       int[] myArray2 = {'a', 'a', 's', 'z'};

       System.out.println("myArray1 original is " + Arrays.toString(myArray1));
       System.out.println("myArray2 original is " + Arrays.toString(myArray2));


       
        mergeSort(myArray1);
        System.out.println("myArray1 is " + Arrays.toString(myArray1));
        
        
        mergeSort(myArray2);
        System.out.println("myArray2 is " + Arrays.toString(myArray2));
        
        boolean isIdentical = true;
        
        for(int i = 0; i < myArray1.length && isIdentical; i++){
            if(myArray1[i] != myArray2[i]){
               isIdentical = false;
            }
        }
        
        System.out.println("myArray1 and myArray2 are permutations of eachother: " + isIdentical);


   }
   
   public static void mergeSort(int[] numArray)
    {
        mergeSortRec(numArray, 0, numArray.length - 1);
    }

   
   public static void mergeSortRec(int[] numArray, int first, int last){
   
      if(first < last){
      
         int midIndex = (first + last)/2;
         mergeSortRec(numArray, first, midIndex);
         mergeSortRec(numArray, midIndex+1, last);
         merge(numArray, first, last);
         
      }
   }
   
   public static void merge(int[] numArray, int first, int last){
   
      int midIndex = (first + last)/2;
      int n = last - first+1;
      int[] tempArray = new int[n]; 
      
      int i1 = first;         // next element to consider in the first half
      int i2 = midIndex + 1;  // next element to consider in the second half
      int j = 0;
      
      while (i1 <= midIndex && i2 <= last)
        {
            if (numArray[i1] < numArray[i2])
            {
                tempArray[j] = numArray[i1];
                i1++;//edit the number we look at
            }
            else
            {
                tempArray[j] = numArray[i2];
                i2++;                
            }
            
            j++;
        }
        
        // copy any remaining elements of the first half
        while (i1 <= midIndex)
        {
            tempArray[j] = numArray[i1];
            i1++;
            j++;
        }
        
        // copy any remaining elements of the second half
        while (i2 <= last)
        {
            tempArray[j] = numArray[i2];
            i2++;
            j++;
        }
        
        // copy back from the temp array
        for (j = 0; j < n; j++)
            numArray[first + j] = tempArray[j];

   }
}