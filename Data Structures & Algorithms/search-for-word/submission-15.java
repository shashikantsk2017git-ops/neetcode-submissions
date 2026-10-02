class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(checkWord(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean checkWord(char[][] board, int row, int col, String word, int ind) {
        if(ind == word.length()) return true;
        if(row < 0 || row > board.length-1 || col < 0 || col > board[row].length-1 
        || word.charAt(ind) != board[row][col])  return false;

        char temp = board[row][col];
        board[row][col] = '.';
        if(checkWord(board, row+1, col, word, ind+1) ||
            checkWord(board, row-1, col, word, ind+1) ||
            checkWord(board, row, col+1, word, ind+1) ||
            checkWord(board, row, col-1, word, ind+1) ) return true;
        board[row][col] = temp;

        return false;    
    }
}
