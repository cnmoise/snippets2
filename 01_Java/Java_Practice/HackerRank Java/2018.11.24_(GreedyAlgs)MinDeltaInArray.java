//https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem

//sort the array
//minimum abs value exists between the two most closest numbers

static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int mindelta = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length-1;i++){
            int tempdelta = Math.abs(arr[i]-arr[i+1]);

            if(tempdelta < mindelta){
                mindelta = tempdelta;
            }
        }

        return mindelta;

    }