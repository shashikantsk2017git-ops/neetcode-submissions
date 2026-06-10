class Solution {
    public int uniquePaths(int m, int n) {
        // return paths(m-1, n-1);
        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return paths(m-1, n-1, dp);

        return pathsLoopBetter(m-1, n-1);
    }

    public int paths(int m, int n) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        int left = paths(m-1, n);
        int up = paths(m, n-1);

        return left+up;
    }

    public int paths(int m, int n, int[][] dp) {
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int left = paths(m-1, n);
        int up = paths(m, n-1);

        return dp[m][n] = left+up;
    }

    public int pathsLoop(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        //if n is fixed at 0 means it can only go to up from ith postion so other option so 1
        for(int i = 0; i < dp.length; i++) dp[i][0] = 1;
        //if m is fixed at 0 means it can only go to left from ith postion so 1
        for(int i = 0; i < dp[0].length; i++) dp[0][i] = 1;
        
        for(int i = 1; i <=m; i++) {
            for(int j = 1; j<=n; j++) {
                int left = dp[i-1][j];
                int up = dp[i][j-1];
                dp[i][j] = left+up;
            }
        }
        return dp[m][n];
    }

    public int pathsLoopBetter(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i = 0; i <=m; i++) {
            for(int j = 0; j<=n; j++) {
                if(i == 0 && j == 0) continue;
                int left = i > 0 ? dp[i-1][j] : 0;
                int up = j > 0 ? dp[i][j-1]: 0;
                dp[i][j] = left+up;
            }
        }
        return dp[m][n];
    }
}