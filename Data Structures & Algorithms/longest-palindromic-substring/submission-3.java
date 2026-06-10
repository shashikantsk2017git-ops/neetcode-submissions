class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s.length() < 2) return s;
        for(int i = 1; i < s.length(); i++) {
            String odd = palindrom(s, i, i);
            String even = palindrom(s, i-1, i);
            String out = odd.length() > even.length() ?  odd : even;
            if(out.length() > res.length()) res = out;
        }
        return res;
    }

    public String palindrom(String s, int low, int high) {
        while(s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
            if(high > s.length()-1 || low < 0) {
                break;
            }
        }
        return s.substring(low+1, high);

    }
}

