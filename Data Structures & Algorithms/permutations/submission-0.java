class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();

        permutation(nums, 0, out);
        return out;
    }

    public void permutation(int[] nums, int ind, List<List<Integer>> out) {
        if(ind > nums.length-1) {
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                res.add(nums[i]);
            }
            out.add(res);
        }

        for(int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            permutation(nums, ind+1, out);
            swap(ind, i, nums);
        }
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
