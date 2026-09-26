class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char celVal = board[i][j];

                if(celVal == '.') continue;

                // int val = Character.getNumericValue(celVal);
                int val = celVal - '0';

                if(row[i][val - 1] == 1) return false;
                if(col[val - 1][j] == 1) return false;

                row[i][val - 1] = 1;
                col[val - 1][j] = 1;

                int boardInd = 3 * (i/3) + j/3;

                if(box[boardInd][val - 1] == 1) return false;
                box[boardInd][val - 1] = 1;
            }
        }

        return true;
    }
}
