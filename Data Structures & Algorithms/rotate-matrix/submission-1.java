class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length-1;
        int col = matrix[0].length -1;

        //transpose --> means move row to column
        for(int i = 0; i<= row; i++) {
            for(int j = i+1; j <= col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reverse

        for(int i = 0; i<=row; i++) {
            int l = 0; int r = row;

            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
