import java.util.*;
// Author: Claudiu Moise
// Source: https://techdevguide.withgoogle.com/paths/foundational/stringsplosion-problem-ccocodcode/#!

public class maxSpan {
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 1, 1, 3};
        System.out.println("Final Max Span ARR: " + maxSpan(arr));

        int[] arr2 = {1, 4, 2, 1, 4, 1, 4};
        System.out.println("Final Max Span ARR2: " + maxSpan(arr2));

        int[] arr3 = {1, 4, 2, 1, 4, 4, 4};
        System.out.println("Final Max Span ARR3: " + maxSpan(arr3));

        int[] arr4 = {};
        System.out.println("Final Max Span ARR3: " + maxSpan(arr4));
    }

    public static int maxSpan(int[] nums) {
        int sli = 0;
        int[][] spanTrack = new int[100][100];

        //remember to check for preconditions
        //is the array empty?
        if(nums.length == 0){
            return 0;
        }

        //finds first occurences and last occurences of each number
        for(int fp =0; fp < nums.length; fp++){
            for(int sp = fp; sp < nums.length; sp++){
                if(nums[fp] == nums[sp]){
                    spanTrack[sli][0] = fp;
                    spanTrack[sli][1] = sp;

                    System.out.println("[" +  spanTrack[sli][0] +" , "+  spanTrack[sli][1] + "]");
                }
                sli++;
            }
        }

        //difference between start and end is the span of each element
        int possMax = spanTrack[0][1] - spanTrack[0][0] +1;
        int prevMax = possMax;
        for(int kek = 0; kek < spanTrack.length; kek++){
            possMax = spanTrack[kek][1] - spanTrack[kek][0] + 1;
            System.out.printf("Is possMax [%d] > prevMax [%d]\n", possMax, prevMax);
            if (possMax > prevMax){
                prevMax = possMax;
                System.out.printf("Yes new prevMax = [%d]\n", prevMax);
            }
            else{
                System.out.println("No");
            }
        }

        return prevMax;
    }
}


