class Solution {

    public int numDecodings(String s) {
        return decode(s, 0);
    }

    public int decode(String s, int ind) {

        if(ind == s.length()) return 1;
        if(s.charAt(ind) == '0') return 0;

        int one = decode(s, ind+1);
        int two = 0;
        if(ind+1 < s.length() && Integer.parseInt(s.substring(ind, ind+2)) <= 26)
            two = decode(s, ind+2);

        return one + two;
    }
}