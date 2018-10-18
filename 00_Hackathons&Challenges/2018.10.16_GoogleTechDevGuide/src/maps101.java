import java.util.HashMap;
import java.util.Map;

public class maps101
{
    // Author: Claudiu Moise
    // Source:https://techdevguide.withgoogle.com/paths/foundational/mapshare-problem-return-given-map/#!
    /*
    *
    * // Make a new empty map
    Map<String, String> map = new HashMap<String, String>();
    map.get(key) -- retrieves the !!!!stored value!!!! for a key,or null if that key is not present in the map.

    map.put(key, value) -- stores a new key/value pair in the map. Overwrites any existing value for that key.

    map.containsKey(key) -- returns true if the key is in the map, false otherwise.

    map.remove(key) -- removes the key/value pair for this key if present. Does nothing if the key is not present.
    * */

    public static void main(String[] args)
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");

        System.out.println(mapShare(map));
    }

    public static Map<String, String> mapShare(Map<String, String> map) {
        String bang = "";

        if(map.containsKey("c")){
            map.remove("c");
        }
        if(map.containsKey("a")){
            bang = map.get("a");
            map.put("b", bang);
        }

        return map;
    }
}

