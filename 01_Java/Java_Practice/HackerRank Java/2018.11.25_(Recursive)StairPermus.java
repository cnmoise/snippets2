// Complete the stepPerms function below.

//https://www.hackerrank.com/challenges/ctci-recursive-staircase
    static int stepPerms(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return stepPermsRec(n, memo);
    }

    static int stepPermsRec(int n, int[] memo) {
        if(n<0){return 0;}
        else if(n==0){return 1;}
        else if(memo[n]>-1){
            return memo[n];
        }
        else{
            memo[n]= stepPermsRec(n-1, memo) + stepPermsRec(n-2, memo)+ stepPermsRec(n-3, memo);
            return memo[n];
        }

    }

    //Alternate solution using hashmap
    private static Map<Integer, Integer> map = new HashMap<>();

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    for(int a0 = 0; a0 < s; a0++){
        int n = in.nextInt();

        System.out.println(climb(n));
    }
}

private static int climb(int n) {
    if(n < 0)
        return 0;

    if(n == 0)
        return 1;

    if(!map.containsKey(n)) {
        int count = climb(n-1) + climb(n-2) + climb(n-3);
        map.put(n, count);
    }
    return map.get(n);
}