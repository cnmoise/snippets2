// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

static int[] rotLeft(int[] a, int d) {
        if(a.length==1)
            return a;
        int[] a2 = new int[a.length];
        int i = 0;
        
        for(int j=a.length-d; j<a.length; j++){
            a2[j] = a[i];
            i++;
        }
        for(int j=0; j<a.length-d; j++){
            a2[j] = a[i];
            i++;
        }
        
        return a2;
    }