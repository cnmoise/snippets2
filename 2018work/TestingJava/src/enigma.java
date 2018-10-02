import java.util.*;

public class enigma
{
    public static void main(String[] args)
    {
        int[] pegs = {4, 30, 50};
        int[] pegs2 = {12, 54, 84, 108};

        int[] ans = answer(pegs2);
        System.out.println("Cog Ratio " + ans[0] + ", " + ans[1]);
    }

    public static int[] answer(int[] pegs){
        int pegLength = pegs.length;
        boolean even = false;
        int sum = -1;

        int FirstGearRad = -1;
        int[] spoof = {-1,-1};

        int pegCenter = -1;
        int nRad = -1;

        if (pegs == null || pegLength == 1){
            return spoof;
        }

        if (pegLength % 2 == 0){
            even = true;
        }

        if(even){
            sum = (- pegs[0] + pegs[pegLength -1]);
        }
        else{
            sum = (- pegs[0] - pegs[pegLength - 1]);
        }

        if (pegLength > 2){
            for(int i = 1; i < pegLength-1; i++){
                sum += 2 * Math.pow(-1, i+1) * pegs[i];
            }
        }

        //mathematically only 2 denominators possible
        if(even)
            FirstGearRad = 2*sum/3;
        else
            FirstGearRad = 2*sum;

        int curRad = FirstGearRad;


        for(int i =0; i< pegLength-2; i++){
            pegCenter = pegs[i+1] - pegs[i];
            nRad = pegCenter - curRad;
            if (curRad < 1 || nRad < 1){
                return spoof;
            }
            else{
                curRad = nRad;
            }
        }

        //mathematically only 2 denominators possible
        if (even){
            spoof[0] = FirstGearRad;
            spoof[1] = 1;
            return spoof;
        }
        else{
            spoof[0] = FirstGearRad;
            spoof[1] = 3;
            return spoof;
        }

    }
}