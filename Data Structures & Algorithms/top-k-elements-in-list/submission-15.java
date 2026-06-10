class Solution {
    public int[] topKFrequent0(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int key: map.keySet()) {
            int frq = map.get(key);
            if(buckets[frq] == null) {
                buckets[frq] = new ArrayList<>();
            }
            buckets[frq].add(key);
        }

        // int[] res = new int[nums.length];
        int[] res = new int[k];
        int ind = 0;
        for(int i = buckets.length-1; i >=0; i--) {
            if(buckets[i] != null && k > 0) {
                for(int el: buckets[i]) {
                    if(k >0) {
                        res[ind++] = el;
                        k--;
                    }
                }
            }
        }

        // return Arrays.copyOfRange(res, 0, ind);
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        return map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(k)
        .mapToInt(e -> e.getKey())
        .toArray();
    }

    public int[] topKFrequent(int[] nums, int k) {

        return Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(k)
        .mapToInt(e -> e.getKey())
        .toArray();
    }


    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[nums.length];

        for(int num: nums) map.put(num, map.getOrDefault(num, 1)+1);

        Map<Integer, Integer> sortedByValue = map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1,
                LinkedHashMap::new  // preserves insertion order
        ));

        int index = 0;
        for(Map.Entry<Integer, Integer> e: sortedByValue.entrySet()) {
            if(index != k) {
                out[index++] = e.getKey();
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(out, 0, index);
    }
}