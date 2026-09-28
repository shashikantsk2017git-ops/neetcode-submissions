class Solution {
    //Array has only 1 to n possitive numbers
    //go to each number values index and make it negitive if already negivite means
    //it alreay been made checked so duplicate
    public int findDuplicate0(int[] nums) {
        int duplicate = -1;
        for(int i = 0;i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if(nums[curr] < 0) {
                duplicate = curr;
                break;
            }
            nums[curr] = nums[curr] * -1;
        }

        //restore the array as problme says do not chnage array
        for(int i = 0;i < nums.length; i++) nums[i] = Math.abs(nums[i]);

        return duplicate;
    }

    //Will use linked list approach
    //where we can assume each number value is index for another value 
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast) {
            //one step
            slow = nums[slow];
            //two step
            fast = nums[nums[fast]];
        }

        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
