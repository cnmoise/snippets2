// https://www.hackerrank.com/challenges/ctci-array-left-rotation/

//rotate all elems in an array to the left
static int[] rotLeft(int[] a, int d) {
        if(a.length==1)
            return a;
        int[] a2 = new int[a.length];
        int i = 0;
        
        //rotate right half of array, by number of places D indicated
        for(int j=a.length-d; j<a.length; j++){
            a2[j] = a[i];
            i++;
        }
        //rotate left half of array
        for(int j=0; j<a.length-d; j++){
            a2[j] = a[i];
            i++;
        }
        
        return a2;
    }