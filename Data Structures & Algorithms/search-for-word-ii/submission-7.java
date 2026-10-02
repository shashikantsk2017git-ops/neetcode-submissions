class Trie {
    Trie[] nodes = new Trie[26];
    boolean isWord;
    String word;
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            Trie tempTrie = trie;
            for(char c: word.toCharArray()) {
                if(tempTrie.nodes[c - 'a'] == null) tempTrie.nodes[c - 'a'] = new Trie();
                tempTrie = tempTrie.nodes[c - 'a'];
            }
            tempTrie.isWord = true;
            tempTrie.word = word;
        }

        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                checkBoard(i, j, board, trie, res);
            }
        }
        return res;
    }

    private void checkBoard(int row, int col, char[][] board, Trie trie, List<String> res) {
        if(row < 0 || col < 0 || row > board.length-1 || col > board[row].length -1 ||
            board[row][col] == '.' || trie.nodes[board[row][col] - 'a'] == null) return;
        
        char temp = board[row][col];

        Trie trieCurr = trie.nodes[temp - 'a'];
        if(trieCurr.isWord) {
            res.add(trieCurr.word);
            trieCurr.isWord = false;
        }

        board[row][col] = '.';
        checkBoard(row+1, col, board, trieCurr, res);
        checkBoard(row-1, col, board, trieCurr, res);
        checkBoard(row, col+1, board, trieCurr, res);
        checkBoard(row, col-1, board, trieCurr, res);

        board[row][col] = temp;
    }

    public List<String> findWords1(char[][] board, String[] words) {
        List<String> out = new ArrayList<>();
        for(String word: words) {
            if(exist(board, word)) out.add(word);
        }
        return out;
    }

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
        if(r < 0 || r > board.length-1 || c< 0|| c > board[r].length-1 ||
            board[r][c] == '.' || board[r][c] != word.charAt(index)) 
            return false;
        char temp = board[r][c];
        board[r][c] = '.';

        if(check(board, r+1, c, index+1, word) ||
            check(board, r-1, c, index+1, word) ||
            check(board, r, c+1, index+1, word) ||
            check(board, r, c-1, index+1, word)
        ) {
            board[r][c] = temp;
            return true;
        }

        board[r][c] = temp;
        return false;
    }
}
