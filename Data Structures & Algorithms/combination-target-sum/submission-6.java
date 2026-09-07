class Solution {
    List<List<Integer>> out = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combination(nums, 0, target, new LinkedList<>());
        return out;
    }

    public void combination(int[] nums, int ind, int target, List<Integer> list) {

        if(ind == nums.length || target <= 0) {
            if(target == 0) {
                out.add(new LinkedList<>(list));
            }
            return;
        }
        //take
        list.add(nums[ind]);
        combination(nums, ind, target-nums[ind], list);

        //not take
        list.remove(list.size()-1);
        combination(nums, ind+1, target, list);
    }
}
