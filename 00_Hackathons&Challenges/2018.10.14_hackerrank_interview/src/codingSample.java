//demo for lin search and binary search
//need to complete

import java.util.*;//to sue toString

public class codingSample
{
    public static void main(String[] args)
    {
        int[] myArray = {10, 20, 5, 3, 17, 14, 21, 18};
        System.out.println("Orig Array" + Arrays.toString(myArray));

//        CUSTOM INPUT
//        System.out.print("Enter a num to search for: ");
//        Scanner in = new Scanner(System.in);
//        int value = in.nextInt();
//        System.out.println("Search result " + binarySearchIter(myArray, value));

        System.out.println("Search result " + binarySearchIter(myArray, 20));


        List<Integer> myList = new ArrayList<>();
        for(int i = 0; i <= 9;i++){
            myList.add(i);
        }

        System.out.println("Search result " + binarySearchIterWLists(myList, 5));
        System.out.println("Search result " + binarySearchIterWLists(myList, 55));



    }

    public static boolean binarySearchIter(int[] numArray, int value)
    {
        int first = 0;
        int last = numArray.length-1;//bounds of our search space

        while(first < last)
        {
            int mid = (first + last)/2;

            //we need to change which elem is our last if we find the number in the first half
            if(value < numArray[mid])
                last = mid - 1;
            else if (value > numArray[mid])//vice versa
                first = mid + 1;
            else
                 return true;
        }
        return false;
    }

    public static String binarySearchIterWLists(List<Integer> arr, int k) {

        int first = arr.get(0);
        int last = arr.get(arr.size()-1);//bounds of our search space

        while(first < last)
        {
            int mid = (first + last)/2;

            //we need to change which elem is our last if we find the number in the first half
            if(k < arr.get(mid))
                last = mid - 1;
            else if (k > arr.get(mid))//vice versa
                first = mid + 1;
            else
                return "YES";
        }
        return "NO";
    }

}