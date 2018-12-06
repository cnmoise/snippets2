import java.util.*;
// Author: Claudiu Moise
// Source: https://techdevguide.withgoogle.com/paths/foundational/canbalance-problem-arrays-non-empty/#!

public class canBalance {
    public static void main(String[] args)
    {
        int[] arr = {1, 1, 1, 2, 1};
        int[] arr2 = {2, 1, 1, 2, 1};

        System.out.println(canBalance(arr2));
    }

    public static boolean canBalance(int[] nums){
        int lsum = 0;
        int rsum = 0;

        //add up numbers until the second to last number
        //start "searching" our array from the end
        for(int i = 0; i < nums.length-1; i++){
            lsum += nums[i];
            System.out.println("lsum:"+lsum);
        }
        rsum = nums[nums.length-1];
        System.out.println("lsum:"+lsum);
        System.out.println("rsum:"+rsum);

        //increase rsum element by element
        //while also decreasing lsum element by element
        if (rsum == lsum){
            return true;
        }
        for(int i = nums.length-2; i > 0; i--) {
            lsum = lsum - nums[i];
            rsum = rsum + nums[i];

            System.out.println("nums[i]:"+ nums[i]);
            System.out.println("lsum:"+lsum);
            System.out.println("rsum:"+rsum);

            if (rsum == lsum){
                return true;
            }
        }
        return false;
    }
}