class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new LinkedList<>();
        for(int i = 0; i<nums.length-2; i++) {
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int threeSum = nums[i]+nums[left]+nums[right];
                if(threeSum == 0) {
                    LinkedList<Integer> found = new LinkedList<>();
                    found.add(nums[i]);
                    found.add(nums[left]);
                    found.add(nums[right]);
                    out.add(found);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if(threeSum < 0) {
                    left++;
                  
                } else {
                    right--;
                }
            }
        }
        return out;
    }
}
