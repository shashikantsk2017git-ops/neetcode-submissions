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

    public boolean search0(String word) {
        WordDictionary node = this; // this is not root this where wordDictionary.search called
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                for(WordDictionary temp: node.child) {
                    if(temp != null && temp.search(word.substring(i+1))) { //here it called on temp (so where temp present it will take search from there)
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

    public boolean search(String word) {
        WordDictionary node = this;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int ind = c - 'a';
            if(c == '.') {
                for(WordDictionary temp: node.child) {
                    if(temp != null && temp.search(word.substring(i+1))) {
                        return true;
                    }
                }
                return false;
            }
            if(node.child[ind] == null) return false;
            node = node.child[ind];
        }
        return node.lastChar;
    }
}



