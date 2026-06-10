class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int ps = 0;
        int ss = 0;
        for(int i = 0; i < nums.length; i++) {
            if(ps < -1 ) ps = 0;
            if(ss < -1) ss = 0;
            ps = ps + nums[i];
            ss = ss + nums[nums.length - 1 -i];

            max = Math.max(max, Math.max(ps, ss));
        }
        return max;
    }
}
