class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        List<Integer>[] frq = new ArrayList[nums.length+1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(frq[value] == null) {
                frq[value] = new ArrayList<>();
            }
            frq[value].add(key);
        }      

        int[] res = new int[k];
        int ind = 0;
        for(int i = frq.length-1; i >=0; i--) {
            if(frq[i] != null && ind < k) {
                for(int num: frq[i]) {
                    if(ind == k) break;
                    res[ind] = num;
                    ind++;
                }
            }
        }  
        return res;
    }

    public int[] topKFrequent3(int[] nums, int k) {
        return 
        Arrays.stream(nums).boxed().
        collect(Collectors.groupingBy(i -> i, Collectors.counting()))
        .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(k)
        .mapToInt(e -> e.getKey())
        .toArray();
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(k)
        .mapToInt(e -> e.getKey())
        .toArray();
    }


    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        Map<Integer, Integer> sortedMap =  
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(
           Map.Entry::getKey,
           Map.Entry::getValue,
           (e1, e2) -> e1,
           LinkedHashMap::new // preserves insertion order
        ));
        int[] res = new int[k];

        int i = 0;
        for(Map.Entry<Integer, Integer> mp: sortedMap.entrySet()) {
            if(i < k) {
                res[i] = mp.getKey();
                i++;
            }
        }
        return res;
    }


    public int[] topKFrequent0(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);

        Map<Integer, Integer> sortedMap =  
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(
            e -> e.getKey(),
            e -> e.getValue(),
            (e1, e2) -> e1,
            () -> new LinkedHashMap<>() // preserves insertion order
        ));
        int[] res = new int[k];

        int i = 0;
        for(Map.Entry<Integer, Integer> mp: sortedMap.entrySet()) {
            if(i < k) {
                res[i] = mp.getKey();
                i++;
            }
        }
        return res;
    }
}
