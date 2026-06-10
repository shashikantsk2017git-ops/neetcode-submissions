class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for(int i = 0; i < s.length(); i++) {
            String odd = palindrom(s, i, i);
            String even = palindrom(s, i, i+1);
            String curr = odd.length() > even.length() ? odd : even;
            max = max.length() <= curr.length() ? curr : max;
        }
        return max;
    }

    public String palindrom(String s, int first, int sec) {
        while(first >=0 && sec <= s.length()-1 && s.charAt(first) == s.charAt(sec)) {
            first--;
            sec++;
        }
        return s.substring(first+1, sec);
    }
}

