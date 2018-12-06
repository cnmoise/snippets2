//Author: Claudiu Moise
//Source:
//  https://techdevguide.withgoogle.com/paths/advanced/compress-decompression/#!


import java.util.Scanner;

public class RecursiveStringDecompress
{

    public static void main(String[] args)
    {
        recDecompress(0, "3[abc]4[ab]c", 1);
    }

    public static void recDecompress(int pos, String s, int times){
        int subTimes;

        while(pos < s.length() && s.charAt(pos) != ']'){
            if (Character.isLetter(s.charAt(pos))){
                System.out.print(s.charAt(pos));
            }
            else
            {
                subTimes = 0;
                while(Character.isDigit(s.charAt(pos))){
                    System.out.println("subTimes: " + subTimes + " s.charAt(pos): "+ s.charAt(pos));

                    subTimes = subTimes * 10 + s.charAt(pos);
                    pos++;
                }
                pos++; //skip [

                System.out.println("subTimes: " + subTimes);
                recDecompress(pos, s, subTimes);
            }
            pos++; //skip closing bracket ] or move to the next letter
        }
    }
}