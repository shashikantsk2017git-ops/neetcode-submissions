class Solution {
    public boolean hasDuplicate0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public boolean hasDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            //If value present then false if new value return true
            if(!set.add(num)) return true;
        }
        return false;
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) if(!set.add(num)) return true;
        return false;
    }
}