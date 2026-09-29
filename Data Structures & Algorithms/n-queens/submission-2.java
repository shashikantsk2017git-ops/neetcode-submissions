class Solution {
    List<List<String>> out = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for(int i = 0; i < board.length; i++) Arrays.fill(board[i], ".");
        // placeQueens(0, n-1, board);
        placeQueensOpt(0, n, board);
        return out;
    }

    private void placeQueens(int col, int n, String[][] board) {
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
                placeQueens(col+1, n, board);
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

    //For Upper diagonal Maintain a hashing array and then row + col will become index of hash array
    //e.g row = 3, col = 4 it will become 7, all diagonal will have 7 only

    //For Lower diagonal To filling numbers in matrix we can use (n - 1) + (col - row)
    //so eg of N = 8 if row = 0 and col = 7 then cell will have (8 -1) + (7 - 0) = 14

    //In both scenario if you follow those pattern same number will fall in diagonal
    //Array will be 2n-1

    private void placeQueensOpt(int col, int n, String[][] board) {
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] leftRow = new int[n];
        solve(0, n, board, leftRow, lowerDiagonal, upperDiagonal);
    }

    private void solve(int col, int n , String[][] board, int[] leftRow, int[] lowerDiagonal, 
    int[] upperDiagonal) {

        if(col == n) {
            List<String> solution = new ArrayList<>();
            for (String[] row : board) {
                solution.add(String.join("", row));
            }
            out.add(solution);
            return;
        }

        for(int row = 0 ; row < n; row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row + col] == 0 
            && upperDiagonal[n - 1 + col - row] == 0){
                board[row][col] = "Q";
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1; 
                upperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, n, board, leftRow, lowerDiagonal, upperDiagonal);

                board[row][col] = ".";
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0; 
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}
