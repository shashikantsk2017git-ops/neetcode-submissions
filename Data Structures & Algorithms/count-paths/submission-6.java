class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePath(m-1, n-1);
    }

    public int uniquePath(int m, int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        for(int i = 1; i <=m ; i++) {
            dp[0] =1;
            for(int j=1; j<=n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n];
    }
}