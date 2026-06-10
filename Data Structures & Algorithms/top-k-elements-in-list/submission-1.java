class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mem = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];

        //Count frequencey for all unique element
        for(int num: nums) mem.put(num, mem.getOrDefault(num, 0)+1);
        //Keep element in array as per there frequency of occurance
        for(int key: mem.keySet()) {
            int frq = mem.get(key);
            if(bucket[frq] == null) {
                bucket[frq] = new ArrayList<>();
            }
            bucket[frq].add(key);
        }

        //Traverse the array and found out most k
        int[] res = new int[k];
        int count =0;
        for(int i = bucket.length - 1; i>-1; i--) {
            if(bucket[i] != null) {
                for(int key: bucket[i]) {
                    if(count < k)
                        res[count++] = key;
                    else 
                        break;
                }
            }
            if(count >= k) break;
        }
        return res;
    }
}
