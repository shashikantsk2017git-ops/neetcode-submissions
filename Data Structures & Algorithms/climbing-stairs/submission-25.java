class Solution {
    public int climbStairs(int n) {
        // return countSteps(0, n);
        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);
        // return countSteps(0, n, dp);
        return countSteps(n);
    }

    public int countSteps(int ind, int n) {

        if(ind >= n) {
            if(ind == n) return 1;
            else return 0;
        }

        int one = countSteps(ind+1, n);
        int two = countSteps(ind+2, n);

        return one+two;
    }

    public int countSteps(int ind, int n, int[] dp) {
        if(ind >= n) {
            if(ind == n) return 1;
            else return 0;
        }
        if(dp[ind] != -1) return dp[ind];

        int one = countSteps(ind+1, n);
        int two = countSteps(ind+2, n);

        return dp[ind] = one+two;
    }

    public int countSteps(int n, int[] dp) {
        dp[n+1] = 0;
        dp[n] = 1;
        for(int i = n-1; i>=0; i--) {
            int one = dp[i+1];
            int two = dp[i+2];
            dp[i] = one + two;
        }
        return dp[0];
    }

    public int countSteps(int n) {
        int prev2 = 0;
        int prev1 = 1;
        for(int i = n-1; i>=0; i--) {
            int one = prev1;
            int two = prev2;
            prev2 = prev1;
            prev1 = one + two;
        }
        return prev1;
    }
}
