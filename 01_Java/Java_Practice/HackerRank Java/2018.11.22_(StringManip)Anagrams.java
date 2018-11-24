// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

static int makeAnagram(String a, String b) {
        //a letter count & b letter count
        char[] alc = new char[26];
        char[] blc = new char[26];
        int temp = -1;
        int diff = 0;
        //cool trick
        //int offset = (int) 'a';

        for(int i = 0; i < a.length(); i++){
            //places letter at the corresponding position in the alphabet array
            temp = Integer.valueOf(a.charAt(i));
            alc[temp-97]+=1;
        }
        for(int i = 0; i < b.length(); i++){
            temp = Integer.valueOf(b.charAt(i));
            blc[temp-97]+=1;
        }
        for(int k = 0; k < alc.length; k++){
            diff += Math.abs(alc[k]-blc[k]);
        }
        return diff;

    }