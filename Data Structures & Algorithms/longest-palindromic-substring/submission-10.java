class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++) {
            String odd = palindrom(s, i, i);
            String even = palindrom(s, i, i+1);

            String curr = odd.length() > even.length() ? odd: even;
            longest = curr.length() > longest.length() ? curr: longest;
        }
        return longest;
    }

    public String palindrom(String str, int left, int right) {
        while(left > -1 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return str.substring(left+1, right);
    }
}

