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

//    V2, a forray into using Lists
//    Rem: They're not arrays, can be added on the fly, no size needs to be declared
//    SN:
//          fbList.set(i, "FizzBuzz"); //sets attribute at position i with "FizzBuzz"

    public static List<String> fizzBuzz(int n) {
        List<String> fbList = new ArrayList();
        String str1;

        for(int i = 1; i <= n; i++)
        {
            if(i % 3 == 0 && i % 5 == 0){
                fbList.add("FizzBuzz");
            }
            else if(i%3 == 0){
                fbList.add("Fizz");
            }
            else if(i%5 == 0){
                fbList.add("Buzz");
            }
            else{
                str1 = Integer.toString(i);
                fbList.add(str1);
            }
        }

        for(int i = 0; i < fbList.size(); i++)
        {
            //.get(i), returns a value from fbList at index i
            System.out.println(fbList.get(i));
        }
        return fbList;

    }
}