import java.util.HashMap;
import java.util.Map;

//https://codingbat.com/prob/p126332

public class hashmapPairs {

    public static void main(String[] args)
    {
        String[] words = {"man", "moon", "good", "night"};

        System.out.println(word0(words));
    }

    public static Map<String, String> word0(String[] strings) {
        //Hashmap of string keys to integer values
        Map<String, String> hashedmap = new HashMap<String, String>();

        //Some complicated conversions!
        for(int i=0; i < strings.length; i++){
            //1: gets char at index 0, and converts char to a string
            //2: gets char at last index of the word, and converts char to a string

            hashedmap.put(Character.toString(strings[i].charAt(0)),
                    Character.toString(strings[i].charAt(strings[i].length()-1)));
        }

        return hashedmap;
    }
}
