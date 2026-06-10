class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);
        return climbOpt(n);
    }

    public int climb(int n, int[] dp) {
        if(n == 1 || n == 0) return 1;
        if(n < 0) return 0;
        if(dp[n] == -1)
            dp[n] = climb(n-1, dp) + climb(n-2, dp);
        return dp[n];    
    }

    public int climbloop(int n, int[] dp) {
        dp[0] =1;
        dp[1] =1;
        for(int i = 2; i<= n; i++) {
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];    
    }

    public int climbOpt(int n) {
        int prev1 = 1;
        int prev2 = 1;

        for(int i = 2; i<=n;i++) {
            int temp = prev1 + prev2;
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }
}
