class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 1)+1);

        List<Integer>[] bucket = new List[nums.length+2]; //because number frq can be 1 to N
        //Array starts from zero so len will be +1 and ends with N-1 but here its N so len +2

        for(int key: map.keySet()) {
            int frq = map.get(key);
            if(bucket[frq] == null) bucket[frq] = new ArrayList<>();
            bucket[frq].add(key);
        }

        int[] out = new int[k];
        int ind = 0;
        for(int i = bucket.length-1; i >=0; i--) {
            if(bucket[i] != null) {
                for(int num: bucket[i]) {
                    if(ind < k)
                        out[ind++] = num; 
                    else 
                        break;
                }    
            }
        }
        return out;
    }

    public int[] topKFrequent1(int[] nums, int k) {
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
