class Solution {
    public int maxProduct(int[] nums) {
        int maxP = Integer.MIN_VALUE;
        int pro = 1;

        int pp = 1;
        int suf = 1;
        for(int i = 0; i < nums.length; i++) {
            if(pp == 0) pp = 1;
            pp = pp * nums[i];
            maxP = Math.max(maxP, pp);
        }

        for(int i = nums.length-1; i>=0; i--) {
            if(suf == 0) suf = 1;
            suf = suf * nums[i];
            maxP = Math.max(maxP, suf);
        }

        return maxP;
    }
}
