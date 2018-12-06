//https://www.hackerrank.com/challenges/new-year-chaos

static void minimumBribes(int[] q) {
        int ans = 0;
        for (int i = q.length-1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            //count the bribes
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }
        System.out.println(ans);     