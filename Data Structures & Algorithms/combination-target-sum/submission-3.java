class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candi, int target) {
        findCombination(candi, target, 0, out, new ArrayList<>());
        return out;
    }

    public void findCombination(int[] candi, int target, int ind, List<List<Integer>> out, List<Integer> list) {

        if(ind >= candi.length || target <= 0) {
            if(target == 0) {
                out.add(new ArrayList<>(list));
            }
            return;
        }
        // sum += candi[ind];
        list.add(candi[ind]);
        findCombination(candi, target-candi[ind], ind, out, list);

        // sum -= candi[ind];
        list.remove(list.size()-1);
        findCombination(candi, target, ind+1, out, list);
    }
}