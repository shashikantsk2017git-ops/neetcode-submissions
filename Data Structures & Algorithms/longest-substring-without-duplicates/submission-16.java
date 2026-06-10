class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int j = i;
            while(j < s.length()) {
                if(set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                j++;
            }
            len = Math.max(len, j - i);
        }
        return len;
    }
}

