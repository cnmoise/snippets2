import java.util.HashMap;
import java.util.Map;


//https://codingbat.com/prob/p238573

public class wordEncoder {

    public static void main(String[] args)
    {
        //words to encode
        String[] raw = {"a", "b", "a"};
        //cypher list
        String[] code_words = {"1", "2", "3", "4"};

        String[] testarr = encoder(raw, code_words);

        for(String s: testarr){
            System.out.println(s);
        }
    }

    public static String[] encoder(String[] raw, String[] code_words){
        //Hashmap of string keys to integer values
        Map<String, String> hashedmap = new HashMap<String, String>();
        //slider for codewords
        int j = 0;
        String[] reta = raw;

        for(int i=0; i < raw.length; i++){
            if(hashedmap.containsKey(raw[i])){
                //if the word has already been given a codeword, we assign the one its already been assigned
                reta[i] = hashedmap.get(raw[i]);
            }
            else{
                //assign a new value in hashmap and also assigns it to the return array
                hashedmap.put(raw[i], code_words[j]);
                reta[i] = code_words[j];
                //move to next available codeword value
                j++;
            }
        }

        return reta;
    }
}
