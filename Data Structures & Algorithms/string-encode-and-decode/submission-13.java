class Solution {
    String delimeter = "/:";

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) sb.append(str).append(delimeter);
        return new String(sb);
    }

    public List<String> decode(String str) {
        List<String> res = new LinkedList<>();
        // int prev = 0;
        // for(int i = 0; i<str.length(); i++) {
        //     if(str.substring(i, i+2).equals(delimeter)) {
        //         res.add(str.substring(prev, i));
        //         prev = i+2;
        //         i++;
        //     }
        // }
        String[] arr = str.split(delimeter, -1);
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length-1; i++) res.add(arr[i]);
        return res;
    }
}
