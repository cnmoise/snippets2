
// https://www.hackerrank.com/challenges/pairs/
// https://www.hackerrank.com/challenges/pairs/topics/two-pointer-technique

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int pairs = 0;
        int j = 1;
        int i = 0;
        //alternative naive solution

        // for(int i = 0; i< arr.length; i++){
        //     for(int j = arr.length-1; arr[j]-arr[i] >= k && j>0; j--){
        //          if(arr[j]-arr[i] == k){
        //             pairs++;
        //         }
        //     }
        // }
        // return pairs;
        
        //TWO POINTERS METHOD
        //interesting way of avoiding having to do a nested for
        //much fewer itterations
        while(j< arr.length){
            //when sorted j is always larger than i
            int diff = arr[j] - arr[i];

            if(diff == k){
                pairs++;
                j++;
            }
            //manipulate indexes so we're always dealing with relevant numbers
            else if (diff > k){
                i++;
            }
            else if (diff < k){
                j++;
            }
        }
        return pairs;

    }