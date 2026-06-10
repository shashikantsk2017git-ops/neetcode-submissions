class Solution {
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        cSum(candidates, target, 0, 0, new ArrayList<>());
        return out;
    }

    public void cSum(int[] arr, int target, int index, int sum, List<Integer> list) {

        if(index > arr.length-1 || sum >= target) {
            if(sum == target) {
                out.add(new ArrayList<>(list));
            }
            return;
        }
        sum += arr[index];
        list.add(arr[index]);
        cSum(arr, target, index, sum, list);
        sum -= arr[index];
        list.remove(list.size()-1);
        cSum(arr, target, index+1, sum, list);
    }
}