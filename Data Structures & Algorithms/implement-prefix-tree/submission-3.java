class PrefixTree {
    PrefixTree[] nodes;
    boolean flag;

    public PrefixTree() {
        nodes = new PrefixTree[26];
        flag = false;
    }
    
    public void insert(String word) {
        PrefixTree temp = this;
        for(char c: word.toCharArray()) {
            if(temp.nodes[c-'a'] == null) {
                temp.nodes[c-'a'] = new PrefixTree();
            }
            temp = temp.nodes[c-'a'];
        }
        temp.flag = true;
    }
    
    public boolean search(String word) {
        PrefixTree temp = this;
        for(char c: word.toCharArray()) {
            if(temp.nodes[c-'a'] == null) {
                return false;
            }
            temp = temp.nodes[c-'a'];
        }
        return temp.flag;
    }
    
    
    public boolean startsWith(String pnodesix) {
        PrefixTree temp = this;
        for(int i = 0; i < pnodesix.length(); i++) {
            char c = pnodesix.charAt(i);

            if(temp.nodes[c-'a'] == null) return false;
            temp = temp.nodes[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(pnodesix);
 */