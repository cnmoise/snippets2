//https://www.hackerrank.com/challenges/alternating-characters/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

static int alternatingCharacters(String str) {
        char[] ch = str.toCharArray();
        boolean Acombo= false;
        boolean Bcombo= false;
        int co= 0;

        for(int i = 0; i < ch.length; i++){
            if(ch[i]=='A'){
                if(Acombo)
                    co++;
                Acombo = true;
                Bcombo = false;
            }

            if(ch[i]=='B'){
                if(Bcombo)
                    co++;
                Acombo = false;
                Bcombo = true;
            }
        }
        return co;
    }

//Less convoluted solution
    //rem: we can just look at multiple inceces at once
        String test = "ABABABAB";
for (int i = 1; i <= nooftestcases; i++) {
        int count=0;
        for (int j = 0; j < test.length()-1; j++) {
            if(test.charAt(j)==test.charAt(j+1))
                count++;
          } 
        System.out.println(count);
    }
