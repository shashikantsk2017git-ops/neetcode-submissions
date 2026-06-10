class Solution {

    public String encode(List<String> strs) {
        String delimeter = "/:";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<strs.size(); i++) {
            sb.append(strs.get(i)).append(delimeter);
        }
        return new String(sb);
    }

    public List<String> decode(String str) {
        String delimeter = "/:";
        List<String> res = new LinkedList<>();
        int prev = 0;
        for(int i = 0; i<str.length(); i++) {
            if(str.substring(i, i+2).equals(delimeter)) {
                res.add(str.substring(prev, i));
                prev = i+2;
                i++;
            }
        }
        System.out.println(res);
        return res;
    }
}
