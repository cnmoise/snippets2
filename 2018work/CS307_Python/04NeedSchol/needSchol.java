import java.math.BigDecimal;
import java.util.Scanner;

public class needSchol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String studentName = "Bob Saget";
         int familySize = 4;
			double lowestFamilyIncome = 4.0;
			double familyIncome = 20000;
         double economicNeedRatio = 0.0;
         double economicNeedScore = 0.0;
			
			double[] familyIncomeCutoff = new double[] {20, 36000, 48000, 60000, 73000, 86000,
                        100000, 114000, 128000, 142000, 156000,
                        170000, 184000, 0, 0, 0,
                        0, 0, 0, 0, 0};
			
       			
         Scanner kb = new Scanner(System.in);
		
   		System.out.println("Please enter the students name:");
   		studentName = kb.nextLine();
         System.out.println("Please enter the students family size (a number between 1 and 20): ");
   		familySize = kb.nextInt();
         System.out.println("Please enter the students family income: ");
   		familyIncome = kb.nextDouble();


         if(familySize>12){
            familyIncomeCutoff[familySize] = familyIncomeCutoff[12] + ((familySize - 12 ) * 14000);
            }
         if(familyIncome > familyIncomeCutoff[familySize]){
          System.out.println("Student's Family Income exceeds Cutoff Family Income");
          System.exit(1);
          }
          
          
          economicNeedRatio = (familyIncomeCutoff[familySize] - familyIncome) / (familyIncomeCutoff[familySize] - lowestFamilyIncome);
          economicNeedScore =  economicNeedRatio*8;
       
          if (economicNeedScore < Math.round(economicNeedScore) + 0.5){
             System.out.println("Score for Economic Need:" + Math.round(economicNeedScore)+1);
             }
     		}
		

	public static float round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    //serves to round to the nearest decimal neighbor
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd.floatValue();
}

}
