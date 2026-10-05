class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];

        Arrays.fill(prod, 1);

        for(int i = 1; i < nums.length; i++) {
            prod[i] = prod[i-1] * nums[i-1];
        }

        int sufp = 1;
        for(int i = nums.length - 1; i >= 0 ; i--) {
            prod[i] = prod[i] * sufp;
            sufp = sufp * nums[i];
        }
        return prod;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);

        int n = nums.length;
        
        int sufp = 1;
        int pref = 1;
        for(int i = 0; i < n; i++) {
            prod[i] = prod[i] * pref;
            prod[n - i - 1] = prod[n - i - 1] * sufp;

            pref = pref * nums[i];
            sufp = sufp * nums[n - 1 - i];
        }

        return prod;
    }
}  
