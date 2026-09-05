class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum +=num;
        if(sum % 2 != 0) return false;

        sortAndReverse(nums);
        return canSplitIntoKGroups(nums, new int[2], sum/2, 0);
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

    public void sortAndReverse(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}