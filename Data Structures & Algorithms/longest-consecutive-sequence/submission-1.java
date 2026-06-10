class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        for(int i = 0; i < nums.length; i++) {
            // if(set.contains(nums[i]-1)) {
            //     continue;
            // }
            int len = 1;
            int check = nums[i];
            while(set.contains(check+1)) {
                len++;
                check++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
