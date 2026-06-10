class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0;
        int right = 0;

        int maxLen = 0;
        int[] arr = new int[256];
        Arrays.fill(arr, -1);

        while(right < s.length()) {
            if(arr[s.charAt(right)] != -1 && arr[s.charAt(right)] >= left) {
                left = arr[s.charAt(right)]+1;
            }
            arr[s.charAt(right)] = right;
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }
        return maxLen;
    }
}
