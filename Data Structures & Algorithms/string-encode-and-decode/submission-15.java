class Solution {
    String delimeter = "/:";

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str).append(delimeter);
        }
        return new String(sb);
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        String[] strs = str.split(delimeter, -1);

        for(int i = 0; i < strs.length-1; i++) 
            res.add(strs[i]);
        return res;
        
    }
}

