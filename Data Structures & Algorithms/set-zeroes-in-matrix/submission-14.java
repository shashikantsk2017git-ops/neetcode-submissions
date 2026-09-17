class Solution {
    public void setZeroes0(int[][] mat) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for(int i = 0; i < mat.length; i++) {
            if(mat[i][0] == 0) firstColZero = true;
        }

        for(int i = 0; i < mat[0].length; i++) {
            if(mat[0][i] == 0) firstRowZero = true;
        }

        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    mat[0][j] = 0;
                    mat[i][0] = 0;
                } 
            }
        }

        for(int i = 1; i < mat.length; i++) {
            for(int j = 1; j < mat[i].length; j++) {
                if(mat[i][0] == 0 || mat[0][j] == 0) {
                   mat[i][j] = 0;
                } 
            }
        }

        if(firstRowZero) {
            for(int i = 0; i < mat[0].length; i++) {
                mat[0][i] = 0;
            }
        }
        if(firstColZero) {
            for(int i = 0; i < mat.length; i++) {
                mat[i][0] = 0;
            }
        }
    }

    public void setZeroes1(int[][] mat) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    updateRowNCol(i, j, matrix);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void updateRowNCol(int row, int col, int[][] mat) {

        for(int i = 0; i < mat.length; i++) {
            if(mat[i][col] != 0)
                mat[i][col] = -1;
        }

        for(int i = 0; i < mat[row].length; i++) {
            if(mat[row][i] != 0)
                mat[row][i] = -1;
        }
    }
}
