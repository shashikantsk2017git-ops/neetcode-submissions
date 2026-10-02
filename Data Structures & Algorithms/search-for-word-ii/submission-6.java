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
}
