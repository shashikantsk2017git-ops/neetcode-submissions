class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return lcs(text1, text2, 0, 0);

        // int[][] dp = new int[text1.length()][text2.length()];
        // for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        // return lcs(text1, text2, 0, 0, dp);

        // return lcs(text1, text2);

        // return lcsOpt(text1, text2);
        return lcsOpt2(text1, text2);
    }

    public int lcs(String str1, String str2, int ind1, int ind2) {
        if (ind1 > str1.length() - 1 || ind2 > str2.length() - 1) {
            return 0;
        }
        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            return 1 + lcs(str1, str2, ind1 + 1, ind2 + 1);
        }
        return Math.max(lcs(str1, str2, ind1 + 1, ind2), lcs(str1, str2, ind1, ind2 + 1));
    }

    public int lcs(String str1, String str2, int ind1, int ind2, int[][] dp) {
        if (ind1 > str1.length() - 1 || ind2 > str2.length() - 1) {
            return 0;
        }
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        if (str1.charAt(ind1) == str2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcs(str1, str2, ind1 + 1, ind2 + 1);
        }
        return dp[ind1][ind2] =
                   Math.max(lcs(str1, str2, ind1 + 1, ind2), lcs(str1, str2, ind1, ind2 + 1));
    }

    public int lcs(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int ind1 = str1.length() - 1; ind1 >= 0; ind1--) {
            for (int ind2 = str2.length() - 1; ind2 >= 0; ind2--) {
                if (str1.charAt(ind1) == str2.charAt(ind2)) {
                    dp[ind1][ind2] = 1 + dp[ind1 + 1][ind2 + 1];
                } else
                    dp[ind1][ind2] = Math.max(dp[ind1 + 1][ind2], dp[ind1][ind2 + 1]);
            }
        }
        return dp[0][0];
    }

    public int lcsOpt(String str1, String str2) {
        int[] prev = new int[str2.length() + 1];
        int[] curr = new int[str2.length() + 1];

        for (int ind1 = str1.length() - 1; ind1 >= 0; ind1--) {
            for (int ind2 = str2.length() - 1; ind2 >= 0; ind2--) {
                if (str1.charAt(ind1) == str2.charAt(ind2)) {
                    curr[ind2] = 1 + prev[ind2 + 1];
                } else
                    curr[ind2] = Math.max(curr[ind2 + 1], prev[ind2]);
            }
            for(int i = 0; i < prev.length && i < curr.length; i++) prev[i] = curr[i]; 
            
        }
        return prev[0];
    }

    public int lcsOpt2(String str1, String str2) {
        int[] dp = new int[str2.length() + 1];

        for (int ind1 = str1.length() - 1; ind1 >= 0; ind1--) {
            int prev = 0;
            for (int ind2 = str2.length() - 1; ind2 >= 0; ind2--) {
                int temp = dp[ind2];
                if (str1.charAt(ind1) == str2.charAt(ind2)) {
                    dp[ind2] = 1 + prev;
                } else
                    dp[ind2] = Math.max(dp[ind2], dp[ind2 + 1]);
                prev = temp;    
            }
        }
        return dp[0];
    }
}
