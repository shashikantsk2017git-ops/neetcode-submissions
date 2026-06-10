class Solution {
    public int lengthOfLIS(int[] nums) {
        // return subseq(0, -1, nums);
        // int[][] dp = new int[nums.length][nums.length+1];
        // for(int i = 0; i < nums.length; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return subseq(0, -1, nums, dp);
        return subseq(nums);
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
          return dp[ind][pre+1] = Math.max(lenNT, lenTake);
        }
        return dp[ind][pre+1] = lenNT;
    }

    public int subseq(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i = nums.length - 1; i >=0; i--) {
            for(int prev = i - 1; prev >=-1; prev--) {

                int lenNT = 0 + dp[i+1][prev+1];

                if(prev == -1 || nums[i] > nums[prev]) {
                    int lenTake = 1 + dp[i+1][i+1];
                    lenNT = Math.max(lenNT, lenTake);
                }
                dp[i][prev+1] = lenNT;
            }
        }
        return dp[0][0];
    }
}
