class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i = temperatures.length - 1; i>=0; i--) {

            while(!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek()[1] - i;
            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}
