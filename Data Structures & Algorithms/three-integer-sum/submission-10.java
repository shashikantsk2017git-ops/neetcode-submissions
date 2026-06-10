class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            int beg = i + 1;
            int end = nums.length - 1;
            if(i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while(beg < end) {
                if(nums[i]+nums[beg]+nums[end] < 0) {
                    beg++;
                } else if(nums[i]+nums[beg]+nums[end] == 0) {
                    List<Integer> three = new LinkedList<>();
                    three.add(nums[i]);
                    three.add(nums[beg]);
                    three.add(nums[end]);
                    res.add(three);

                    while(beg < end && nums[beg] == nums[beg+1]) {
                        beg++;
                    }
                    while(beg < end && nums[end] == nums[end-1]) {
                        end--;
                    }
                                        beg++;
                    end--;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
