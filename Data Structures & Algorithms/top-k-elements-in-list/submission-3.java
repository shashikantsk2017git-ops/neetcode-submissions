class Solution {
    public int[] topKFrequent(int[] nums, int k) {
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