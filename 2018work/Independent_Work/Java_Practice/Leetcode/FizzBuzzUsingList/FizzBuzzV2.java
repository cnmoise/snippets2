//Author: Claudiu Moise
// Write a program that outputs the string representation of numbers from 1 to n.
// 
// But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
// For numbers which are multiples of both three and five output “FizzBuzz”.
import java.util.*;

public class FizzBuzzV2
{
	public static void main(String[] args)
	{
      fizzBuzz(15);
   }
   

    public static List<String> fizzBuzz(int n) {
        //Author: Claudiu Moise
        List<String> fbList = new ArrayList();

        for(int i = 1; i <= n; i++){
            fbList.add(""+i);
        }
         
         for(int i = 1; i < fbList.size(); i++)
            {
              //needed so we can compare divisibility
              int indexValfromList = Integer.valueOf(fbList.get(i));
              
              
               if(indexValfromList % 3 == 0 && indexValfromList % 5 != 0)
                  fbList.set(i, "Fizz"); //replaces ith element with Fizz
               else if(indexValfromList % 5 == 0 && indexValfromList % 3 != 0)
                  fbList.set(i, "Buzz");
               else if(indexValfromList % 5 == 0 && indexValfromList % 3 == 0)
                  fbList.set(i, "FizzBuzz");
               
               //Spy
               //.get(i), returns a value from fbList at index i
               //System.out.println(fbList.get(i));
            }
         
         return fbList;

    }
    
    // Faster Solution, combine Forloop statements
    
//     public List<String> fizzBuzz(int n) {
//         List<String> temp = new ArrayList<String>();
//         for(int i = 1; i <= n; i++)
//         {
//             if(i % 3 == 0 && i % 5 == 0)
//             {
//                 temp.add("FizzBuzz");
//             }
//             else if(i % 3 == 0)
//             {
//                 temp.add("Fizz");
//             }
//             else if(i % 5 == 0)
//             {
//                 temp.add("Buzz");
//             }
//             else 
//             {   
//                 String str1 = Integer.toString(i); 
//                 temp.add(str1);
//             }
//         }
//         return temp;

}