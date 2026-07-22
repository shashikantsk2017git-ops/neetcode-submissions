class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        generate(0, 0, n, out, new StringBuilder());
        return out;
    }

    public void generate(int open, int close, int n, List<String> out, StringBuilder sb) {

        if(open + close == 2 * n) {
            out.add(new String(sb));
            return;
        }
        if( open < n) {
            sb.append("(");
            generate(open+1, close, n, out, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if( close < open) {
            sb.append(")");
            generate(open, close+1, n, out, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

