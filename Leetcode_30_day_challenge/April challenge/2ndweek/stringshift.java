class Solution {
    public String stringShift(String s, int[][] shift) {
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++)
            dq.add(i);
        
        for(int arr[] : shift){
            if(arr[0]==1){
                rightshift(dq,arr[1]);
            }
            else{
                leftshift(dq,arr[1]);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!dq.isEmpty())
        {
            sb.append(s.charAt(dq.poll()));
        }   
        return sb.toString();
    }
    
    void rightshift(ArrayDeque<Integer> dq,int amount){
        for(int i=0;i<amount;i++){
            int x=dq.pollLast();
            dq.addFirst(x);
        }
    }
    
     void leftshift(ArrayDeque<Integer> dq,int amount){
        for(int i=0;i<amount;i++){
            int x=dq.pollFirst();
            dq.addLast(x);
        }
    }
}