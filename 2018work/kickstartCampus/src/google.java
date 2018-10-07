import java.util.*;
import java.io.*;

public class google {
    public static void main(String[] args) {
//        Small dataset
//1 ≤ N ≤ 50
//1 ≤ Ai ≤ 500, for all i.
//1 ≤ Bi ≤ 500, for all i.
//1 ≤ Ci ≤ 500, for all i.
//1 ≤ P ≤ 50.

//        2 //how many test cases
//        4 //range of cities that the bus covers (in this case 35, inclusive)
//        15 25 30 35 45 50 10 20 //like a road (we visit 15 on the way to 25)
//        2 // # of cities
//        15 //target city
//        25
//
//        10
//        10 15 5 12 40 55 1 10 25 35 45 50 20 28 27 35 15 40 4 5
//        3
//        5
//        10
//        27


//        Output
//
//        Case #1: 2 1
//        Case #2: 3 3 4

//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
//
//        for (int i = 1; i <= t; ++i) {
//            int n = in.nextInt();
//            int m = in.nextInt();
////            operations
//            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
//
//
//        }

        File file = new File("D:\\snippets2\\2018work\\kickstartCampus\\dataset.txt");

        try {
            Scanner sc = new Scanner(file);


//                String st = sc.nextLine();
//                System.out.println(st);

                int testCases = sc.nextInt();
                System.out.println("TestC "+ testCases);

                int busRange = sc.nextInt();
                System.out.println("busRange " +busRange);

                sc.nextLine();
                String temp = sc.nextLine();

                System.out.println("temp " +temp);

//                String[] streetCities = temp.split(" ");
//
//                System.out.print("streetCities[]");
//                for(int i = 0; i < streetCities.length-1; i++){
//                    System.out.print(" "+ streetCities[i]);
//                }


            sc.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }




}
}