class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // return checkWord(s, wordDict, 0, 0);
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        // return checkWord(s, wordDict, 0, 0, dp);
        return checkWord(s, wordDict);
    }

    private boolean checkWord(String s, List<String> wd, int left, int right) {
        if(right == s.length() - 1) {
            return wd.contains(s.substring(left, right+1));
        }

        if(wd.contains(s.substring(left, right+1)) && checkWord(s, wd, right+1, right+1)) return true;
        return checkWord(s, wd, left, right+1);
    }

    private boolean checkWord(String s, List<String> wd, int left, int right, int[][] dp) {
        if(dp[left][right] != -1) return dp[left][right] == 1;

        if(right == s.length() - 1) {
            dp[left][right] = wd.contains(s.substring(left, right+1)) ? 1 : 0;
            return dp[left][right] == 1;
        }

        if(wd.contains(s.substring(left, right+1)) && checkWord(s, wd, right+1, right+1, dp)) {
            dp[left][right] = 1;
            return true;
        }
        dp[left][right] = checkWord(s, wd, left, right+1, dp) ? 1: 0;
        return dp[left][right] == 1;
    }   

    private boolean checkWord(String s, List<String> wd) {
        int[][] dp = new int[s.length()+2][s.length()+2];
        for(int right = s.length() -1; right >= 0; right--) {
            for(int left = right; left >=0; left--) {
                if(right == s.length() - 1) {
                    dp[left][right] = wd.contains(s.substring(left, right+1)) ? 1 : 0;
                }
                else if(wd.contains(s.substring(left, right+1)) && right+1 < s.length() 
                && dp[right+1][right+1] == 1) {
                    dp[left][right] = 1;
                }
                else {
                    dp[left][right] = dp[left][right+1];
                }
            }
        }
        return dp[0][0] == 1;
    }   
}
