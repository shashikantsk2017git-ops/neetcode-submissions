class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreak(s, wordSet);
    }

    private boolean wordBreak(String s, Set<String> wd) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true; // Base case: empty string after the end
        
        // Fill from right to left
        for(int start = n - 1; start >= 0; start--) {
            for(int end = start + 1; end <= n; end++) {
                if(wd.contains(s.substring(start, end)) && dp[end]) {
                    dp[start] = true;
                    break;
                }
            }
        }
        
        return dp[0];
    }
}