import java.util.*;
// Author: Claudiu Moise
// Source: https://techdevguide.withgoogle.com/paths/foundational/stringsplosion-problem-ccocodcode/#!

public class maxSpan {
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 1, 1, 3};
        maxSpan(arr);
    }

    public static int maxSpan(int[] nums) {
        int sli = 0;
        int[][] spanTrack = new int[100][100];

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

        int possMax = spanTrack[0][0] - spanTrack[0][1] + 1;
        int prevMax = possMax;
        for(int kek = 0; kek < spanTrack.length; kek++){
            possMax = spanTrack[kek][0] - spanTrack[kek][1]+1;
            System.out.printf("= %d - %d +1\n", spanTrack[kek][0], spanTrack[kek][1]);
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


