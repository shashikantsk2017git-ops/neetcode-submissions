class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            //If sum (for first time sum is first element so if first element) is less than zero
            // then make is zero becz adding minus in sum will decrease the total sum so don't keep
            // and considerin sub array without that
            if(sum < 0) sum = 0;
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public int maxSubArray0(int[] nums) {
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
