class MinStack {
    class Pair{
        int val;
        int currMin;
        Pair(int val,int currMin){
            this.val=val;
            this.currMin = currMin;
        }
    }
    private Stack<Pair> stack;

    public MinStack() {

        stack = new Stack<>();
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
            return;
        }
        int min = Math.min(val,stack.peek().currMin);
        stack.push(new Pair(val,min));
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
        
    }
    
    public int getMin() {

        return stack.peek().currMin;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */