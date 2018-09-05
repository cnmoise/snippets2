public abstract class Matrix
{
   private int[][] numbers;
   protected Matrix(int[][] nums)
   {
   this.numbers = nums;
   }
   public int[][] getNumbers()
   {
   return this.numbers;
   }
   public abstract void printRowLengths();
}