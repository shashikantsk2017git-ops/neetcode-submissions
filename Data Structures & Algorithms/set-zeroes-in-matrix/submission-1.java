class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    vis[i][j] = true;
                }
            }
        }

        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(vis[i][j] && matrix[i][j] == 0) {
                    vis[i][j] = true;
                    updateCol(matrix, i);
                    updateRow(matrix, j);
                }
            }
        }
    }

    public void updateCol(int[][] matrix, int r) {
        for(int i = 0; i < matrix[r].length; i++) {
            matrix[r][i] = 0;
        }
    }

    public void updateRow(int[][] matrix, int c) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][c] = 0;
        }
    }
}
