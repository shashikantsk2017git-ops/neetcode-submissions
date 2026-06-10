class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> out = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);

            if(map.containsKey(temp)) {
                map.get(temp).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        return map.values().stream().toList();
    }
}
