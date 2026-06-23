class Solution {
    public boolean isAnagram(String s, String t) {
        int[] mem = new int[26];

        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            mem[s.charAt(i)-'a']++;
            mem[t.charAt(i)-'a']--;
        }


        for(int i = 0; i < 26; i++) {
            if(mem[i] != 0) return false;
        }
        return true;
    }
}