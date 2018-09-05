public class MatrixTest
{
	public static void main(String[] args)
	{
   int[][] a = { { 18, 0, 2 },
               { 3, -3 },
               { 29, 4, 8, -1 } };
               
   MyMatrix mm1 = new MyMatrix(a);
   mm1.printRowLengths();
   
   System.out.println(mm1.largestNumber());
   mm1.printRowForUser();
   System.out.println();
   
   int[][] b = { { -7, -5, -19, -34 } };
   MyMatrix mm2 = new MyMatrix(b);
   mm2.printRowLengths();
   
   System.out.println(mm2.largestNumber());
   mm2.printRowForUser();
   
   }
   
}
