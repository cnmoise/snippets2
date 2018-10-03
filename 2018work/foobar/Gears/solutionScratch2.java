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

public class solutionScratch2
{
	public static void main(String[] args)
	{
      int[] pegs = {4, 30, 50};
      int[] pegs2 = {12, 54, 84, 108};
      // int[] pegs3 = {12, 54, 83, 95};
//       int[] pegs4 = {12, 54, 83, 96};
      int[] pegs5 = {12, 54, 84, 106};
      int[] pegs6 = {12, 54, 84, 107};
      int[] pegs7 = {12, 54, 84, 108};
      
      int[] ans = answer(pegs5);
      System.out.println("Cog Ratio pegs5 " + ans[0] + ", " + ans[1]);
      int[] ans1 = answer(pegs6);
      System.out.println("Cog Ratio pegs6 " + ans1[0] + ", " + ans1[1]);
      int[] ans2 = answer(pegs7);
      System.out.println("Cog Ratio pegs7 " + ans2[0] + ", " + ans2[1]);
      
      //starting from the next index over to ensure int gen will always be larger (thus farther on the pole) than previous peg 
      for(int i = 0; i < 13; i++){
         for(int j = i; j < 55; j++){
            for(int k = j; k < 85; k++){
               int[] testarr = {i, j, k};
               System.out.println("["+ i + ", "+ j + ", "+ k +"]");
               int[] a = answer(testarr);
               if(a[0] != -1 && a[1] != -1){
                  System.out.println("[" + a[0] + ", " + a[1]+ "]");
                  }
            }
         }
      }
   }
      
   public static int[] answer(int[] pegs){
      int pegLength = pegs.length;
      boolean even = false;
      int sum = -1;
      
      int FirstGearRad = -1;
      int[] spoof = {-1,-1};
      
      int pegCenter = -1;
      int nRad = -1;
      
      if (pegs == null || pegLength == 1){
         return spoof;
      }
      
      if (pegLength % 2 == 0){
         even = true;
      }
      
      if(even){
         sum = (- pegs[0] + pegs[pegLength -1]);
      }
      else{
         sum = (- pegs[0] - pegs[pegLength - 1]);
      }
      
      if (pegLength > 2){
         for(int i = 1; i < pegLength-1; i++){
            sum += 2 * Math.pow(-1, i+1) * pegs[i];
            //sum += 2 * Math.pow(i+1,-1) * pegs[i];
         }
      }
      
      //mathematically only 2 denominators possible
      if(even){
         FirstGearRad = 2*sum;
         if(FirstGearRad % 3 == 0){
            FirstGearRad=FirstGearRad/3;
            spoof[0] = FirstGearRad;
            spoof[1] = 1;
         }
         else{
            spoof[0] = FirstGearRad;
            spoof[1] = 3;
         }
         //             /3
         
         }
      else{
         FirstGearRad = 2*sum;
         
         spoof[0] = FirstGearRad;
         spoof[1] = 1;
         }
         
      int curRad = FirstGearRad;
      
      
      for(int i =0; i< pegLength-2; i++){
         pegCenter = pegs[i+1] - pegs[i];
         nRad = pegCenter - curRad;
         if (curRad < 1 || nRad < 1){
            return spoof;
         }
         else{
            curRad = nRad;
         }
      }
      
      //mathematically only 2 denominators possible
      if (even){
         // spoof[0] = FirstGearRad;
//          spoof[1] = 3;
         return spoof;
      }
      else{
         // spoof[0] = FirstGearRad;
//          spoof[1] = 1;
         return spoof;
         }
      
   }
}

