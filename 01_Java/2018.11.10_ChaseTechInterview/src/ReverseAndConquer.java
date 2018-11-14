
public class ReverseAndConquer {
    public static void main(String[] args){
        int num = 195;

        reverseAndSum(num, 0);
    }

    public static void reverseAndSum(int start, int iter){
        int temp = start;
        String sStr = Integer.toString(start);

        //could have used a mathematical approach
        /* Such as
        * int number; // = some int

            while (number > 0) {
                print( number % 10);
                number = number / 10;
            }
        * */
        char[] inter = sStr.toCharArray();
        char[] result = new char[inter.length];
        int rebuildNum = 0;
        int j = 0;

        for(int i=inter.length-1; i >= 0; i--){
            result[j] = inter[i];
            System.out.println(result[j]);
            j++;
        }

        //rebuilds the number from the array
        int q = 0;
        for(int k = result.length-1; k >= 0; k--){
            int kval = Character.getNumericValue(result[k]);
            rebuildNum += kval * Math.pow(10, q);
            q++;
        }
        System.out.println(rebuildNum);

        temp = rebuildNum + temp;
        String check = Integer.toString(temp);

        System.out.println(temp);

        //L: For recursion using a flag approach might be useful
        boolean hasEvenDigit = false;
        for(int z = 0; z < check.length(); z++){
            if(check.charAt(z)%2 == 0){
                hasEvenDigit = true;
            }
        }

        //This is the part where I stumbled
        if(hasEvenDigit){
            reverseAndSum(temp, iter+1);
        }
        else{//base case
            System.out.println(iter + " " + temp);
        }

    }

}

