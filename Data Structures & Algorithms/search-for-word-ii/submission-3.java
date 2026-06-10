class Trie {
    Trie[] child = new Trie[26];
    boolean isWord = false;
    String word = null;
}

class Solution {
    Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) addToTrie(word);

        List<String> out = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                checkWord(board, i, j, out, trie);
            }
        }
        return out;
    }

    public void checkWord(char[][] board, int row, int col, List<String> out, Trie tempTrie) {
        
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[row].length - 1
                || board[row][col] == '.'                         
                || tempTrie.child[board[row][col] - 'a'] == null)
            return;

        Trie nextNode = tempTrie.child[board[row][col] - 'a']; 

        if (nextNode.isWord) {
            out.add(nextNode.word);  
            nextNode.isWord = false;   //mark false to prevent duplicates
        }

        char temp = board[row][col];
        board[row][col] = '.';      

        //void recursive calls, no boolean return needed
        checkWord(board, row + 1, col, out, nextNode);
        checkWord(board, row - 1, col, out, nextNode);
        checkWord(board, row, col + 1, out, nextNode);
        checkWord(board, row, col - 1, out, nextNode);

        board[row][col] = temp; 
    }

    public void addToTrie(String word) {
        Trie temp = trie;
        for (char c : word.toCharArray()) {
            if (temp.child[c - 'a'] == null) {
                temp.child[c - 'a'] = new Trie();
            }
            temp = temp.child[c - 'a'];
        }
        temp.isWord = true;
        temp.word = word;
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
