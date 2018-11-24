// https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps

HashMap <String, Integer> magm = new HashMap();
        boolean hasAllWords = true;
        
        for(String magw : magazine){
            if(!magm.containsKey(magw)){
                magm.put(magw, 1);
            } else {
                magm.put(magw, magm.get(magw)+1);
            }
        }
        for(String notew:note){
            if(magm.containsKey(notew)){
                magm.put(notew, magm.get(notew)-1);
                if(magm.get(notew)==0){
                    magm.remove(notew);
                    }
                }
            else{
                hasAllWords = false;
            }
        }
        
        if(hasAllWords)
            System.out.println("Yes");
        else
            System.out.println("No");