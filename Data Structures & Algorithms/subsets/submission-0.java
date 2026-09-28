class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generateSubset(nums, 0, new ArrayList<>());
        return out;
    }

    private void generateSubset(int[] nums, int ind, List<Integer> res) {
        if(ind == nums.length) {
            out.add(new ArrayList<>(res));
            return ;
        }
        //take
        res.add(nums[ind]);
        generateSubset(nums, ind+1, res);

        //not take
        res.remove(res.size()-1);
        generateSubset(nums, ind+1, res);
    }
}
