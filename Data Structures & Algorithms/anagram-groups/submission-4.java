class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        // return new ArrayList<>(map.values());
        // return map.values().stream().collect(Collectors.toList());
        return map.values().stream().toList();
    }
}
