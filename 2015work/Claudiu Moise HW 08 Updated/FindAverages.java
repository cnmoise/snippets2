//Author: Claudiu Moise || Homework 8 || Problem 3
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program
//Takes all of the names from files, prints them out
//also creates an average

import java.util.*;
import java.io.*;

public class FindAverages
{
    public static void main(String[] args)
    {
         File f = new File("scores.txt");//creates a file object
         try
         {
            Scanner input = new Scanner(f);//inputs our file
            
            while (input.hasNext())//goes through the whole file
            {
               String first = input.next();
               String last = input.next();            
               
               double[] avgNums = new double[3];//we only ever expect 3
               for(int i = 0; i < 3; i++)//stores our 3 nums in memory, so we can perform operations on them
               {
                  avgNums[i] = input.nextDouble();
               }
               double ans = (avgNums[0] + avgNums[1] + avgNums[2])/3;
               //Handles the avg
               //We could have also sum each of them up as we went along
               System.out.print(first + " " + last + ",");
               System.out.println(" Average: " + ans);
            }
            
            input.close();//REM: needed to close the file were reading from
            
         }
         catch(FileNotFoundException e)
         {
            System.out.println("File, where art thou?");
         }
         
    
    }
}