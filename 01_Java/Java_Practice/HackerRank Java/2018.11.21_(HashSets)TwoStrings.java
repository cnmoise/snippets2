//https://www.hackerrank.com/challenges/two-strings/problem

//because of the small size of the problem you can also just use two strings iterating over the smaller one

static String twoStrings(String s1, String s2) {
        HashSet<Character> w1 = new HashSet<Character>();
        HashSet<Character> w2 = new HashSet<Character>();

        char[] ww1 = s1.toCharArray();
        char[] ww2 = s2.toCharArray();
        boolean foundSubstring = false;

        for(char ch : ww1){
            w1.add(ch);
        }
        for(char ch : ww2){
            w2.add(ch);
        }
        if(w1.size() > w2.size()){
            for(Character letter: w1){
                if(w2.contains(letter)){
                    foundSubstring = true;
                }
            }
        }
        else{
            for(Character letter: w2){
                if(w1.contains(letter)){
                    foundSubstring = true;
                }
            }
        }

        if(foundSubstring){
            return "YES";
        }
        else{
            return "NO";
        }
    }