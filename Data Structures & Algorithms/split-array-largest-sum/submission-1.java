class Solution {
    public int splitArray(int[] nums, int k) {
        int min = 0;
        int max = 0;
        for(int num: nums) {
            min = Math.max(min, num);
            max += num;
        }

        return largestSum(nums, min, max, k);
    }

    public int largestSum(int[] nums, int min, int max, int k) {
        while(min <= max) {
            int mid = (min + max)/2;
            int count = checkNoOfSubArray(nums, mid);
            if(count > k) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }

        }
        return min;
    }

    public int checkNoOfSubArray(int[] nums, int mid) {
        int count = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
}