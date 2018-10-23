public class removeDuplicatesFromSortedArray {

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2};
        remDup(arr);
    }

    public static int[] remDup (int[] a) {
        if (a.length==0 || a.length==1)
            return a;

        int[] temp = new int[a.length];
        int cap = a.length;

        // Start traversing elements
        int j = 0;
        for (int i=0; i<a.length-1; i++)
            // If current element is not equal
            // to next element then store that
            // current element
            if (a[i] != a[i+1]){
                temp[j++] = a[i];}
            else {cap--;}

        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = a[a.length-1];

        int[] reta = new int[cap];

        for (int i=0; i<j; i++)
            reta[i] = temp[i];

        return reta;
    }
}
