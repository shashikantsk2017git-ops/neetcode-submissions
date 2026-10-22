class Solution {
    public int subarraySum0(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) count++;
            }
        }

        return count;
    }


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int prefixTarget = prefixSum - k;
            if(map.containsKey(prefixTarget)) {
                count += map.get(prefixTarget);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }

        return count;
    }
}