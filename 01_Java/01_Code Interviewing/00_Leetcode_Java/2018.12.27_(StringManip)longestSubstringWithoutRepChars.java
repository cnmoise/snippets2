//Source
//https://leetcode.com/problems/longest-substring-without-repeating-characters/


//naive solution, n^2 time
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cha = s.toCharArray();
        int curmax = 0;
        Set <Character> seenL = new HashSet<Character>();
        int streak = 0;
        int j = 0;
        
        //need double loops because we have to restart the substring at next to first index we were checking
        for(int i = 0; i<cha.length; i++){
            j = i;
            //order of statements matters,
            //having checks the other way around will give out of bounds
            while(j < cha.length && !seenL.contains(cha[j])){
                seenL.add(cha[j]);
                j++;
                streak++;
            }
            
            if(streak>curmax){curmax = streak;}
            //impossible to get a longer substring if j has already reached the length limit
            if(j>= cha.length){break;}
            
            seenL.clear();
            streak = 0;
        }
        return curmax;
    }
}

//SLIDING WINDOW TECH (common in string/array problems)

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }
            else {
                //shrinks our window size/removes repeated letter so we can have a unique substring
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}