//https://leetcode.com/problems/two-sum/solution/


//Brute force Solution O(n^2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] retArr = {-1, -2};
        
        for (int i= 0; i < nums.length; i++){
        	//new for loop created every run of i,
        	//important to have a self-adjusting array beginning, not a static one
        	//or youll mess up on [2,5,5,14] where target is 10
            for (int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    retArr[0] = i;
                    retArr[1] = j;
                    return retArr;
                }
            }
        }
        return retArr;
    }
}

//Solution using Hashtables

//HASHMAP COMPLEMENT
//O(N) complexity

public int[] twoSum(int[] nums, int target) {
    //solution returned as a 2 elem array
    Map<Integer, Integer> map = new HashMap<>();

    //first create a map,
    //using the value of each number as our key
    //and the index as the value
    //this is important for when we get the complement
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    //since our values are the keys for the hashmap we can find 
    //the index of the other value and return it

    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}