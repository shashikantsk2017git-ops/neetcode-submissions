class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePath(m-1, n-1, dp);
    }

    public int uniquePath(int m, int n, int[][] dp) {
        for(int i=0; i <=m; i++) dp[i][0] = 1;
        for(int j=0; j <=n; j++) dp[0][j] = 1;

        for(int i = 1; i <=m ; i++) {
            for(int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}