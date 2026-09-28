class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> out = new ArrayList<>();
        generateSubset(nums, 0, new ArrayList<>(), out);
        return out;
    }

    private void generateSubset(int[] nums, int ind, List<Integer> res, List<List<Integer>> out) {
        if(ind == nums.length) {
            if(!out.contains(res))
                out.add(new ArrayList<>(res));
            return;
        }
        //take
        res.add(nums[ind]);
        generateSubset(nums, ind+1, res, out);

        //not take
        res.remove(res.size()-1);
        generateSubset(nums, ind+1, res, out);
    }
}
