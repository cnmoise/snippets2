// https://www.hackerrank.com/challenges/ctci-bubble-sort/


    static void countSwaps(int[] a) {
        int coswaps=0;
        int temp=0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    // swap(a[j], a[j + 1]);
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    coswaps++;
                }
            }
        }

        System.out.println("Array is sorted in "+ coswaps +" swaps.");
        System.out.println("First Element: "+ a[0]);
        System.out.println("Last Element: "+ a[a.length-1]);

    }

    public static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }