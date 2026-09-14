class WordDictionary {
    WordDictionary[] node;
    boolean isWord;

    public WordDictionary() {
        node = new WordDictionary[26];
    }

    public void addWord(String word) {
        // this is a reference to the object using which this method was called
        WordDictionary curr = this;
        for(char c: word.toCharArray()) {
            if(curr.node[c-'a'] == null) {
                curr.node[c-'a'] = new WordDictionary();
            }

            curr = curr.node[c-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        //this is not root this is objec using which wordDictionary.search method called
        WordDictionary curr = this;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(WordDictionary wd: curr.node) {
                    //here it will be called on wd bcoz search will start from node 
                    //where wd reached till previous steps
                    if(wd != null && wd.search(word.substring(i+1))) return true;
                }
                return false;
            }
            if(curr.node[c-'a'] == null) return false;
            curr = curr.node[c-'a'];
        }
        return curr.isWord;
    }
}
