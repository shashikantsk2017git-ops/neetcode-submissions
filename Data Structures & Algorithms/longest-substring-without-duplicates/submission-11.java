class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLen = 0;

        int[] store = new int[257];
        Arrays.fill(store, -1);

        while(j < s.length()) {
            char c = s.charAt(j);
            int str = store[c];
            if(str != -1 && str >= i) 
                i = str+1;

            store[c] = j;
            int len = j -i + 1;
            maxLen = Math.max(maxLen, len);
            j++;
        }

        return maxLen;
    }
}

