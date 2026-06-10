class Solution {

    public boolean exist(char[][] board, String word) {
        int index = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(index) && checkWord(board, word, i, j, index)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWord(char[][] board, String word, int row, int col, int ind) {
        if(ind == word.length()) return true;
        if(row < 0 || row > board.length-1 || col < 0 || col > board[row].length-1 || 
            board[row][col] != word.charAt(ind))
            return false;

        char temp = board[row][col];
        board[row][col] = '.';

        if(checkWord(board, word, row+1, col, ind+1)
            || checkWord(board, word, row-1, col, ind+1)
            || checkWord(board, word, row, col+1, ind+1)
            || checkWord(board, word, row, col-1, ind+1)
        )
        return true;

        board[row][col] = temp;
        return false;
    }
}