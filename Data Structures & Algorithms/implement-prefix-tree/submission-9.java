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
        PrefixTree newT = searchCommon(word);
        return newT != null && newT.isWord;
    }

    public boolean startsWith(String prefix) {
        PrefixTree tempT = searchCommon(prefix);
        return tempT != null;
    }

    public PrefixTree searchCommon(String word) {
        PrefixTree tempT = this;
        for(char c: word.toCharArray()) {
            if(tempT.tree[c-'a'] == null) return null;
            tempT = tempT.tree[c-'a'];
        }
        return tempT;
    }

}


