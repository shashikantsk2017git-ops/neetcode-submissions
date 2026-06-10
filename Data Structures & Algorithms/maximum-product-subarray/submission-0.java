class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int pp = 1;
        int sp = 1;

        for(int i = 0; i < nums.length; i++) {
            if(pp == 0) {
                pp = 1;
            }
            if(sp == 0) {
                sp = 1;
            }
            pp = pp * nums[i];
            sp = sp * nums[nums.length-i-1];
            max = Math.max(max, Math.max(pp, sp));
        }
        return max;
    }
}
