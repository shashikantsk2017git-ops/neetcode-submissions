class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums) sum = sum ^ num;

        int sumShould = 0;
        for(int i = 0; i <= nums.length; i++) sumShould = sumShould ^ i;

        return sumShould ^ sum;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0;
        for(int num: nums) sum+=num;

        int sumShould = 0;
        for(int i = 0; i <= nums.length; i++) sumShould += i;

        return sumShould - sum;
    }
}
