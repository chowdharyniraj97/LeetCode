
class Node{
    int span;
    int val;
    Node(int a ,int b)
    {
        span=b;
        val=a;
    }
}
class StockSpanner {
    Stack<Node> st;
    int cur=0;
    public StockSpanner() {
        st=new Stack<>();
        st.push(new Node(Integer.MAX_VALUE,-1));
        cur=0;
    }
    
    public int next(int price) {
        while(price>=st.peek().val){
            st.pop();
        }
        int ans=0;
        //if(st.peek().val!=price)
         ans=cur-st.peek().span;
        //else{
           // ans=st.peek().span+1;
         //   return ans;
       // }
        
        st.push(new Node(price,cur));
        cur++;
        return ans;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
