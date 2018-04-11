//Author: Claudiu Moise || Homework 4 || Problem 3
//This is a CLASS, therefore THERE IS NO MAIN METHOD, this class is referenced in the TEST.java program

public class PerformanceSeating
{
	private char[][] seats;
   private int i;
   //REM: how to declare a 2D array
   //REM: be mindful of the array type you are creating

	public PerformanceSeating(int x, int y) //no-arg cst
   {
   	seats = new char[x][y];//creates a 2d array as specified
      
      for (int r = 0; r < this.seats.length; r++)//itterates through the rows
      {
         for (int c = 0; c < this.seats[0].length; c++)//itterates through the cols
         {
            seats[r][c] = 'A';
         }
      }
	}

   public int findBookedSeats()
   {
     i = 0;
     
     for (int r = 0; r < this.seats.length; r++)//itterates through the rows
     {  
         for (int c = 0; c < this.seats[0].length; c++)//itterates through the cols
         {
            if (seats[r][c] == 'X')//
            {
               i++;
            }
         }
     }
     return i;
   }
  
   public int findAvailableSeats()
   {
      i = 0;
     
     for (int r = 0; r < this.seats.length; r++)//itterates through the rows
     {  
         for (int c = 0; c < this.seats[0].length; c++)//itterates through the cols
         {
            if (seats[r][c] == 'A')//checks if available 1st
            {
               i++;
            }
         }
     }
     return i;
   }
   
   public void bookSeats(int x)
   {
     i = 0;
     //could have used a while loop up here
     for (int r = 0; r < this.seats.length; r++)//itterates through the rows
     { 
         if (i >= x)//breaks out of the loop 
           break;
           
         for (int c = 0; c < this.seats[0].length; c++)//itterates through the cols
         {
            if (seats[r][c] == 'A')//checks if available 1st
            {
               seats[r][c] = 'X';
               i++;
            }
         }
     }  
   }
   
   public void cancelSeat(int x, int y)
   {
       seats[x][y] = 'A';
   }
   
   public void printSeats()
   {
      
      for (int r = 0; r < this.seats.length; r++)//itterates through the rows //Rem, declare your variables
      {
         for (int c = 0; c < this.seats[0].length; c++)//itterates through the cols
         {
            System.out.print(seats[r][c] + " ");//Prints out each value at each index
         }
         
         System.out.println();
      }       
   }
   
}