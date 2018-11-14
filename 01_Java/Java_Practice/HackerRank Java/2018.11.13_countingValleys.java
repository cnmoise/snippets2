static int countingValleys(int n, String s) {
        int sl = 0;
        int v = 0;
        
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='U'){
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