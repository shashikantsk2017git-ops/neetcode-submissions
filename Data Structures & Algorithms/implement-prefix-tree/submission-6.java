class PrefixTree {
    PrefixTree[] tree;
    boolean isWord;

    public PrefixTree() {
        tree  = new PrefixTree[26];
    }

    public void insert(String word) {
        PrefixTree tempT = this;
        for(char c: word.toCharArray()) {
            if(tempT.tree[c-'a'] == null) {
                tempT.tree[c-'a'] = new PrefixTree();
            }
            tempT = tempT.tree[c-'a'];
        }
        tempT.isWord = true;
    }

    public boolean search(String word) {
        PrefixTree tempT = this;
        for(char c: word.toCharArray()) {
            if(tempT.tree[c-'a'] == null) return false;
            tempT = tempT.tree[c-'a'];
        }
        return tempT.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree tempT = this;
        for(char c: prefix.toCharArray()) {
            if(tempT.tree[c-'a'] == null) return false;
            tempT = tempT.tree[c-'a'];
        }
        return true;
    }
}


