class Solution {
    public int splitArray(int[] nums, int k) {
        int  max = nums[0];
        int sum = 0;
        for(int num: nums) {
            sum += num;
            max = Math.max(num, max);
        }    

        return findLSum(max, sum, nums, k);
    }

    public int findLSum(int beg, int end, int[] nums, int k) {
        while(beg <= end) {
            int mid = (beg + end)/2;

            if(calculateSubA(mid, nums) > k) {
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return beg;
    }

    public int calculateSubA(int mid, int[] nums) {
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