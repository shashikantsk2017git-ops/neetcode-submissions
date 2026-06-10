class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return lcs(text1, text2, 0, 0);

        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        // return lcs(text1, text2, 0, 0, dp);

        return lcs(text1, text2);
    }

    public int lcs(String s1, String s2, int ind1, int ind2) {
        if(ind1 == s1.length() || ind2 == s2.length()) return 0;
        
        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + lcs(s1, s2, ind1+1, ind2+1);
        }

        return Math.max(lcs(s1, s2, ind1+1, ind2), lcs(s1, s2, ind1, ind2+1));
    }

    public int lcs(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if(ind1 == s1.length() || ind2 == s2.length()) return 0;

        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcs(s1, s2, ind1+1, ind2+1);
        }

        return dp[ind1][ind2] = Math.max(lcs(s1, s2, ind1+1, ind2), lcs(s1, s2, ind1, ind2+1));
    }

    public int lcs(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 0; i < dp.length; i++) dp[i][0] = 0;
        for(int i = 0; i < dp[0].length; i++) dp[0][i] = 0;

        for(int ind1 = s1.length()-1; ind1 >= 0; ind1--) {
            for(int ind2 = s2.length()-1; ind2 >= 0; ind2--) {
                if(s1.charAt(ind1) == s2.charAt(ind2)) {
                    dp[ind1][ind2] = 1 + dp[ind1+1][ind2+1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1+1][ind2], dp[ind1][ind2+1]);
                }
            }
        }
        return dp[0][0];
    }
}
