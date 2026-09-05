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
        return canFinish(target, 0, nums, arr );
    }

    public boolean canFinish(int limit, int ind, int[] jobs, int[] worker) {
        if(ind == jobs.length) return true;

        for(int i = 0; i < worker.length; i++) {
            if(worker[i]+jobs[ind] <= limit) {
                worker[i] +=jobs[ind];
                if(canFinish(limit, ind+1, jobs, worker)) return true;
                worker[i] -=jobs[ind];
            }

            if(worker[i] == 0) break;
        }
        return false;
    }
}