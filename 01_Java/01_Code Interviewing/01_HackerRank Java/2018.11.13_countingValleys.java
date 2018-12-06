static int countingValleys(int n, String s) {
        int sl = 0;
        int v = 0;
        
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='U'){
                //if were climbing out and about the exit a valley, count
                if(sl+1==0){
                    v++;
                }
                sl++;
            }
            if(s.charAt(i)=='D'){
                sl--;
            }
        }
    return v;