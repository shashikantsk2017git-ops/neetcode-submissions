class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int min = Integer.MIN_VALUE;

        for(int num: nums) {
            max += num;
            //As question said any subarray largest sum is minimized, here largest sum will be sum
            //but minimized means if check max out of all subarray maximum will be smaller
            //e.g subar1 = 25, subar2 = 4 so max is 25 and subar1 = 18, subar2 = 11 so max = 18
            //but once subar1 = 5, subar2 = 24 so max is 24 here minized one is 18
            min = Math.max(min, num);
        }

        while(min <= max) {
            int mid = (min + max)/2;

            if(canSplit(nums, mid, k)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canSplit(int[] nums, int target, int k) {
        int sum = 0;
        int count = 1;

        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] <= target) {
                sum += nums[i];
            } else {
                sum = nums[i];
                count++;
            }
        }

        //count is samller means larger values are there means we should decrease the values
        return count <= k;
    }
}