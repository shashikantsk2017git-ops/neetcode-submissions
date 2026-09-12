class Solution {
    public int uniquePaths(int m, int n) {
        //this is grid number to calculate in cell send index for that
        // return calPath(m-1, n-1);

        int[][] dp = new int[m][n];
        for(int i = 0;  i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return calPath(m-1, n-1, dp);

        return calPathOpt(m-1, n-1);
    }

    private int calPath(int m, int n) {
        //Two way to move down or right as we are backtracking from last so we have
        //two option to move up or left

        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;   
        //taking up
        int up =  calPath(m-1, n);

        //taking left
        int left = calPath(m, n-1);

        return up + left;
    }

    private int calPath(int m, int n, int[][] dp) {

        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        if(dp[m][n] != -1) return dp[m][n];   
        //taking up
        int up =  calPath(m-1, n);

        //taking left
        int left = calPath(m, n-1);

        return dp[m][n] = up + left;
    }

    private int calPathOpt(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i < dp.length; i++) dp[i][n] = 1;
        for(int i = 0; i < dp[0].length; i++) dp[m][i] = 1;

        for(int i = m; i >= 0; i--) {
            for(int j = n; j >= 0; j--) {
                if(i == m || j == n) continue;

                int up = dp[i+1][j];
                int left = dp[i][j+1];
                dp[i][j] = up + left;
            }
        }
        return dp[0][0];
    }
}
