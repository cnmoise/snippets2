import java.util.*;
// Author: Claudiu Moise
// Source: https://techdevguide.withgoogle.com/paths/foundational/stringsplosion-problem-ccocodcode/#!

public class withoutString {
    public static void main(String[] args)
    {

        System.out.println(withoutString("Hi HoHo", "Ho"));
    }

    public static String withoutString(String base, String remove) {
        //not that efficient
        //removes all cases of capitalization
        base = base.replace(remove, "");

        remove = remove.toLowerCase();
        base = base.replace(remove, "");

        remove = remove.toUpperCase();
        base = base.replace(remove, "");

        return base;
    }
}