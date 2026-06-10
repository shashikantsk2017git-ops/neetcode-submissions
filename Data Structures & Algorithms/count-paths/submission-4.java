class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePath(m-1, n-1, dp);
    }

    public int uniquePath(int m, int n, int[][] dp) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];
        int down = uniquePath(m-1, n, dp);
        int right = uniquePath(m, n-1, dp);
        return dp[m][n] = down + right;
    }
}