class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // return wordCheck(s, wordDict, 0, 0);

        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return wordCheck(s, wordDict, 0, 0, dp);

        return wordCheck(s, wordDict, dp);

        // return wordCheck(s, wordDict, 0);
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
                if(wd.contains(s.substring(beg, end+1)) && end+1 < s.length() && dp[end+1][end+1] == 1) {
                        dp[beg][end] = 1;
                }
                else{
                    dp[beg][end] = end+1 < s.length() && (dp[beg][end+1] == 1) ? 1 : 0; 
                }
            }
        }
        return dp[0][0] == 1;
    }

    public boolean wordCheck(String s, List<String> wd, int beg) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        if(beg == s.length()) return true;
        if(dp[beg] != -1) return dp[beg] == 1;

        for(int end = beg+1; end <= s.length(); end++) {
            if(wd.contains(s.substring(beg, end))) {
                if(wordCheck(s, wd, end)) {
                    dp[beg] = 1;
                    return true;
                }
            }
        }

        return false;
    }
}