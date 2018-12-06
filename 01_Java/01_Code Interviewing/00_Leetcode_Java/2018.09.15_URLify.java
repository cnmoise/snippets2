//import arrays
import java.util.Arrays;


//need class name to start
public class URLify
{
   //only in naked Java
   public static void main(String[] args){

      String test = "Fuck this stupid shit";
      String result = "";
      
      String[] tArr = test.split(" ");
      
      for(int i=0; i < tArr.length;i++){
         
         result += tArr[i];
         if(i != tArr.length-1){
             result += "%20";
         }
      }
         
   System.out.println(result);

   }
}