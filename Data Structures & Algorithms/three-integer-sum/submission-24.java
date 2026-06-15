class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    out.add(triplet);
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right &&nums[right-1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return out;
    }
}
