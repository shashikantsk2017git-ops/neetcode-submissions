class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePath(m, n);
    }

    public int uniquePath(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[m][n] = 1;
        for(int i = m; i >=0; i--) {
            for(int j = n;j >=0; j--) {
                int fill = -1;
                if(i== m || j == n) {
                    fill = 0;
                }
                else if(i == m-1 && j == n-1) {
                    fill = 1;
                } else {
                    fill = dp[i+1][j]+ dp[i][j+1];
                }
                dp[i][j] = fill;
            }
        }
        return dp[0][0];
    }
}
