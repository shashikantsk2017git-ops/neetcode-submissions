class Solution {
    public int[] topKFrequentdsfa(int[] nums, int k) {
        Map<Integer, Integer> mem = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];

        //Count frequencey for all unique element
        for(int num: nums) mem.put(num, mem.getOrDefault(num, 0)+1);
        int len = bucket.length;
        //Keep element in array as per there frequency of occurance
        for(int key: mem.keySet()) {
            int frq = mem.get(key);
            if(bucket[len-frq] == null) {
                bucket[len-frq] = new ArrayList<>();
            }
            bucket[len-frq].add(key);
        }

        //Traverse the array and found out most k
        int[] res = new int[k];
        int count =0;
        for(List<Integer> buck: bucket) {
            if(buck != null && count < k) {
                for(int key: buck) {
                    if(count < k)
                        res[count++] = key;
                    else 
                        break;
                }
            }
            if(count >= k) break;
        }
        // for(int i = bucket.length - 1; i>-1; i--) {
        //     if(bucket[i] != null) {
        //         for(int key: bucket[i]) {
        //             if(count < k)
        //                 res[count++] = key;
        //             else 
        //                 break;
        //         }
        //     }
        //     if(count >= k) break;
        // }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 1)+1);

        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(k)
                    .mapToInt( e-> e.getKey())
                    .toArray();
    }
}

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int[] out = new int[nums.length];

//         for(int num: nums) map.put(num, map.getOrDefault(num, 1)+1);

//         Map<Integer, Integer> sortedByValue = map.entrySet()
//             .stream()
//             .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//             .collect(Collectors.toMap(
//                 Map.Entry::getKey,
//                 Map.Entry::getValue,
//                 (e1, e2) -> e1,
//                 LinkedHashMap::new  // preserves insertion order
//         ));

//         int index = 0;
//         for(Map.Entry<Integer, Integer> e: sortedByValue.entrySet()) {
//             if(index != k) {
//                 out[index++] = e.getKey();
//             } else {
//                 break;
//             }
//         }
//         return Arrays.copyOfRange(out, 0, index);
//     }
// }
