import java.util.*;
// Author: Claudiu Moise
// Source: https://techdevguide.withgoogle.com/paths/foundational/stringsplosion-problem-ccocodcode/#!

public class sumNumbers {
    public static void main(String[] args)
    {

        System.out.println(sumNumbers("aa11b33"));
    }

    public static int sumNumbers(String str){
        //TODO better way of resolving off by 1 error
        char we;
        String ll ="";
        char[] bang = str.toCharArray();
        int ok = 0;

        for(int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))){
                //to parse a number "word"
                while(Character.isDigit(str.charAt(i)) && i < str.length()-1){
                    ll += str.charAt(i);
                    i++;
                }
                //edge case, if its the last element in the array!
                if (i == str.length()-1){
                    ll += str.charAt(i);
                }
                ok += Integer.parseInt(ll);
                ll="";
//                i--;
            }

        }

        return ok;
    }
}