import java.util.*;
// Author: Claudiu Moise
// Source: https://techdevguide.withgoogle.com/paths/foundational/stringsplosion-problem-ccocodcode/#!

public class stringSplosion {
    public static void main(String[] args)
    {

        System.out.println(stringSplosion("Code"));
    }

    public static String stringSplosion(String str) {
        String ok = "";

        for(int i = 0; i < str.length(); i++){
            ok = ok + str.substring(0, i+1);
        }
        return ok;
    }
}
