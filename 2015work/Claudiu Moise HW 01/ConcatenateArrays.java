//Author: Claudiu Moise || Homework 1 || Problem 1
//Takes two different arrays and smushes them into one array


public class ConcatenateArrays
{
	public static void main(String[] args)
	{
		int[] t1 = { 3, 2, -1, 4 };
		int[] t2 = { 9, -7 };
		int[] t = concatenateArrays(t1, t2);
		printArray(t);

		int[] v1 = { -4, -4, 0, -4, 2 };
		int[] v2 = { -4, -4, 0, -4, 2, 9, 15 };
		int[] v = concatenateArrays(v1, v2);
		printArray(v);

		// If you coded this correctly, your output should be: 
		// 3 2 -1 4 9 -7 
		// -4 -4 0 -4 2 -4 -4 0 -4 2 9 15
	}

	public static int[] concatenateArrays(int[] a, int[] b)
	{
      int arrLen = a.length + b.length;
      //adds up the number of elements in the first and the second array into one which can hold them both
      int doorStop = 0;      
      int[] storeArray = new int[arrLen];//creates new array of the same size as our two arrays
      
      for (int i = 0; i < a.length; i++)
      {
         storeArray[i] = a[i];
         doorStop = i+1;
         //doorStop tells us where the first array finished off writing so we can start there with the next array
      }
      for (int i = 0; i < b.length; i++)
      {
         storeArray[i + doorStop] = b[i];
      }
      
      return storeArray;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}
}
