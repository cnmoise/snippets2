//Author: Claudiu Moise
//Source: https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/

//Google Interview Prep Series

import java.util.HashSet;

public class HashsetPermutations
{
    public static void main(String[] args)
    {
        int[] a = new int[101];

        for(int i =0; i<101;i++){

            a[i]=i;
        }

        // Creating an empty HashSet
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i =1; i< a.length;i++){
              set.add(i);
        }


        // Displaying the HashSet
        System.out.println("HashSet: " + set);

        for(int i =1; i<5;i++){
            System.out.println("Set contains " + i + "? : " + set.contains(i));
        }

//        HashSet<Integer> set = new HashSet<>();
//
//        for(int i =0; i< A.length;i++){
//            set.add(A[i]);
//        }
//
//        // System.out.println("HashSet: " + set);
//
//        for(int i=1; i <= A.length; i++){
//            if(!set.contains(i)){
//                return 0;
//            }
//        }
//        return 1;
    }
}