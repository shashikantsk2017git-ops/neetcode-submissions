class Solution {
    List<List<Integer>> out = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combination(nums, 0, target, 0, new LinkedList<>());
        return out;
    }

    public void combination(int[] nums, int ind, int target, int sum, List<Integer> list) {

        if(ind == nums.length || sum >= target) {
            if(sum == target) {
                out.add(new LinkedList<>(list));
            }
            return;
        }
        //take
        sum += nums[ind];
        list.add(nums[ind]);
        combination(nums, ind, target, sum, list);

        //not take
        sum -= nums[ind];
        list.remove(list.size()-1);
        combination(nums, ind+1, target, sum, list);
    }
}
