
public class evenlySpaced {

    public static void main(String[] args)
    {
        System.out.println(evenlySpaced(2, 4, 6));
    }

    public static boolean evenlySpaced(int a, int b, int c) {
        int diff1 = 0;
        int diff2 = 0;
        int diff3 = 0;

        if(a==b && a ==c)
            return true;

        if(a == b || b == c || a == c)
            return false;
        //calculates distance to each item
        diff1 = Math.abs(a - b);
        diff2 = Math.abs(a - c);
        diff3 = Math.abs(b - c);

        //compares the distances between objects
        if(diff1 == diff2)
            return true;
        if(diff1 == diff3)
            return true;
        if(diff2 == diff3)
            return true;

        return false;

    }

}