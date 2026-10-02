class Solution {
    public List<List<String>> groupAnagrams0(String[] strs) {
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

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] count = new int[26];
            for(char c: str.toCharArray()) {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            if(map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
