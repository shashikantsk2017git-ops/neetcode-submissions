class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];

        Arrays.fill(prod, 1);

        int prefP = 1;
        for(int i = 1; i < nums.length; i++) {
            prefP = prefP * nums[i-1];
            prod[i] = prefP;
        }

        int sufp = 1;
        for(int i = nums.length - 2; i >= 0 ; i--) {
            sufp = sufp * nums[i+1];
            prod[i] = prod[i] * sufp;
        }
        return prod;
    }
}  
