//Author: Claudiu Moise || Research Lab 3 (HW 10) || Problem 1
//An introduction to encryption

//each char is represented as a binary number
//Q is 01010001
//4 is 00110100
//plugging both of these into XOR gives us...
//XOR  01100101 (e)

//the XOR operator will modify our 0 & 1 values
//following the same patern we see below
//remember that 0 = false, 1 = true

//Now observe this truth table
/*
|    A    |    B    |   XOR    |
--------------------------------
| True(1) | True(1) | False(0) |
--------------------------------
| True(1) | False(0) | True(1) |
--------------------------------
| False(0) | True(1) | True(1) |
--------------------------------
| False(0) | False(0) | False(0) |
*/
//the reason this type of encryption works is because it is
//mathematically impossible to reverse the operation, 
//without knowing the initial values in the problem
//by giving other ppl your algorithm, they can decrypt your messages


import java.io.*;
import java.util.*;

public class XOREncryption
{
   public static void main(String[] args)
   {
      File df = new File("data_encrypt.txt");//rem how to make file objs
      File kf = new File("key.txt");
      
      try
      {
      FileInputStream inputDF = new FileInputStream(df);//think of this as a more advanced form of scanner
      FileInputStream inputKF = new FileInputStream(kf);
      
      byte[] byDF = new byte[(int)df.length()];//rem, use new OBJNAME //When making a new obj, bc array are objs
      byte[] byKF = new byte[(int)kf.length()];//we cast the .length as an int to tell the array how many spaces we've got in our array
      //here were making 2 byte arrays, and setting the length to be the length of the files

      int iDF = inputDF.read(byDF);//edits the value of byDF directly, bc its an array
      int iKF = inputKF.read(byKF);//this also creates an int but we're not using that
      //the int returned represents the # of bytes read, returns 0 if no bytes are read
      //only stops at the end of the file
      //The above code reads from our file
      
      for(int count = 0; count < iDF; count++)
      {
         int KArrIndex = count % iKF;//why are we doing this? //so we can apply multiple keys
         int temp = (int)byDF[count]^(int)byKF[KArrIndex];//Encrypts the byte
         byDF[count] = (byte)temp;//Ask
         //Assigns the encrypted byte back to the byte array
         //^ is the XOR operator
      }
      
      FileOutputStream output = new FileOutputStream("data_decrypt.txt");//writes a new txt file for us
      output.write(byDF);
      
      inputDF.close(); 
      inputKF.close(); 
      output.close(); 
      
      }
      //everything needs to be in the same try block, bc the variables can't see eachother outside of the try blocks
      catch(FileNotFoundException e)
      {
         System.out.println("No File");
      }
      catch(IOException e)
      {
         System.out.println("Error reading file.");
      }
            
   }

}