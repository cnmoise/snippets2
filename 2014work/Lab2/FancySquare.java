//Authors: Claudiu Moise, Joana Velazquez, Fraz Shaik

import java.util.Scanner;

public class FancySquare
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      int size;
      System.out.print("Please enter an odd, positive integer for the square size: ");
      size = keyboard.nextInt();
      
      while( size % 2 == 0 || size < 0)
      {
         if(size % 2 == 0 && size < 0)
         {
         System.out.println(size + " is not odd");
         System.out.println(size + " is not positive");
         
         System.out.print("Please enter an odd, positive integer for the square size: ");
         size = keyboard.nextInt();
         }      
         else if(size % 2 == 0)
         {
         System.out.println(size + " is not odd");
         
         System.out.print("Please enter an odd, positive integer for the square size: ");
         size = keyboard.nextInt();
         }
         else 
         {
         System.out.println(size + " is not positive");
         
         System.out.print("Please enter an odd, positive integer for the square size: ");
         size = keyboard.nextInt();
         }
         }
         
         if (size % 2 == 1 && size > 0)
         {
            for(int row = 1; row <= size; row++ )
            {
               for(int col = 1; col <= size; col++)
               {
                   if (row == 1 || row == size )
                  {
                     
                     if (col != row && row != col && col != (size - row + 1))
                     {
                        
                        if (col != (size/2 +1))
                           System.out.print(" x ");
                        
                     }
                  
                     else 
                        System.out.print(" A ");
                   }
                   if ((col == 1 || col == size) && (row > 1 && row < size))
                   {
                    
                     if ((col == 1 && row != (size/2 + 1))  || (col == size && row != (size/2 + 1)))
                           System.out.print(" o ");
                     
                   }  
                   if (row == (size/2 +1)&& col != (size/2 +1) )
                     System.out.print(" - ");
                     
                   if (col == (size/2 + 1) && row != (size/2 + 1))
                     System.out.print(" | ");
                   
                   if (row == (size/2 +1)&&col == (size/2 + 1))
                     System.out.print(" @ ");
                     
                   if (col > 1  && col < size)
                   {
                     if(row > 1 && row < size) 
                     {
                        if(row != (size/2 +1) && col!= (size/2 + 1) )
                        {
                           if (col == row || col == (size - row + 1))
                              System.out.print(" x ");
                           
                           else 
                              System.out.print(" o ");
                        }
                      }  
                   }     
                 }
                 System.out.println("");
                 System.out.println();
                     
                     
               }
            
               
              }
             
              
               
                                           
           
         
       }
   }
      
 

