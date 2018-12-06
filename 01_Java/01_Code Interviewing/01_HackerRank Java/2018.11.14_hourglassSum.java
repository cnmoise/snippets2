public class hourglassSum {

    public static void main(String[] args)
    {
        int[][] arr = {{1, 1, 1, 0, 0, 0},
                       {0, 1, 0, 0, 0, 0},
                       {1, 1, 1, 0, 0, 0},
                       {0, 9, 2, -4, -4, 0},
                       {0, 0, 0, -2, 0, 0},
                       {0, 0, -1, -2, -4, 0}};

        System.out.println("Final max: " + hourglassSum(arr));
    }

   static int hourglassSum(int[][] arr) {
        int sum = arr[0][0] + arr[0][1] + arr[0][2]
                            + arr[1][1] +
                arr[2][0] + arr[2][1] + arr[2][2];
        int curmax = sum;
        for (int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]+
                                + arr[i+1][j+1] +
                    arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if(sum > curmax){
                    curmax = sum;
                }
                System.out.printf("run:\n |%d|%d|%d|\n---|%d|---\n|%d|%d|%d|\n", arr[i][j] , arr[i][j+1] , arr[i][j+2]
                              ,arr[i+1][j+1],
                arr[i+2][j], arr[i+2][j+1], arr[i+2][j+2]);
                System.out.println("sum: " + sum);
                System.out.println("curmax: " + curmax);
            }
        }
        
        return curmax;
    }

}


