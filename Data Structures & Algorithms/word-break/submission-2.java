class Solution {
   public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);
    return wordBreak(s, wordSet, 0, new Boolean[s.length() + 1]);
    }

    private boolean wordBreak(String s, Set<String> wordSet, int start, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        
        if (dp[start] != null) {
            return dp[start];
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && 
                wordBreak(s, wordSet, end, dp)) {
                dp[start] = true;
                return true;
            }
        }
        
        dp[start] = false;
        return false;
    }
}