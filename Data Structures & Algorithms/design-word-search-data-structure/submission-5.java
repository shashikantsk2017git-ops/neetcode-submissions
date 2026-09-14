class WordDictionary {
    WordDictionary[] node;
    boolean isWord;
    public WordDictionary() {
        node = new WordDictionary[26];
    }

   public void addWord(String word) {
        WordDictionary temp = this;
        for(int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i)-'a';
            if(temp.node[ind] == null) {
                temp.node[ind] = new WordDictionary();
            }
            temp = temp.node[ind];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        WordDictionary temp = this;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                for(WordDictionary wd: temp.node) {
                    if(wd != null && wd.search(word.substring(i+1))) return true;
                }
                return false;  
            } 
            int ind = word.charAt(i)-'a';
            if(temp.node[ind] == null) return false;
            temp = temp.node[ind];
        }
        return temp.isWord;
    }
}
