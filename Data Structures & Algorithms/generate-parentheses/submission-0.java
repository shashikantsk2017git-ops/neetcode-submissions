class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        generate(output, n, 0, 0, new StringBuilder());
        return output;
    }

    public void generate(List<String> output, int n, int open, int close, StringBuilder sb) {
        if(open > n || close > n) return;
        if(sb.length() == n*2) {
            output.add(new String(sb));
            return;
        }
        if(open < n) {
            generate(output, n, open+1, close, sb.append('('));
            sb.deleteCharAt(sb.length() - 1);
        } 
        if(close < open) {
            generate(output, n, open, close+1, sb.append(')'));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}