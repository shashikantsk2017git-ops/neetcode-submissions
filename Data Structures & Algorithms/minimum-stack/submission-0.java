class MinStack {

    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new int[]{val, val});
        else {
            int[] arr = stack.peek();
            if(arr[1] >= val)
                stack.push(new int[]{val, val});
            else
                stack.push(new int[]{val, arr[1]});
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
