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