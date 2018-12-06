
//Source
//https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

static int jumpingOnClouds(int[] c) {
        int curCloud = 0;
        int jumps = 0;
        
        while(curCloud < c.length-1){
            //
            if(curCloud < c.length-2){
                if (c[curCloud+2]==0){
                    curCloud+=2;
                    jumps++;
                }
                else{
                    curCloud++;
                    jumps++;
                }
            }
            else{
                curCloud++;
                jumps++;
            }
        }
        return jumps;
    }