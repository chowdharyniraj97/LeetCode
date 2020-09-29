class RandomizedSet {
    HashMap<Integer,Node> map;
    HashMap<Integer,Integer> map2;
    int size;
    Node head;
    Node last;
    int index;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        map2 = new HashMap<>();
        size = 0;
        head = null;
        last= null;
        index = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Node x = map.get(val);
        if(x != null)
            return false;
        
        Node n =new Node(val);
        
        if(size == 0) {
           head = last = n;
           
        } 
        
        else {
            last.next = n;
            n.prev = last;
            last =n;
            
        }
        map.put(val , n);
        map2.put(index++,val);
        size++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Node x = map.get(val);
        System.out.println(x);
        if(x == null)
            return false;
        
        if(head == last ) {
            head =null;
            last = null;
        }
        
       else if(x == head) {
            head = head.next;
            head.prev = null;
            
           
        }
        else if(x == last ) {
            last = last.prev;
            last.next = null;
          
                
        }
        else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            
        }
         map.remove(val);
            size--;
            index--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int rand = random.nextInt(size);
        
        int cur = 0;
        Node c = head;
        
        while(cur!=rand && c!=null) {
            c = c.next;
            cur++;
        }
        if(c!=null)
        return c.val;
        
        return 0;
        
    }
}


class Node { 
    Node prev;
    Node next;
    int val;
    Node(int c) {
        val  = c;
        prev= null;
        next = null;
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
