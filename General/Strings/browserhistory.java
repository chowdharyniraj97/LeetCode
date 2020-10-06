class BrowserHistory {
    Stack<String> current;
    Stack<String> back;
    public BrowserHistory(String homepage) {
        current = new Stack<>();
        back = new Stack<>();
        current.push(homepage);
    }
    
    public void visit(String url) {
        current.push(url);
        if(!back.isEmpty()) {
            back.clear();
        }
    }
    
    public String back(int steps) {
        if(steps >= current.size()) {
            steps= current.size() - 1;
        }
        
        while(steps > 0) {
            String url = current.pop();
            back.push(url);
            steps--;
        }
        return current.peek();
    }
    
    public String forward(int steps) {
        if(steps > back.size()) {
            steps = back.size();
        }
        
        while(steps > 0) {
            String url = back.pop();
            current.push(url);
            steps--;
        }
        return current.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
