//import arrays
import java.util.Arrays;


//need class name to start
public class crackingCodeDSQ01
{
   //only in naked Java
   public static void main(String[] args){
      
       String test2 = "lets go to the beach";

      int[] alphabetOccurances = new int[27];
      int arraySize;
      int itemsInArray= 0;
      
      String test1 = "senua";
      char[] t1A = test2.toCharArray();
      
       HashFunction(t1A, alphabetOccurances);

   }
   
   public static void HashFunction(char[] t1A, int[] alphabetOccurances){
   
      int asciiVal;
      int hashedPos;
   
      for(int i = 0; i < t1A.length; i++){
         asciiVal = t1A[i];
         if(asciiVal != 32){
            hashedPos = asciiVal-97;
            
            alphabetOccurances[hashedPos]++;
            System.out.println(alphabetOccurances[hashedPos] + " occurances of letter "+ t1A[i]);
         }
      }   
   }
}