class Solution {
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
        return canEqualiyPartition(nums, 0, arr, target);
    }

    public boolean canEqualiyPartition(int[] nums, int ind, int[] arr, int target) {
        if (ind == nums.length) return true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + nums[ind] <= target) {
                arr[i] += nums[ind];
                if (canEqualiyPartition(nums, ind + 1, arr, target)) return true;
                arr[i] -= nums[ind];
                if (arr[i] == 0) break;
            }
        }
        return false;
    }
}