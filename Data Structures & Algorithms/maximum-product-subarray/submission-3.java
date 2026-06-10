class Solution {
    public int maxProduct(int[] nums) {
        int prep = 1;
        int sufp = 1;
        int maxp = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(prep == 0) prep = 1;
            if(sufp == 0) sufp = 1;

            prep = prep * nums[i];
            sufp = sufp * nums[nums.length-1 -i];

            maxp = Math.max(maxp, Math.max(prep, sufp));
        }
        return maxp;
    }
}