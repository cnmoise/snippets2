import java.util.HashMap;
import java.util.Map;
//https://codingbat.com/prob/p152303

//Given an array of strings, return a Map<String, Integer> containing a
// key for every different string in the array, always with the value 0.
// For example the string "hello" makes the pair "hello":0. We'll do more
// complicated counting later, but for this problem the value is simply 0.
//
//
//        word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
//        word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
//        word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}

public class HashMapsWord0 {

    public static void main(String[] args)
    {
        String[] words = {"this", "and", "that", "and"};

        System.out.println(word0(words));
    }

    public static Map<String, Integer> word0(String[] strings) {
        //Hashmap of string keys to integer values
        Map<String, Integer> hashedmap = new HashMap<String, Integer>();

        for(int i=0; i < strings.length; i++){
            hashedmap.put(strings[i],strings[i].length());
        }

        return hashedmap;
    }
}
