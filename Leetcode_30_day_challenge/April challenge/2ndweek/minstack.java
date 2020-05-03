class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        st=new Stack<>();
        min=new Stack<>();
    }
    
    public void push(int x) {
        if(st.isEmpty()){
            st.push(x);
            min.push(x);
            return;
        }
       if(x<=min.peek())
           min.push(x);
        st.push(x);
    }
    
    public void pop() {
        int t=st.pop();
        if(t==min.peek())
            min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */