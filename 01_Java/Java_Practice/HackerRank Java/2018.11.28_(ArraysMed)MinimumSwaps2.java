// Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        int temp;

        for(int i=0; i<arr.length; i++){
            while(arr[i]!=i+1){
                //calculates where the index is supposed to be
                //Very Clever
                int swapInd = arr[i]-1;
                
                temp = arr[i];
                arr[i] = arr[swapInd];
                arr[swapInd] = temp;
                swaps++;
            }
        }

        return swaps;
    }