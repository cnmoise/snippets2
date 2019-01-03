// https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem

//similar to TWOSUM problem in leetcode
// Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //first create a map,
        //using the cost of each ice cream as our key
        //and the index as the value
        //this is important for when we get the complement
        for (int i = 0; i < cost.length-1; i++) {
            map.put(cost[i], i+1);
        }

        //problem specifies array has to start at 1
        for (int i=1; i<map.size(); i++){
            int complement = money - cost[i-1];

            //since our costs are the keys for the hashmap we can find the index of the other flavor and print it
            if(map.containsKey(complement) && map.get(complement) != i){
                System.out.println(i+" "+map.get(complement));
                return;
            }
        }
    }