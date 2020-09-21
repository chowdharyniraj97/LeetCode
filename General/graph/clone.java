/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node ==null)
            return null;
         Queue<Node> q = new LinkedList<>();
        q.add(node);
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Node> map = new HashMap<>();
        set.add(node.val);
        Node p = new Node(node.val,new ArrayList<Node>());
        map.put(node.val,p);
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            int val = cur.val;
            List<Node> list = cur.neighbors;
            
            Node new_node = map.get(val);
            
            for(Node x : list){
                if(map.containsKey(x.val)){
                    Node y = map.get(x.val);
                    new_node.neighbors.add(y);
                }
                else{
                    Node y =new Node(x.val,new ArrayList<>());
                    new_node.neighbors.add(y);
                    map.put(y.val,y);
                }
                
                
                
                if(!set.contains(x.val)){
                    q.add(x); // old graph
                    set.add(x.val);
                }
                
                
            }
            
            
            
        }
        
        for(int key : map.keySet())
            return map.get(key);
    
        return null;
     
    }
    
    
}
