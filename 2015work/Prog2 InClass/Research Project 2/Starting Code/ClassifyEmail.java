import java.io.*;
import java.util.*;

public class ClassifyEmail
{
	public static void main(String[] args)
	{
		
		Word[] wordList = new Word[33];
		readFromFile(wordList);
		
        // Create the three string variables here.
        String s1 = "Take advantage of the LOWEST rates";
        String s2 = "Important News About Your Bank Account";
        String s3 = "Reproducing forwarding queries";
        
        // Split the string variables on spaces and save the result to arrays.
        String[] sa1 = s1.split(" ");//Rem: Format of dec.
        String[] sa2 = s2.split(" ");
        String[] sa3 = s3.split(" ");

        // Call the modifyStringArray method for each of your string arrays here:
        modifyStringArray(sa1);
        modifyStringArray(sa2);
        modifyStringArray(sa3);

        
        // Call the findSpamProbs and findNotSpamProbs methods for each of your String
        // arrays and assign the results to double variables.
        findSpamProbs(sa1, wordList);
        //repeat
        
        // Call the printClassification method for your results to print out the 
        // classification of each email.
        
	}
	
	public static void printClassification(double sp, double nsp, String str)
	{
		System.out.println("Spam probability: " + sp * 100);
		System.out.println("Not spam probability: " + nsp * 100);
		if (sp > nsp)
        	System.out.println(str + " : " + "SPAM ");
        else
        	System.out.println(str + " : " + "NOT SPAM");
        System.out.println();
	}
	
	public static double findSpamProbs(String[] strArray, Word[] wordList)
	{
		double spamProbs = 1.0;
		
		// Complete the method. For every element in your string array, check to see if
		// it is in the wordList array. You will need to use the getWord() method
		// from the Word.java class. If it is in the array, multiply the spamProbs
		// variable by the spam probability (using the findSpamProb() method) and 
		// reassign the value to the spamProbs variable.
      
      double number = 1.0;
      
      for(int i = 0; i < strArray.length; i++)
      {
         for(int j = 0; j < wordList.length; j++)//need a nested loop, one to check in
         {
            Word w1 = wordList[j];
            String sss = w1.getWord();
            if(sss.equals(strArray[i]))
               number *= w1.findSpamProb();                              
         }
      }
  
        return spamProbs;
	}
	
	public static double findNotSpamProbs(String[] strArray, Word[] wordList)
	{
		double notSpamProbs = 1.0;
		
		// Complete the method. For every element in your string array, check to see if
		// it is in the wordList array. You will need to use the getWord() method
		// from the Word.java class. If it is in the array, multiply the notSpamProbs
		// variable by the not spam probability (using the findSpamProb() method) and
		// reassign the value to the notSpamProbs variable.
      double number = 1.0;
      
      for(int i = 0; i < strArray.length; i++)
      {
         for(int j = 0; j < wordList.length; j++)
         {
            Word w1 = wordList[j];
            String sss = w1.getWord();
            if(sss.equals(strArray[i]))
               number *= w1.findNotSpamProb();                              
         }
      }
      	
        
        return notSpamProbs;
	}
	
	public static void modifyStringArray(String[] strArray)
	{
		// Change each string element in the string array to be completely lower case.
      for(int i = 0; i < strArray.length; i++)
      {
         strArray[i] = strArray[i].toLowerCase();
      }
	}
	
	public static void readFromFile(Word[] wordList)
	{
		String fileName = "word_list.txt";
		String line = null;
	
		try 
		{
        	FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                String[] broken_line = line.split(",");
                wordList[i] = new Word(broken_line[0], Integer.parseInt(broken_line[1]), Integer.parseInt(broken_line[2]));
                i++;
            }

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) 
        {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
	}
}