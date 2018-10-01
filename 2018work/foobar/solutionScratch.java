//Author: Claudiu Moise
//
/* 
Gearing Up for Destruction
==========================

   As Commander Lambda's personal assistant, you've been assigned the task of configuring the LAMBCHOP doomsday device's axial orientation gears.
   It should be pretty simple - just add gears to create the appropriate rotation ratio. But the problem is, due to the layout of the LAMBCHOP
   and the complicated system of beams and pipes supporting it, the pegs that will support the gears are fixed in place.
   
   The LAMBCHOP's engineers have given you lists identifying the placement of groups of pegs along various support beams.
   You need to place a gear on each peg (otherwise the gears will collide with unoccupied pegs).
   The engineers have plenty of gears in all different sizes stocked up, so you can choose gears of any size,
   from a radius of 1 on up.
   
   // =====
   Your goal is to build a system where the last gear rotates at twice the rate (in revolutions per minute, or rpm)
   of the first gear, no matter the direction. Each gear (except the last) touches and turns the gear on the next peg to the right.
   // =====
   
   Given a list of distinct positive integers named pegs representing the location of each peg along the
   support beam, write a function answer(pegs) which, if there is a solution,
   =====
   returns a list of two positive integers a and b representing the numerator and denominator of the first gear's radius in its simplest
   form in order to achieve the goal above, such that radius = a/b.
   
   The ratio a/b should be greater than or equal to 1. Not all support configurations will necessarily be
   capable of creating the proper rotation ratio, so if the task is impossible, the function answer(pegs) should return the list [-1, -1].

   For example, if the pegs are placed at [4, 30, 50], then the first gear could have a radius of 12,
   the second gear could have a radius of 14, and the last one a radius of 6. Thus, the last gear would
   rotate twice as fast as the first one. In this case, pegs would be [4, 30, 50] and answer(pegs) should return [12, 1].

   The list pegs will be given sorted in ascending order and will contain at least 2 and no more than 20 distinct positive
   integers, all between 1 and 10000 inclusive. 

*/

import java.util.*;

public class solutionScratch
{
	public static void main(String[] args)
	{
      int[] pegs = {4, 30, 50};
      int[] pegs2 = {12, 54, 84, 108};
            
      System.out.println("Cog Ratio " + answer(pegs2));
   }
      
public static int[] answer(int[] pegs){
      int[] pegdist = new int [pegs.length];
      //rows = gears position on the beam
      //colums = possible radii
      int[][] gears = new int [pegs.length][];
      
      //negligible for O() time
      for(int i= 0; i+1 < pegs.length; i++){
         pegdist[i] = pegs[i+1] - pegs[i];
         gears[i] = new int[pegdist[i]];
         System.out.println("pegdist[i] " + pegdist[i]);
         System.out.println("gears[i].length " + gears[i].length);
      }
      
            
      for(int j= 0; j+1 < gears.length; j++){
         
         //initializes our cogs with potential radii
         if (j % 2 == 0){
               System.out.println("Even j " + j);
               gears[j] = pegdist[j]-1;
               gears[j+1] = pegdist[j]-gears[j];
               
               System.out.println("gears[j] " + gears[j]);
               System.out.println("gears[j+1] " + gears[j+1]);
               System.out.println("===== Starting Iteration =====");
               
               for(int k = 1; k+1 < pegdist[j];k++){  
                  gears[j] = gears[j]-1;
                  gears[j+1] = gears[j+1]+1;
                  
                  System.out.println("k " + k);
                  System.out.println("gears[j] " + gears[j]);
                  System.out.println("gears[j+1] " + gears[j+1]);
               }
            }
            else{
               System.out.println("Can't even j " + j);
               gears[j] = pegdist[j-1]-gears[j-1];
               gears[j+1] = pegdist[j]-gears[j];
            }
      
      
          
      }      
      
      return pegdist;
   }
}