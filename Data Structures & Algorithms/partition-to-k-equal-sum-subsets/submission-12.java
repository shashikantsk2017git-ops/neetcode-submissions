class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int max = 0;
        for(int num: nums) max += num;

        if(max % k != 0) return false;
        int target = max / k;

        sortAndReverse(nums);
        int[] sub = new int[k];
        return canPartition(nums, sub, target, 0);
    }

    private boolean canPartition(int[] nums, int[] sub, int target, int ind) {
        if(ind == nums.length) return true;

        for(int i = 0; i < sub.length; i++) {
            if(sub[i] + nums[ind] <= target) {
                sub[i] += nums[ind];
                if(canPartition(nums, sub, target, ind+1)) return true;
                sub[i] -= nums[ind];
            }
        }

        return false;
    }

    private void sortAndReverse(int[] nums) {
        Arrays.sort(nums);

        int i = 0; 
        int j = nums.length - 1;

        while( i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}