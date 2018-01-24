package BubbleSort;

/**
 * Created by Claudiu on 5/11/2016.
 */
public class SortArray
{
    public static int[] sortLowToHigh(int[] a)
    {
        int[] arr = a;
        boolean hasSwapped = true;
        int temp = 0;

        while(hasSwapped)
        {
            hasSwapped = false;
            for(int i = 0; i < arr.length - 1; i++)//-1 so we don't go out of bounds
            {
                if(arr[i] > arr[i+1])
                {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    hasSwapped = true;
                }//nested for
            }
            //if no swaps are needed
        }
        return arr;
    }



    //Shuffle algorithm
}
