class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        if(s.length() < 2) return s;
        for(int i = 1; i < s.length(); i++) {
            String odd = palindrom(s, i, i);
            String even = palindrom(s, i-1, i);
            res = odd.length() > even.length() ? (res.length() > odd.length() ? res : odd) : (res.length() > even.length() ? res : even);
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

