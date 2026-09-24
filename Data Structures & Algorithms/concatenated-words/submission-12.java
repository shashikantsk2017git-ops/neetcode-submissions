class Solution {
    List<String> out = new ArrayList<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();

        for(String word: words) set.add(word);
        for(String word: words) {
            int[] dp = new int[word.length()];
            Arrays.fill(dp, -1);
            if(canForm(word, set, 0, dp)) out.add(word);
        }
        return out;
    }

    private boolean canForm(String word, Set<String> set, int ind) {
        if(ind == word.length()) return true;
        for(int i = ind; i < word.length(); i++) {
            String prefix = word.substring(ind, i+1);
            if(set.contains(prefix) && !prefix.equals(word) && canForm(word, set, i+1)) return true;
        }
        return false;
    }

    private boolean canForm(String word, Set<String> set, int ind, int[] dp) {
        if(ind == word.length()) return true;
        if(dp[ind] != -1) return dp[ind] == 1;
        for(int i = ind; i < word.length(); i++) {
            String prefix = word.substring(ind, i+1);
            if(set.contains(prefix) && !prefix.equals(word) && canForm(word, set, i+1, dp)) {
                dp[ind] = 1;
                return true;
            }
        }
        dp[ind]= 0;
        return false;
    }
}