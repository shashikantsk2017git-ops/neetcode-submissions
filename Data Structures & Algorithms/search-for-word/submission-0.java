class Solution {
    int[] row = {1, 0, -1, 0};
    int[] col = {0, 1, 0, -1};
    
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(check(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, String word, int r, int c, int index) {
       
        if(index == word.length()) return true;
        
        if(r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1) {
            return false;
        }
        
        if(board[r][c] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[r][c];
        board[r][c] = '.';
        
        for(int i = 0; i < row.length; i++) {
            int nr = row[i] + r;
            int nc = col[i] + c;
            
            if(check(board, word, nr, nc, index + 1)) {
                board[r][c] = temp; 
                return true;
            }
        }
        
        board[r][c] = temp;
        return false;
    }
}