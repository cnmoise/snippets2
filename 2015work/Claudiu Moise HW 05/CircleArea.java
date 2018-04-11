//Author: Claudiu Moise || Homework 5 || Problem 3
//simply finds the area of a circle
//but increases the precision by making everything be BigDecimal Objects
//Q: Just how much of BigInteger and BigDecimal do I have to know

import java.math.*;//REM: import your libraries

public class CircleArea
{
   public static BigDecimal findArea(double r)
   {
      BigDecimal radius = new BigDecimal(r);
      BigDecimal area = new BigDecimal(0.0);
      BigDecimal piVal = new BigDecimal(3.14159);
      //All doubles must be converted into objects
      //BigDecimals has 3 constants
      //.ONE .TEN .ZERO
      //predone calculations
      //used to overcome integer overflow
      
      area = piVal.multiply(radius.pow(2));//REM:Order of operations is just as important
      
      return area;
   }
}