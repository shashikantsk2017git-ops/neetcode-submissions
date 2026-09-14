class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int arrSum = 0;
        for(int i = 0; i <= nums.length; i++) sum ^= i;
        for(int i = 0; i < nums.length; i++) arrSum ^= nums[i];

        return sum ^ arrSum;
    }

    public int missingNumber1(int[] nums) {
        int sum = 0;
        int arrSum = 0;
        for(int i = 0; i <= nums.length; i++) sum += i;
        for(int i = 0; i < nums.length; i++) arrSum += nums[i];

        return sum - arrSum;
    }

    public int missingNumber0(int[] nums) {
        Arrays.sort(nums);
        int n = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != n) return n;
            n++;
        }
        return n;
    }
}
