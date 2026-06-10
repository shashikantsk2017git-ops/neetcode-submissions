class Solution {
    public int maxProduct(int[] nums) {
        int prep = 1;
        int sufp = 1;
        int max = Integer.MIN_VALUE;
        int n  = nums.length;

        for(int i = 0; i < n; i++) {
            if(prep == 0) prep = 1;
            if(sufp == 0) sufp = 1;
            prep *= nums[i];
            sufp *= nums[n-1-i];

            max = Math.max(Math.max(prep, sufp), max);
        }
        return max;
    }
}
