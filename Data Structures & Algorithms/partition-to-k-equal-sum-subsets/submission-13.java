class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int max = 0;
        for(int num: nums) max += num;

        if(max % k != 0) return false;
        int target = max / k;

        sortAndReverse(nums);
        int[] subArray = new int[k];
        return canPartition(nums, subArray, target, 0);
    }

    private boolean canPartition(int[] nums, int[] subArray, int target, int ind) {
        if(ind == nums.length) return true;

        for(int i = 0; i < subArray.length; i++) {
            if(subArray[i] + nums[ind] <= target) {
                subArray[i] += nums[ind];
                if(canPartition(nums, subArray, target, ind+1)) return true;
                subArray[i] -= nums[ind];
            }
            // if(subArray[i] == 0) break;
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