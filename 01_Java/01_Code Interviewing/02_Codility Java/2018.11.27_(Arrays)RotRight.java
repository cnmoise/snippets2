//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        
        int[] rotA = new int[A.length];
        int j = K;
        int i = 0;
        
        while(i< K){
            rotA[j%rotA.length] = A[i%A.length];
            j++;
            i++;
        }
        //finish rotating the array, add in any remaining values that didn't get added
        while(i< A.length){
            rotA[j%rotA.length] = A[i%A.length];
            j++;
            i++;
        }
        
        return rotA;
    }
}