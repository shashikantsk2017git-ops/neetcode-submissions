class Solution {
    public boolean isAnagram(String s, String t) {
        int[] mem = new int[26];

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            mem[c-'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mem[c-'a']--;
        }

        for(int i = 0; i<mem.length; i++){
            if(mem[i] != 0) return false;
        }
        return true;
    }
}