class sortNode implements Comparator<Node>{
    public int compare(Node n1,Node n2){
        return n1.time-n2.time;
    }
}
class Node{
    int key;
    int time;
    Node(int a,int b){
        key=a;
        time=b;
    }
}
class LRUCache {
    int currentsize=0;
    int timer=0;
    int size=0;
    PriorityQueue <Node> pq;
    HashMap<Integer,Node> map=new HashMap<>();
    HashMap<Integer,Integer> m;
    public LRUCache(int capacity) {
       pq =new PriorityQueue<>(10,new sortNode());
        m=new HashMap<>();
        size=capacity;
        
    }
    
    public int get(int key) {
        if(m.containsKey(key)){
            int y=m.get(key);
            Node x=map.get(key);
            pq.remove(x);
            x.time=++timer;
            pq.add(x);
            return y;
            
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            m.put(key,value);
            map.get(key).time=++timer;
            pq.remove(map.get(key));
            pq.add(map.get(key));
        }
        else if(currentsize==size){
            Node k=pq.poll();
            m.remove(k.key);
            map.remove(k.key);
            currentsize--;
            Node x=new Node(key,timer++);
            pq.add(x);
            m.put(key,value);
            map.put(key,x);
            currentsize++;
        }
        else
        {
            Node x=new Node(key,timer++);
            pq.add(x);
            m.put(key,value);
            map.put(key,x);
            currentsize++;
            
        }
        
    }
}