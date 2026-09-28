class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> out = new HashMap<>();
        generateSubset(nums, 0, new ArrayList<>(), new StringBuilder(), out);
        return new ArrayList<>(out.values());
    }

    private void generateSubset(int[] nums, int ind, List<Integer> res, StringBuilder sb,
    Map<String, List<Integer>> out) {
        if(ind == nums.length) {
            String key = new String(sb);
            if(!out.containsKey(key)) {
                out.put(key, new ArrayList<>(res));
            }
            return ;
        }
        //take
        res.add(nums[ind]);
        sb.append((char)nums[ind]);
        generateSubset(nums, ind+1, res, sb, out);

        //not take
        res.remove(res.size()-1);
        sb.deleteCharAt(sb.length()-1);
        generateSubset(nums, ind+1, res, sb, out);
    }
}
