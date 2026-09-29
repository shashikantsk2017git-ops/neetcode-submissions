class Solution {
    List<List<String>> out = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i = 0; i < board.length; i++) Arrays.fill(board[i], ".");

        placeQ(0, n-1, board);
        return out;
    }

    private void placeQ(int col, int n, String[][] board) {
        if(col == n+1) {
            List<String> solution = new ArrayList<>();
            for (String[] row : board) {
                solution.add(String.join("", row));
            }
            out.add(solution);
            return;
        }

        for(int i = 0 ; i <=n; i++) {
            if(canPlace(i, col, n, board)) {
                board[i][col] = "Q";
                placeQ(col+1, n, board);
                board[i][col] = ".";
            }
        }
    }

    private boolean canPlace(int row, int col, int n, String[][] board) {
        int orgRow = row;
        int orgCol = col;

        //left diagonal - up
        while(row >= 0 && col >= 0) {
            if(board[row][col].equals("Q")) return false;
            row--;
            col--;
        }

        //why only left diagonal because we are starting from left so we do not have any thing in 
        //right diagonal

        //left diagonal - down
        row = orgRow;
        col = orgCol; 
        while(row <= n && col >= 0) {
            if(board[row][col].equals("Q")) return false;
            row++;
            col--;
        }

        //left side
        row = orgRow;
        col = orgCol; 

        while(col >= 0) {
            if(board[row][col].equals("Q")) return false;
            col--;
        }

        return true;
    }
}
