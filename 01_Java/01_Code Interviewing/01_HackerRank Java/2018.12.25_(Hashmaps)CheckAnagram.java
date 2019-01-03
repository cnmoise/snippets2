public class anagram {

    public static boolean areAnagrams(String s1, String s2) {
        //pre-conds
        //check if same length, if they are the same string
        //and if either string is null or if either string is empty

        //similar to the checkMagazine/Ransom note problem

        //uses the "Pop. then Depop. HashMap" method

        if(s1.length() != s2.length()){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }
        if(s1=="" || s2=="" || s1 == null || s2 == null){
            return false;
        }

        Map<Character, Integer> hm = new HashMap<Character, Integer>();

        //populate the hashmap
        for(int i=0; i< s1.length(); i++){
            char curC = s1.charAt(i);
            if(hm.containsKey(curC)){
                //add the the count of letters we can use
                hm.put(curC, hm.get(curC)+1);
            }
            else{
                //never encountered before
                hm.put(curC, 1);
            }
        }

        //check against the other string removing 
        for(int i=0; i< s2.length(); i++){
            char curC = s2.charAt(i);
            if(hm.containsKey(curC)){
                if(hm.get(curC) > 0){
                    hm.put(curC, hm.get(curC)-1);
                }
                else{
                    hm.remove(curC);
                }
            }
            else{
                return false;
            }
        }

        //all letters were contained by the other string
        return true;
    }
}
        
