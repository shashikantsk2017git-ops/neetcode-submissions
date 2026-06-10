class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combination(candidates, 0, 0, target, new ArrayList<>());
        return out;
    }

    public void combination(int[] can, int ind, int sum, int target, List<Integer> list) {

        if(ind == can.length || sum >= target) {
            if(sum == target) {
                out.add(new ArrayList<>(list));
            }
            return;
        }
        //take
        sum = sum + can[ind];
        list.add(can[ind]);
        combination(can, ind, sum, target, list);
        //not take
        sum = sum - can[ind];
        list.remove(list.size()-1);
        combination(can, ind+1, sum, target, list);
    }
}