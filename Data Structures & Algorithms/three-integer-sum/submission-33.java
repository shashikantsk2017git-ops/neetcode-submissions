class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                if(nums[i]+nums[left]+nums[right] == 0) {
                    List<Integer> trip = new ArrayList<>();
                    trip.add(nums[i]);
                    trip.add(nums[left]);
                    trip.add(nums[right]);
                    out.add(trip);
                    while(left < right && nums[left] == nums[left+1])
                        left++;
                    while(left < right && nums[right-1] == nums[right])
                        right--;    
                    left++;
                    right--;
                } else if(nums[i]+nums[left]+nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return out;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        Set<String> keys = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        triplet.sort(null);
                        String key = triplet.get(0)+""+triplet.get(1)+""+triplet.get(2);
                        if(!keys.contains(key)) {
                            out.add(triplet);
                            keys.add(key);
                        }
                    }
                }
            }
        }
        return out;
    }
}
