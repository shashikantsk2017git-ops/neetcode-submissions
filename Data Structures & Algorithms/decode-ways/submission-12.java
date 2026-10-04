class Solution {
    public int numDecodings(String s) {
        // return decode(s, 0); 
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        // return decode(s, 0, dp);
        return decodeOpt(s);
    }

    private int decode(String s, int ind) {
        if(ind == s.length()) return 1;

        if(s.charAt(ind) == '0') return 0;

        int one = decode(s, ind + 1);
        int two = 0;
        if(ind + 1 < s.length() && Integer.parseInt(s.substring(ind, ind+2)) <= 26)
            two = decode(s, ind + 2);

        return one + two;
    }

    private int decode(String s, int ind, int[] dp) {
        if(ind == s.length()) return 1;
        if(dp[ind] != -1) return dp[ind];

        if(s.charAt(ind) == '0') return 0;

        int one = decode(s, ind + 1, dp);
        int two = 0;
        if(ind + 1 < s.length() && Integer.parseInt(s.substring(ind, ind+2)) <= 26)
            two = decode(s, ind + 2, dp);

        return dp[ind] = one + two;
    }

    private int decode(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;

        for(int ind = s.length()-1; ind >= 0; ind--) {
            if(s.charAt(ind) == '0') {
                dp[ind] = 0;
                continue;
            }
            int one = dp[ind + 1];
            int two = 0;
            if(ind + 1 < s.length() && Integer.parseInt(s.substring(ind, ind+2)) <= 26)
                two = dp[ind + 2];
            dp[ind] = one + two;
        }
        return dp[0];
    }

    private int decodeOpt(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;

        int prev1 = 1;
        int prev2 = 1;
        for(int ind = s.length()-1; ind >= 0; ind--) {
            if(s.charAt(ind) == '0') {
                prev2 = prev1;
                prev1 = 0;
                continue;
            }
            int one = prev1;
            int two = 0;
            if(ind + 1 < s.length() && Integer.parseInt(s.substring(ind, ind+2)) <= 26)
                two = prev2;
            prev2 = prev1   ;
            prev1 = one + two;
        }
        return prev1;
    }
}
