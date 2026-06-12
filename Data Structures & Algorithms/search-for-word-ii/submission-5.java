class Trie {
    Trie[] node = new Trie[26];
    boolean isWord;
    String word;
}
class Solution {
    Trie trie = new Trie();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word: words) addToTrie(trie, word);

        List<String> out = new ArrayList<>();

        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                checkWord(board, trie, out, i, j);
            }
        }
        return out;
    }

    public void checkWord(char[][] board, Trie trieTemp, List<String> out, int row, int col) {
        if(row < 0 || row > board.length-1 || col < 0 
            || col > board[row].length-1 
            || board[row][col] == '.' || trieTemp.node[board[row][col]-'a'] == null) return;

        Trie trieNext = trieTemp.node[board[row][col] -'a'];
        if(trieNext.isWord) {
            out.add(trieNext.word);
            trieNext.isWord = false;
        }

        char temp = board[row][col];
        board[row][col] ='.';

        checkWord(board, trieNext, out, row+1, col);
        checkWord(board, trieNext, out, row-1, col);
        checkWord(board, trieNext, out, row, col+1);
        checkWord(board, trieNext, out, row, col-1);

        board[row][col] = temp;
    }

    public void addToTrie(Trie trie, String word) {
        Trie trieNode = trie;
        for(char c: word.toCharArray()) {
            if(trieNode.node[c-'a'] == null) {
                Trie temp = new Trie();
                trieNode.node[c-'a'] = temp;
            }
            trieNode = trieNode.node[c-'a'];
        }
        trieNode.isWord = true;
        trieNode.word = word;
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
