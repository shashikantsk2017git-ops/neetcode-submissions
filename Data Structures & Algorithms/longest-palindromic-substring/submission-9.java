class Solution {
    public String longestPalindrome(String s) {
        String out = "";
        for(int i = 0; i < s.length(); i++) {
            String temp = "";
            String even = palin(s, i, i+1);
            String odd = palin(s, i, i);
            if(even.length() > odd.length()) {
                temp = even;
            } else{
                temp = odd;
            }
            if(out.length() < temp.length()) {
                out = temp;
            }
        }
        return out;
    }

    private String palin(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
        }

        return s.substring(left+1, right);
    }
}
