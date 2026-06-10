class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);
        // return climb(n);
        // return climbDP(n, dp);
        return climbLoop(n, dp);
    }

    public int climb(int n) {
        if(n == 0 || n == 1) return 1;
        if(n < 0) return -1;
        return climb(n-1) + climb(n-2);
    }

    public int climbDP(int n, int[] dp) {
        if(n == 0 || n == 1) dp[n] = 1;
        if(dp[n] == -1)
            dp[n] = climbDP(n-1, dp) + climbDP(n-2, dp);
        return dp[n];    
    }

    public int climbLoop(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
