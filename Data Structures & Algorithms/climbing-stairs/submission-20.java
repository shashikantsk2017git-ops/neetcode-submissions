class Solution {
    public int climbStairs(int n) {
        // return climb(n);
        
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return climb(n, dp);

        // return climbloop(n, dp);

        return climbloop(n);
    }

    public int climb(int n) {
        if ( n < 0) return 0;
        if( n == 1 || n == 0 ) return 1;

        int one = climb(n-1);
        int two = climb(n-2);

        return one + two;
    }

    public int climb(int n, int[] dp) {
        if ( n < 0) return 0;
        if( n == 1 || n == 0 ) return 1;

        if(dp[n] != -1) return dp[n];
        int one = climb(n-1);
        int two = climb(n-2);

        return dp[n] = one + two;
    }

    public int climbloop(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int climbloop(int n) {
        int prev1 = 1;
        int prev2 = 1;

        for(int i = 2; i <= n; i++) {
            int temp = prev1 + prev2;
            prev2 = prev1;
            prev1 = temp;
        }

        return prev1;
    }
    
}
