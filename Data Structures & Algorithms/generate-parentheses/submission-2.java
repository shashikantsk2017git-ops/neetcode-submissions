class Solution {
    List<String> out = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new StringBuilder());
        return out;
    }
    
    private void generate(int n, int open, int close, StringBuilder sb) {
        if(open == n && close == n) {
            out.add(new String(sb));
            sb = new StringBuilder();
        }
        if(open < n) {
            sb.append("(");
            generate(n, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open) {
            sb.append(")");
            generate(n, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
