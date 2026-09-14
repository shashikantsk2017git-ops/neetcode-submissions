class PrefixTree {
    PrefixTree node[];
    boolean isWord;

    public PrefixTree() {
        node = new PrefixTree[26];
    }

    public void insert(String word) {
        // this is a reference to the object using which this method was called
        PrefixTree curr = this;
        for(char c: word.toCharArray()) {
            if(curr.node[c - 'a'] == null) {
                curr.node[c-'a'] = new PrefixTree();
            }
            curr = curr.node[c-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        // this is a reference to the object using which this method was called
        PrefixTree curr = this;
        for(char c: word.toCharArray()) {
            if(curr.node[c-'a'] == null) return false;
            curr = curr.node[c-'a'];
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;
        for(char c: prefix.toCharArray()) {
            if(curr.node[c-'a'] == null) return false;
            curr = curr.node[c-'a'];
        }
        return true;
    }
}
