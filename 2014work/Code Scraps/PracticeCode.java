public class PracticeCode
{
public static void main(String[] args)
{
System.out.println("This is the beginning of the program!");
int num1, num2, sum;
num1 = 15;
System.out.println("Number 1 is " + num1);
num2 = 2938;
System.out.println("Number 2 is " + num2);
sum = num1 + num2;
System.out.println("The sum is: ");
System.out.println(sum);
System.out.println("Look at this cool trick");
System.out.println("Inside quotes, then a variable, inside quotes, then a variable.");
String herName = "Melinda";
String hisName = "John";
System.out.println("His name is " + hisName + " and her name is " + herName);
System.out.println("If I'm not careful with spaces around the quotes, look what happens:");
System.out.println("His name is" + hisName + "and her name is" + herName);
System.out.println("Once a variable is declared, it can be used anywhere after that.");
num2 = 22;
sum = num1 + num2;
System.out.println("The sum is " + sum);
}
}