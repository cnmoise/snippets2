import java.math.BigDecimal;
import java.util.Scanner;

public class AvgCalc2 {

	public static void main(String[] args) {
		   String studentName = "Bob Saget";
			double ColGPA = 4.0;
			double HighGPA = 4.0;
			boolean weighted = false;
         boolean flag = true;
		   String kbw = "x";

			
			//first 14 values are filled with junk numbers
			double[] RightEnd = new double[] {10,20,30,40,50,
											60,71,80,90,91,
											60,71,80,90,90,
											3.51,3.54,3.58,3.61,3.64,
											3.68,3.71,3.74,3.78,3.81,
											3.84,3.88,3.91,3.94,3.98,4.0};
			
         //static example
// 			double RoundedGPA = (double)calculateRoundedGPA(ColGPA, HighGPA, weighted);
// 			System.out.println("Student Name: " + studentName);
//          System.out.println("RoundedGPA: " + RoundedGPA);
// 			System.out.println("Score for Academic Record: " + calcAcademicRecord(RoundedGPA));
			
         Scanner kb = new Scanner(System.in);
		
   		System.out.println("Please enter the students name:");
   		studentName = kb.nextLine();		
   		System.out.println("Please enter the students College GPA:");
   		ColGPA = kb.nextDouble();		
   		System.out.println("Please enter the students High School GPA:");
   		HighGPA = kb.nextDouble();
   		kbw = kb.nextLine();
   		
   		System.out.println("Is the High School GPA weighted? y/n:");
   		kbw = kb.next();
   		
   		//we need the .equals method to handle strings
   		if(kbw.equals("y")) {
   			weighted = true;
   		}
   		else if(kbw.equals("n")) {
   			weighted = false;
   		}
   		else {
   			System.out.println("Invalid entry... Assuming GPA is unweighted");
   		}
   			
   		System.out.println("Returning Output...");
         
         double RoundedGPA = (double)calculateRoundedGPA(ColGPA, HighGPA, weighted);
         System.out.println("Student Name: " + studentName);
         System.out.println("RoundedGPA: " + RoundedGPA);
         
         for (int i=15; i<= 30 && flag; i++) {
				if(RoundedGPA <= RightEnd[i]) {
					System.out.println("Compared to: " + RightEnd[i]);
               System.out.println("Score for Academic Record: " + i);
               flag = false;
               }
         }

     		}
		

	public static float round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    //serves to round to the nearest decimal neighbor
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd.floatValue();
}

	public static float calculateRoundedGPA(double ColGPA, double HighGPA, boolean weighted) {
		float RoundedGPA = 0.0f;
		
		if(weighted) {
			RoundedGPA= round((((float)Math.min(4, HighGPA) + (float)((2*ColGPA))))/3,2);
		}
		else
		{
			float temp = (float)(HighGPA + ColGPA)/2;
			RoundedGPA = round(temp, 2);	
		}	
		
		return RoundedGPA;
	}
  
}
