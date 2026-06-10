class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);

            if(!map.containsKey(temp)) {
                List<String> list = new ArrayList<>();
                map.put(temp, list);
            }
            map.get(temp).add(str);
        }
        // return map.values().stream().toList();
        return new ArrayList<>(map.values());
    }
}
