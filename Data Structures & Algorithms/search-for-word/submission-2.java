class Solution {

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0) && check(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int r, int c, int index, String word) {

        if(index == word.length()) return true;
        if(r < 0 || r > board.length-1 || c< 0|| c > board[r].length-1 || index > word.length()-1 ||
            board[r][c] == '.' || board[r][c] != word.charAt(index)) return false;
        char temp = board[r][c];
        board[r][c] = '.';

        if(check(board, r+1, c, index+1, word) ||
            check(board, r-1, c, index+1, word) ||
            check(board, r, c+1, index+1, word) ||
            check(board, r, c-1, index+1, word)
        ) {
            return true;
        }

        board[r][c] = temp;
        return false;
    }


    public boolean check1(char[][] board, String word, int r, int c, int index) {
       
        if(index == word.length()) return true;
        
        if(r < 0 || r > board.length - 1 || c < 0 || c > board[0].length - 1 || board[r][c] == '.' || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[r][c];
        board[r][c] = '.';
        if(check1(board, word, r+1, c, index+1) ||
            check1(board, word, r-1, c, index+1) ||
            check1(board, word, r, c+1, index+1) ||
            check1(board, word, r, c-1, index+1)) 
        return true;

        board[r][c] = temp;
        return false;
    }
}