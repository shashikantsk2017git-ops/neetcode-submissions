class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return totalPaths(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1);
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] ar: dp) Arrays.fill(ar, -1);

        return totalPaths(obstacleGrid, m-1, n-1, dp);
    }

    private int totalPaths(int[][] obstacleGrid, int m, int n) {
        if(m < 0 || n < 0) return 0;
        if(obstacleGrid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;
        //take up
        int up = totalPaths(obstacleGrid, m-1, n);

        //take left
        int left = totalPaths(obstacleGrid, m, n - 1);

        return up+left;
    }

    private int totalPaths(int[][] obstacleGrid, int m, int n, int[][] dp) {
        if(m < 0 || n < 0) return 0;
        if(obstacleGrid[m][n] == 1) return 0;
        if(m == 0 && n == 0) return 1;

        if(dp[m][n] != -1) return dp[m][n]; 
        //take up
        int up = totalPaths(obstacleGrid, m-1, n, dp);

        //take left
        int left = totalPaths(obstacleGrid, m, n - 1, dp);

        return dp[m][n] = up+left;
    }
}