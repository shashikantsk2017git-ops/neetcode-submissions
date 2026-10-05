class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];

        Arrays.fill(prod, 1);

        for(int i = 1; i < nums.length; i++) {
            prod[i] = prod[i-1] * nums[i-1];
        }

        int sufp = 1;
        for(int i = nums.length - 2; i >= 0 ; i--) {
            sufp = sufp * nums[i+1];
            prod[i] = prod[i] * sufp;
        }
        return prod;
    }

    public int[] productExceptSelf1(int[] nums) {
        int[] prod = new int[nums.length];
        Arrays.fill(prod, 1);

        int n = nums.length;
        
        int sufp = 1;
        for(int i = 1; i < n; i++) {
            prod[i] = prod[i-1] * nums[i - 1];
            prod[n - 1 - i] = prod[n - 1 - i] * sufp;
            sufp = sufp * nums[n - 1 - i];
        }

        return prod;
    }
}  
