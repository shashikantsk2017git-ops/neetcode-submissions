class Solution {
    public boolean canPartition(int[] nums) {
        return canPartitionKSubsets(nums, 2);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % k != 0) return false;          // FIX: must divide evenly
        int target = sum / k;                     // FIX: single exact target

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }

        if (nums[0] > target) return false;       // largest num can't exceed target

        int[] arr = new int[k];
        return canSplitIntoKGroups(nums, arr, target, 0);
    }

    public boolean canSplitIntoKGroups(int[] nums, int[] tarArr, int target, int ind) {
        if(ind == nums.length) return true;
        for(int i = 0; i < tarArr.length; i++) {
            if(tarArr[i] + nums[ind] <= target) {
                tarArr[i] += nums[ind];
                if(canSplitIntoKGroups(nums, tarArr, target, ind+1)) return true;
                tarArr[i] -= nums[ind];
            }
            // if(tarArr[i] == 0) break;
        }
        return false;
    }
}