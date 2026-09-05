class Solution {
    public int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = 0;
        for(int num: nums) {
            low = Math.max(low, num);
            high += num;
        }

        return largestSplitSum(nums, k, low, high);
    }

    public int largestSplitSum(int[] nums, int k, int low, int high) {
        while(low <= high) {
            int mid = (low + high)/2;
            int count = noOfArrayRequired(nums, k, mid);

            if(count > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int noOfArrayRequired(int[] nums, int k, int maxValue) {
        int count = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum+nums[i] <= maxValue) {
                sum += nums[i];
            } else {
                sum = nums[i];
                count++;
            }
        }
        return count;
    }
}



