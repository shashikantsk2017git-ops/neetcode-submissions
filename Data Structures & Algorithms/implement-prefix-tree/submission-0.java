class Node {
    Node[] ref = new Node[26];
    boolean flag;
}


class PrefixTree {
    Node node = new Node();
    public PrefixTree() {
        
    }
    
    public void insert(String word) {
        Node temp = node;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(temp.ref[c-'a'] == null) {
                Node nnode = new Node();
                temp.ref[c-'a'] = nnode;
            }
            temp = temp.ref[c-'a'];
        }
        temp.flag = true;
    }
    
    public boolean search(String word) {
        Node temp = node;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(temp.ref[c-'a'] == null) return false;
            temp = temp.ref[c-'a'];
        }
        return temp.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = node;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if(temp.ref[c-'a'] == null) return false;
            temp = temp.ref[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */