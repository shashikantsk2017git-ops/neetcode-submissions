class WordDictionary {
    WordDictionary[] child;
    boolean lastChar;

    public WordDictionary() {
        child = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for(int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i)-'a';
            if(node.child[ind] == null) {
                node.child[ind] = new WordDictionary();
            }
            node = node.child[ind];
        }
        node.lastChar = true;
    }

    public boolean search(String word) {
        WordDictionary node = this;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                for(WordDictionary temp: node.child) {
                    if(temp != null && temp.search(word.substring(i+1))) {
                        return true;
                    }
                }
                return false;
            }
            int ind = word.charAt(i)-'a';
            if(node.child[ind] == null) return false;
            node = node.child[ind];
        }
        return node.lastChar;
    }
}



