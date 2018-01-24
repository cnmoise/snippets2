/**
 * Created by Claudiu on 5/11/2016.
 */
import BubbleSort.SortArray;
import java.util.Scanner;


public class Console
{
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int i_howMany = keyboard.nextInt();


        int[] arr = createArray(i_howMany);


        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        long startTime = System.nanoTime();
        SortArray.sortLowToHigh(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;

        System.out.println("The time it took to run the program: " + duration + " milliseconds");


        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }


    }

    public static int[] createArray(int p_howMany)
    {
        int[] result = new int[p_howMany];

        for(int i = 0; i < p_howMany;i++)
        {
            result[i] = (int)(Math.random()*9 + 1);
        }
        return result;
    }
}
