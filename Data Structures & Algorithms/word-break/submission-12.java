class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // return wordCheck(s, wordDict, 0, 0);

        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return wordCheck(s, wordDict, 0, 0, dp);

        return wordCheck(s, wordDict, dp);
    }

    public boolean wordCheck(String s, List<String> wd, int beg, int end) {
        if(end == s.length()-1) {
            return wd.contains(s.substring(beg, end+1));
        }

        if(wd.contains(s.substring(beg, end+1))) {
            if(wordCheck(s, wd, end+1, end+1)) {
                return true;
            }
        }
        return wordCheck(s, wd, beg, end+1);
    }

    public boolean wordCheck(String s, List<String> wd, int beg, int end, int[][] dp) {
        if(dp[beg][end] != -1) return dp[beg][end]==1;
        
        if(end == s.length()-1) {
            return wd.contains(s.substring(beg, end+1));
        }

        if(wd.contains(s.substring(beg, end+1))) {
            if(wordCheck(s, wd, end+1, end+1)) {
                dp[beg][end] = 1;
                return true;
            }
        }
        boolean res = wordCheck(s, wd, beg, end+1);
        dp[beg][end] = res ? 1: 0;
        return res;
    }

    public boolean wordCheck(String s, List<String> wd, int[][] dp) {

        for(int end = s.length()-1; end>=0; end--) {
            for(int beg = end; beg>=0; beg--) {
                if(end == s.length()-1) {
                    dp[beg][end] = wd.contains(s.substring(beg, end+1)) ? 1 : 0;
                    continue;
                }
                if(wd.contains(s.substring(beg, end+1))) {
                    if(end+1 < s.length() && dp[end+1][end+1] == 1) {
                        dp[beg][end] = 1;
                        continue;
                    }
                }
                if(end+1 < s.length() && dp[beg][end+1] == 1) 
                    dp[beg][end] = 1;
                else 
                    dp[beg][end] = 0;    
            }
        }
        return dp[0][0] == 1;
    }



    public boolean wordCheck(String s, List<String> wordDict) {
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