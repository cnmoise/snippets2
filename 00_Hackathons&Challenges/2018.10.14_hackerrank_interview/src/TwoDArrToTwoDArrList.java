import java.util.*;

public class TwoDArrToTwoDArrList {
        // Recursive Java implementation of Breadth first search
        public static void main(String[] args) {

            Integer[][] area_arr = {{0, 0, 0, 0, 1, 1, 1, 1},
                    {0, 0, 0, 1, 1, 1, 1, 1},
                    {0, 0, 1, 1, 1, 1, 1, 1},
                    {0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1},
                    {1, 1, 1, 0, 0, 0, 0, 1},
                    {1, 1, 1, 0, 0, 0, 0, 1},
                    {1, 1, 1, 1, 0, 0, 1, 1}};

            List<List<Integer>> area_map = new ArrayList<>();
            List<Integer> temp;

            for(int row=0;row< area_arr.length ;row++) {
                //converts a row of the array into an arrayList
                temp = Arrays.asList(area_arr[row]);
                //adds the entire row
                area_map.add(temp);
            }

            for(int row = 0; row < area_map.size(); row++)
            {
                for(int col = 0; col < area_map.get(row).size(); col++){
                    System.out.print(area_map.get(row).get(col) + ",");
                }
                System.out.println();
            }
        }

}
