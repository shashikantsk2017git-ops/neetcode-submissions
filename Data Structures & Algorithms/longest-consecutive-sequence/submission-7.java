class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;
        for(int num: nums) set.add(num);
        int maxLen = Integer.MIN_VALUE;
        for(int num: nums) {
            if(set.contains(num-1)) continue;
            int len = 1;
            while(set.contains(num+1)) {
                len++;
                num++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
