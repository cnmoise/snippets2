import java.util.HashSet;
import java.util.Set;

public class SockMerchant
{
    // Author: Claudiu Moise
    // Source:https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
    

    public static void main(String[] args)
    {
        int[] test = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(9, test));
    }

   public static int sockMerchant(int n, int[] ar) {
    Set<Integer> colors = new HashSet<>();
    int pairs = 0;

    for (int i = 0; i < n; i++) {
        if (!colors.contains(ar[i])) {
            colors.add(ar[i]);
        } else {
            pairs++;
            colors.remove(ar[i]);
        }
    }

    System.out.println(pairs);
    return pairs;
        
    }

}

