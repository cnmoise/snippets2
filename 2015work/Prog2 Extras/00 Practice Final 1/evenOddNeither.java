//
import java.util.Scanner;
import java.io.*;

public class evenOddNeither
{
   public static void main(String[] args)
   {
        File f = new File("data.txt");
        try
        {
        Scanner kb = new Scanner(f);
        boolean first = true;
        int Omin = 0;//overall minimum, has to be inialized out here
    
            while(kb.hasNext())//we're checking to see if the scanner (kb) has the next element not the file
            {
                int i1 = kb.nextInt();
                int i2 = kb.nextInt();
                int min = i1;
                if(first)
                {
                    Omin = min;//if statements count as blocks of code, so you can't declare a var here
                     
                    first = false;
                }
                if(i1%2 == 0 && i2 % 2 == 0)
                  System.out.println("Even");
                else if(i1%2 != 0 && i2 % 2 != 0)//ELSE IF <- Correct Syntax
                  System.out.println("Odd");
                else
                  System.out.println("Neither");
                  
                min = Math.min(min,i2);//Math is a library, the first letter is capitalized
                Omin = Math.min(min, Omin);//once we get the min between the numbers we compare that to the lowest min found
                System.out.println("Cur. min:" + Omin);

            }
            
        kb.close();    
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
   
   }
}