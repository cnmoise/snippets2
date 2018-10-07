
public class FibonacciRecAndIter
{
    public static void main(String[] args)
    {
//        for (int i = 0; i <= 50; i++)
//            System.out.print(fibIter(i) + " ");
//        
//        System.out.println();
//        
//        for (int i = 0; i <= 50; i++)
//            System.out.print(fibRec(i) + " ");
//        
//        System.out.println();
        
        System.out.println(recReverseString("ABCDEFG"));
    }
    
    public static int fibRec(int n)
    {
        if (n == 0 || n == 1)
            return 1;
        else
            return fibRec(n - 1) + fibRec(n - 2);
    }
    
    public static int fibIter(int n)
    {
        if (n == 0 || n == 1)
            return 1;
        
        int[] fibNumbers = new int[n + 1];
        fibNumbers[0] = fibNumbers[1] = 1;
        
        for (int i = 2; i <= n; i++)
            fibNumbers[i] = fibNumbers[i - 1] + fibNumbers[i - 2];
        
        return fibNumbers[n];
    }
    
    // recursively reverse a string
    public static String recReverseString(String s)
    {
        if (s.length() == 0 || s.length() == 1)
            return s;
        else
        {
            char lastChar = s.charAt(s.length() - 1);
            String shorter = s.substring(0, s.length() - 1);
            
            return lastChar + recReverseString(shorter);
        }
    }
}
