// https://www.hackerrank.com/challenges/ctci-fibonacci-numbers

public static int fibonacci(int n) {
        // Complete the function.
       int[] memo = new int[n+1];
       return fib(n, memo);
    }
    public static int fib(int i, int[] memo){
        //fibonacci base cases
        if(i==0||i==1){
            return i;
        }
        //MEMOIZATION TECH
        //if this is the first time its been calculated, store the result
        if(memo[i]==0){
            memo[i]=fib(i-1, memo) + fib(i-2,memo);
        }
        return memo[i];
        }