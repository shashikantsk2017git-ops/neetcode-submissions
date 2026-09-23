class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        
        //if we do not have 0 or -1 subarry will product of all the elements
        //For the case where 0 or -1 comes subarray will either on left(prefix) or right(suffix)
        //SO for each element check if till point what is suffix or prefix 
        //which ever is max will be our output

        int suf = 1;
        int pref = 1;

        //from 0 because here we are not solving except self product prblm
        for(int i = 0; i < nums.length; i++) { 
            if(pref == 0) pref = 1;
            if(suf == 0) suf = 1;       

            pref = pref * nums[i];
            suf = suf * nums[nums.length - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(pref, suf));
        }
        return maxProduct;
    }
}
