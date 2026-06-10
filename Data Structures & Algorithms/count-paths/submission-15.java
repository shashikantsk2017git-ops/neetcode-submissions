class Solution {
    public int uniquePaths(int m, int n) {
        // return countPaths(m-1, n-1);

        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return countPathsLoops(m-1, n-1, dp);
        return countPathOpt(m-1, n-1);
    }

    public int countPaths(int m, int n) {

        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        
        int up = countPaths(m-1, n);
        int left = countPaths(m, n-1);

        return up + left;
    }

    public int countPaths(int m, int n, int[][] dp) {
        if(dp[m][n] != -1) return dp[m][n];

        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        
        int up = countPaths(m-1, n);
        int left = countPaths(m, n-1);

        return dp[m][n] = up + left;
    }

    public int countPathsLoops(int m, int n, int[][] dp) {

        dp[0][0] = 1;
        for(int i = 0 ; i<=m; i++) {
            for(int j = 0; j<=n; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                int up = i > 0 ? dp[i-1][j] : 0;
                int right = j > 0 ? dp[i][j-1]: 0;
                dp[i][j] = up + right;
            }
        }
        return dp[m][n];
    }

    public int countPathOpt(int m , int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        // to reach in same row it will take 1 way for any column
        for(int i = 1; i <= m ; i++) {
            for(int j = 1; j<=n ; j++) {
                dp[j] = dp[j]+dp[j-1];
            }
        }
        return dp[n];
    }
}