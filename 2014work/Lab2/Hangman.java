//Authors: Claudiu Moise, Joana Velazquez, Fraz Shaik

import java.util.Scanner;
public class Hangman

{
       public static void main(String[] args)
       {
          Scanner keyboard = new Scanner(System.in);      
          String secretword;
          String wordSoFar = "", newName = "";
          char guess = ' ';
          int secretwordlength;
          int totalLives = 3;
          int count, i = 0;
          boolean isComplete;
          char guess1 = Character.toUpperCase(guess);
          guess1 = guess;
          char confirm = ' ';
          
          System.out.print("Would you like to play integer hangman (y/n)? ");
          String s1= keyboard.nextLine();
          confirm =  s1.charAt(0);

          
          if(confirm == 'y')
          {
             System.out.print("User 1, please enter a word without punctuation: ");
             secretword = keyboard.nextLine();
             secretwordlength = secretword.length();
             
             while(i  < secretwordlength)
               {
               wordSoFar += "_";
               i++;
               }
             
             for(int row = 0 ; row < totalLives ; row ++)
                  {
     
                  System.out.print("Guess a letter (A - Z): ");
                  s1= keyboard.nextLine();
                  guess =  s1.charAt(0);
                  isComplete = (secretword.indexOf(guess)) != -1;
                  
                     if (row == totalLives - 1 && isComplete == false)
                           System.out.println("You lost. Try again. ");
                    
                     if (isComplete == false && row < totalLives - 1 )
                      {
                    
                        System.out.print(Character.toUpperCase(guess) + " was not found. ");
                        
               
                      }     
                   if (isComplete == true)
                   {
                     System.out.println(Character.toUpperCase(guess) + " was found! ");
                     System.out.print("So far you've found: " );
   
                
            
                        for (int col = 0; col < secretwordlength; col++ )//composes the word
                        {
                        
                        if (secretword.charAt(col) == guess) 
                        {
                           newName = wordSoFar.substring(0,col)+guess+wordSoFar.substring(col+1);
                           wordSoFar = newName;
                           
                        }   
                        }//endfor
                     System.out.print(newName.toUpperCase());
                     System.out.println();
                     
                     //end outer for
                     
                                    
                     }
                     if ( isComplete == true && row == totalLives - 1)
                        System.out.print("You won! Congrats!" );

        } 
        }
        if(confirm == 'n')
         System.out.println("Goodbye then!");         
           
   }
}