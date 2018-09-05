// The test driver for the SortedList class
// Xiwei Wang

import java.io.*;
import java.util.Scanner;

public class TestSortedList
{
    public static void main(String[] args)
    {
        Scanner conIn = new Scanner(System.in);
        SortedList mylist = new SortedList();
        
        /*
        System.out.println("Please enter the number that you want to insert"
                            + " into the list (enter -1 to stop)");
        
        // read in the numbers and insert into the list
        while (true)
        {
            int value = conIn.nextInt();
            if (value != -1)
                mylist.add(value);
            else
                break;
        }
        
        // print out the list
        System.out.println(mylist);
        
        System.out.print("Please enter the number that you want to remove: ");
        int vDelete = conIn.nextInt();
        
        if (mylist.remove(vDelete))
            System.out.println(mylist);
        else
            System.out.println("The number you entered does not exist!");
        
        // write the list content to file
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("SortedList.txt"));
            out.writeObject(mylist);
            out.close();
        }
        catch (Exception e)
        {
            System.out.println("Error occured: " + e.getMessage());
        }
        */
        // read the list content from file
        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("SortedList.txt"));
            mylist = (SortedList) in.readObject();
            System.out.println(mylist);
        }
        catch (Exception e)
        {
            System.out.println("Error occured: " + e.getMessage());
        }        
    }
}
