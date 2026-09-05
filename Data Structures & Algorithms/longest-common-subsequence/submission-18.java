class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return lcs(text1, text2, 0, 0);
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return lcs(text1, text2, 0, 0,dp);
        return lcs(text1, text2);
    }

    private int lcs(String text1, String text2, int ind1, int ind2) {
        if (ind1 == text1.length() || ind2 == text2.length())
            return 0;
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return 1 + lcs(text1, text2, ind1 + 1, ind2 + 1);
        }
        return Math.max(lcs(text1, text2, ind1 + 1, ind2), lcs(text1, text2, ind1, ind2 + 1));
    }

    private int lcs(String text1, String text2, int ind1, int ind2, int[][] dp) {
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if (ind1 == text1.length() || ind2 == text2.length())
            return 0;
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            dp[ind1][ind2] = 1 + lcs(text1, text2, ind1 + 1, ind2 + 1);
        } else {
            dp[ind1][ind2] =
                Math.max(lcs(text1, text2, ind1 + 1, ind2), lcs(text1, text2, ind1, ind2 + 1));
        }
        return dp[ind1][ind2];
    }

    private int lcs(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = text1.length()-1; i >= 0; i--) {
            for(int j = text2.length()-1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] =
                        Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}
