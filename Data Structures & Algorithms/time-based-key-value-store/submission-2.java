class TimeMap {
    Map<String, ArrayList<Pair<Integer, String>>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
       if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
       }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            ArrayList<Pair<Integer, String>> arL = map.get(key);
            int left = 0;
            int right = arL.size() - 1;

            while(left <= right) {
                int mid = (left + right)/2;

                if(arL.get(mid).getKey() <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if(left == 0) return "";
            return arL.get(left-1).getValue();
        }
        return "";
    }
}


// class TimeMap {
//     Map<String, TreeMap<Integer, String>> map;
    
//     public TimeMap() {
//         map = new HashMap<>();
//     }
    
//     public void set(String key, String value, int timestamp) {
//         if(!map.containsKey(key)) {
//             map.put(key, new TreeMap<>());
//         }
//         map.get(key).put(timestamp, value);
//     }
    
//     public String get(String key, int timestamp) {
//         if(map.containsKey(key)) {
//             Integer floorKey = map.get(key).floorKey(timestamp);
//             if(floorKey != null) {
//                 return map.get(key).get(floorKey);
//             }
//         }
//         return "";
//     }
// }
