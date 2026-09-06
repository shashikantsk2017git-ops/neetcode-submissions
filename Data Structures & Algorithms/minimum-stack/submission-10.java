class MinStack {

    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<int[]>();
        stack = new Stack<>(); //This is also correct
    }
    
    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);
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
//         stack = new Stack();
//         minStack = new Stack();
//     }
    
//     public void push(int val) {
//         stack.push(val);
//         int min = minStack.isEmpty() ? val : Math.min(val, minStack.peek());
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
