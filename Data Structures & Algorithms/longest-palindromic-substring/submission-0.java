class Solution {
    public String longestPalindrome(String s) {
        String output = "";
        if(s.length() <= 1) return s;
        for(int i = 1; i < s.length(); i++) {
            String odd = palindrom(s, i, i);
            String even = palindrom(s, i-1, i);
            if(odd.length() > output.length()) {
                output = odd;
            }
            if(even.length() > output.length()) {
                output = even;
            }
        }
        return output;
    }

    public String palindrom(String s, int low, int high) {
        while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;

                if(low < 0 || high > s.length()-1) {
                    break;
                }
            }
        String pal = s.substring(low+1, high);
        return pal;
    }
}
