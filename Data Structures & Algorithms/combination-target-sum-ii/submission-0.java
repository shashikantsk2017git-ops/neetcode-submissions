class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombination(candidates, target, 0, new ArrayList<>());
        return out;
    }

    public void findCombination(int[] candi, int target, int ind, List<Integer> list) {

        if(ind >= candi.length || target <= 0) {
            if(target == 0) {
                if(!out.contains(list))
                    out.add(new ArrayList<>(list));
            }
            return;
        }
        //take
        list.add(candi[ind]);
        findCombination(candi, target-candi[ind], ind+1, list);

        //not take
        list.remove(list.size()-1);
        int next = ind + 1;
        while(next < candi.length && candi[next] == candi[ind]) {
            next++;
        }
        findCombination(candi, target, next, list);
    }
}
