class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            Integer req = map.get(target - nums[i]);
            if(req != null) {
                res[0] = req;
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
