// The RecursiveMethods class that implements several recursive solutions
// Claudiu Moise
// Note: we can't change any values in the array


public class RecursiveMethods 
{
    //NC //largestRec method and returns the largest.
    public int largest(int[] arr)
    {
        return largestRec(arr, 0);
    }
    
    //TARGET // This method takes an integer array as well as an integer (the starting index) and returns the largest number in the array.
    public int largestRec(int[] arr, int pos)
    {		
        if (pos == arr.length - 1) //arr.length == 1 && pos == 0
        {
            return arr[pos];
        }
        else
        {
            return Math.max(arr[pos], largestRec(arr, pos+1));//duh
        }
    }
    
    //NC // This method calls the sumRec method and returns the sum of the array.
    public int sum(int[] arr)
    {
        return sumRec(arr, 0);
    }    

    //TARGET // This method takes an integer array as well as an integer (the starting index) and returns the sum of the values in the array.
    public int sumRec(int[] arr, int pos)
    {	
        //Base case //if we are at the end of the array basically
        if(pos == arr.length-1)
        {
         return arr[arr.length-1];//we return the last pos
        }
        else // pos < arr.length-1
        {
         //int s = s + sumRec(arr, pos + 1);
         return arr[pos] + sumRec(arr, pos + 1);//most 
        }
    }  

    //TARGET // This method takes an array as well as two integers: start and end.
    // It returns true if the array is sorted in nondecreasing order (aka INCREASING ORDER) 
    // between the indices start and end, or false otherwise.
    public boolean isSorted(int[] arr, int start, int end)
    {
        if(start == end)//we need this bc we sometimes test just a segment of the array
           return true;//if we reach the last position in the array, it must be true since we haven't already market it false
        else if (arr[start] > arr[start + 1])//if we have an elem. on the left that is larger than the one on the right, 
           return false;//it indicates we have decreased, therefore violating our condition
        return isSorted(arr, start + 1, end);//then we move our starter to the right
    }
    
    // Bonus // This method takes a reference to the head of a linked list.
    // It returns the reference to the head of the linked list in the reversed order.
    public LNode reverseListRec(LNode head)
    {	
        return new LNode(-1);
    }
}