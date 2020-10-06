class Node {
    int val;
    int count;
    Node(int val,int count){
        this.val = val;
        this.count = count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         int ans[] = new int[k];
        if(k == 0)
            return ans;
       PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
           public int compare(Node x, Node y) {
               return Integer.compare(x.count, y.count);
           }
       });
       Map<Integer,Node> map = new HashMap<>();
        //  3 1 
        //1-->2
        for(int x : nums) {
            Node p = null;
            if (map.containsKey(x)) {
                p = map.get(x);
                p.count++;
            }
            else {
                 p = new Node(x,1);
                 map.put(x,p);
                
            }
            if(pq.contains(p))
            {
                pq.remove(p);
                pq.add(p);
                continue;
            }
            if(k>0 && !pq.contains(p)) {
                pq.add(p);
                k--;
            }
            else{
                if(pq.peek().count < p.count)
                {
                    pq.poll();
                    pq.add(p);
                }
            }
           
        }
       int ind = 0;
        while(!pq.isEmpty()) {
            Node x = pq.poll();
            ans[ind++] = x.val;
        }
        return ans;
        
    }
}
