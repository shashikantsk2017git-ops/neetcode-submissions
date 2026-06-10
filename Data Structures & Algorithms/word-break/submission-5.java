class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        
        // Initialize dp table with -1 (uncomputed)
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // Fill the table bottom-up
        // We need to process in reverse order of the recursion
        // Process end from n-1 down to 0
        for(int end = n - 1; end >= 0; end--) {
            // Process start from end down to 0
            for(int start = end; start >= 0; start--) {
                // Base case: if end is at the last character
                if(end == n - 1) {
                    if(wordDict.contains(s.substring(start, end + 1))) {
                        dp[start][end] = 1;
                    } else {
                        dp[start][end] = -1;
                    }
                    continue;
                }
                
                // Check if current substring is in dictionary
                if(wordDict.contains(s.substring(start, end + 1))) {
                    // Check if we can break the rest of the string
                    if(end + 1 < n && dp[end + 1][end + 1] == 1) {
                        dp[start][end] = 1;
                        continue;
                    }
                }
                
                // Try extending the end pointer
                if(end + 1 < n && dp[start][end + 1] == 1) {
                    dp[start][end] = 1;
                } else if(end + 1 < n && dp[start][end + 1] == -1) {
                    dp[start][end] = -1;
                } else {
                    dp[start][end] = -1;
                }
            }
        }
        
        return dp[0][0] == 1;
    }
}