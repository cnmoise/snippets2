//https://www.hackerrank.com/challenges/ctci-ransom-note/problem

static void checkMagazine(String[] magazine, String[] note) {

        HashMap <String, Integer> magm = new HashMap();
        boolean hasAllWords = true;
        
        //populate magazine
        for(String magw : magazine){
            if(!magm.containsKey(magw)){
                magm.put(magw, 1);
            } else {
                magm.put(magw, magm.get(magw)+1);
            }
        }
        //for each word in the note, we see if its contained in the magazine
        //if it is, we decrement the number of words available from the magazine (since we have to cut one out)
        //if the count of words has reached 0, we must remove the word from the magazine

        //Nice tech
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
    }