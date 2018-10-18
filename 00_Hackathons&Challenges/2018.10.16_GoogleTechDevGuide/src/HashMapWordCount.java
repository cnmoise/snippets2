import java.util.HashMap;
import java.util.Map;


//https://codingbat.com/prob/p117630

public class HashMapWordCount {

    public static void main(String[] args)
    {
        String[] words = {"a", "b", "a", "c", "b"};

        System.out.println(wordCount(words));
    }

    public static Map<String, Integer> wordCount(String[] strings) {
        //Hashmap of string keys to integer values
        Map<String, Integer> hashedmap = new HashMap<String, Integer>();

        //Some complicated conversions!
        for(int i=0; i < strings.length; i++){
            if(hashedmap.containsKey(strings[i])){
                //increments current value at position key
                hashedmap.put(strings[i], hashedmap.get(strings[i])+1);
            }
            else{
                //its the first time the words been encountered
                hashedmap.put(strings[i], 1);
            }
        }

        return hashedmap;
    }
}
