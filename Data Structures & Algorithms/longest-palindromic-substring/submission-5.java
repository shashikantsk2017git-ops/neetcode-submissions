class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for(int i = 0; i < s.length(); i++) {
            String odd = palindrom(s, i, i);
            String even = palindrom(s, i, i+1);
            if(odd.length() > even.length()) {
                if(max.length() <= odd.length()) {
                    max = odd;
                }
            } else {
                if(max.length() <= even.length()) {
                    max = even;
                }
            }
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

