class MinStack {

    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(stack.peek()[1], val);
        stack.push(new int[]{val, min});
    }
    
    public void pop() {
       stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
       return stack.peek()[1];
    }
}

// class MinStack {

//     Stack<Integer> stack;
//     Stack<Integer> minStack;
//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         int min = stack.isEmpty() ? val : Math.min(minStack.peek(), val);
//         stack.push(val);
//         minStack.push(min);
//     }
    
//     public void pop() {
//         stack.pop();
//         minStack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }
