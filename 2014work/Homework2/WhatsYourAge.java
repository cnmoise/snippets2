//Author: Claudiu Moise
//This is a program that asks the user for their age, 
//the user enters in a number and the console prints 
//out a string and a number

import java.util.Scanner;

public class WhatsYourAge
{
   public static void main(String[] args)
   {
   int age;
   Scanner keyboard = new Scanner(System.in);
   
   System.out.print("What is your age in years? ");
   age = keyboard.nextInt();
   System.out.println("Your age is " + age);
   }
}