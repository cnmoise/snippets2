public class HW8Tracing
{
   public static void main(String[] args)
   {
   int size = 4, i = 0;
   int[] nums = {5, 2, 15, 1};
   while (i < size)
   {
   method1(nums, i);
   System.out.println("i is " + i + " and nums[i] is " + nums[i] * 2);
   i++;
   }
   int[] nums2 = method2(nums);
   method3(nums2);
   }
   public static void method1(int[] array, int index)
   {
   array[index] = index * array[index];
   }
   public static int[] method2(int[] array)
   {
   int[] nums = new int[array.length];
   for (int i = 0; i < array.length; i++)
   nums[i] = (array[i] + 1) % array.length;
   return nums;
   }
   public static void method3(int[] array)
   {
   for (int i = 0; i < array.length; i++)
   System.out.print(array[i] + " ");
   System.out.println();
   }
}