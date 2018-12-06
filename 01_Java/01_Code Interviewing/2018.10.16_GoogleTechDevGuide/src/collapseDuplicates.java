public class collapseDuplicates {
//    https://codingbat.com/prob/p256268

    public static void main(String[] args)
    {
        System.out.println(collapseDuplicates("abbbcaaaccc"));
    }

    public static String collapseDuplicates(String a) {
        int i = 0;
        String result = "";
        while (i < a.length()){
            char ch = a.charAt(i);
            result += ch;
            //while loop is same character as the starting letter, keep iterating
            while (i < a.length()-1 && a.charAt(i+1) == ch){
                i++;
            }
            i++;
        }

        return result;

    }


}
