
class Point{
    int x,y;
     int dist;
    Point(int d,int a,int b){
        x=a;
        dist=d;
        y=b;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int K=k;
        PriorityQueue<Point> pq=new PriorityQueue(new mySort());
        
        for(int i=0;i<points.length;i++){
             int d=dist(points[i][0],points[i][1]);
            
            if(k==0){
               
                if(d<pq.peek().dist)
                {
                    pq.poll();
                    pq.add(new Point(d,points[i][0],points[i][1]));
                }
            }
            else{
                pq.add(new Point(d,points[i][0],points[i][1]));
                k--;
            }
        }
        
        int ans[][]=new int[K][2];
        for(int i=0;i<K;i++){
            Point p=pq.poll();
            ans[i][0]=p.x;
            ans[i][1]=p.y;
        }
        return ans;
    }
    
    
    
    int dist(int x,int y){
        return (x*x)+(y*y);
        
    }
}


class mySort implements Comparator<Point>{
    public int compare(Point p1,Point p2){
        int d1=p1.x*p1.x+p1.y*p1.y;
        int d2=p2.x*p2.x+p2.y*p2.y;
        if(d1<d2)
            return 1;
        else if(d1>d2)
            return -1;
        return 0;
    }
}
