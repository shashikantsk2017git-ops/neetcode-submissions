class Solution {
    public int lengthOfLIS(int[] nums) {
        return subseq(0, -1, nums);
    }

    public int subseq(int ind, int pre, int[] nums) {
        if(ind == nums.length) return 0;

        int lenNT = 0 + subseq(ind+1, pre, nums);
        if(pre == -1 || nums[ind] > nums[pre]) {
            int lenTake = 1 + subseq(ind+1, ind, nums);
            lenNT = Math.max(lenNT, lenTake);
        }
        return lenNT;
    }

    public int subseq(int ind, int pre, int[] nums, int[][] dp) {
        if(ind == nums.length) return 0;

        if(dp[ind][pre+1] != -1) return dp[ind][pre+1];

        int lenNT = 0 + subseq(ind+1, pre, nums);
        if(pre == -1 || nums[ind] > nums[pre]) {
          int lenTake = 1 + subseq(ind+1, ind, nums);
          dp[ind][pre+1] = Math.max(lenNT, lenTake);
        }
        return dp[ind][pre+1] = lenNT;
    }
}
