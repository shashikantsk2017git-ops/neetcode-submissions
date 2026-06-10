class WordDictionary {
    private WordDictionary[] child;
    boolean isEnd;

    public WordDictionary() {
        child = new WordDictionary[26];
        isEnd = false;
    }
    
    public void addWord(String word) {
        WordDictionary temp = this;
        for(char c: word.toCharArray()) {
            if(temp.child[c-'a'] == null) {
                temp.child[c-'a'] = new WordDictionary();
            }
            temp = temp.child[c-'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        WordDictionary temp = this;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(WordDictionary n: temp.child) {
                    if(n != null && n.search(word.substring(i+1))) {
                        return true;
                    }
                }
                return false;
            }
            if(temp.child[c-'a'] == null) {
                return false;
            }
            temp = temp.child[c-'a'];
        }
        return temp.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */