class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int num: nums) {
            if(sum < 0) sum = 0;
            sum += num;
            max = Math.max(sum, max);
        }
        return max;
    }
}

// nt prefix = 0;
//         int suffix = 0;

//         int maxSum = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++) {
//             if(prefix < 0) {
//                 prefix = 0;
//             } 
//             if(nums[nums.length-i-1] <0 ) {
//                 suffix = 0;
//             }
//             suffix = suffix+nums[nums.length-i-1];
//             prefix = prefix+nums[i];
//             maxSum = Math.max(suffix, maxSum);
//             maxSum = Math.max(prefix, maxSum);
//         }

//         return maxSum;
