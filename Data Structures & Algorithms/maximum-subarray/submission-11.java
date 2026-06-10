class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num:nums) {
            if(sum < 0) sum = 0;
            sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }
}
