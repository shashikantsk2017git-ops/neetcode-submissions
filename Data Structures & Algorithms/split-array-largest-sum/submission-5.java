class Solution {
    public int splitArray(int[] nums, int k) {
        int min = Integer.MIN_VALUE;
        int max = 0;

        for(int num: nums) {
            min = Math.max(num, min);
            max += num;
        }

        while(min <= max) {
            int mid = (min + max)/2;

            if(isSplitPossible(nums, k, mid)) {
                min = mid + 1;
            } else {
                max = mid-1;
            }
        }
        return min;
    }

    private boolean isSplitPossible(int[] nums, int k, int target) {
        int count = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if( sum + nums[i] <= target) {
                sum += nums[i];
            } else {
                count++;
                sum = nums[i];
            }
        }
        return count > k;
    }
}