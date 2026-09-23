class Solution {
    public int climbStairs(int n) {
        // return countWays(n);   
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        // return countWays(n, dp);
        return countWaysLoop(n);
    }

    private int countWays(int n) {
        if(n <= 0) {
            if(n == 0) return 1;
            return 0;
        }
        //one
        int one = countWays(n-1);
        //tow
        int two = countWays(n-2);
        return one+two;
    }

    private int countWays(int n, int[] dp) {
        if(n <= 0) {
            return n == 0 ?  1 : 0;
        }
        if(dp[n] != -1) return dp[n];
        //one
        int one = countWays(n-1);
        //tow
        int two = countWays(n-2);
        return dp[n] = one+two;
    }

    private int countWaysLoop(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            //one
            int one = dp[i-1];
            //tow
            int two = dp[i-2];
            dp[i] = one + two;
        }
        return dp[n];
    }
}
