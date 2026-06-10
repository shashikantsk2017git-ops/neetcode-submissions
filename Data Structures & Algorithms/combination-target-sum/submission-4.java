class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candi, int target) {
        findCombination(candi, target, 0, new ArrayList<>());
        return out;
    }

    public void findCombination(int[] candi, int target, int ind, List<Integer> list) {

        if(ind >= candi.length || target <= 0) {
            if(target == 0) {
                out.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(candi[ind]);
        findCombination(candi, target-candi[ind], ind, list);

        list.remove(list.size()-1);
        findCombination(candi, target, ind+1, list);
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