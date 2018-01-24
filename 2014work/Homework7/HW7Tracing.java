public class HW7Tracing
{
   public static void main(String[] args)
   {
   int i, j, k, size = 4;
   int[] arr = {6, 2, 15, 1};
   
   System.out.println("before");
   
   for (i = 0; i < size; i++)
   //considering that arrays start counting indexes at 0,
   //the loop first itterates starting with 0
   //so even though we end when the size is 3, we get to view all of the indexes 
      System.out.print(arr[i] + " ");
   
   System.out.println();
   System.out.println();
   
   for (i = 0; i < size - 1; i++)
   {
      for (j = i + 1; j < size; j++)
         if(arr[j] <= arr[i])//i doesn't change until we exit the loop
         //j however does.
         {
         arr[i] = arr[j] - 1;
         arr[j] = arr[j] + 1;
         }
      System.out.print((i + 1) + ": ");//prints the prefix
      
      for (k = 0; k < size; k++)
         System.out.print(arr[k] + " ");//prints the array so far
         
      System.out.println();
   }
   System.out.println();
   System.out.println("after");
   for (i = 0; i < size; i++)
      System.out.print(arr[i] + " ");
   System.out.println();
   }
}