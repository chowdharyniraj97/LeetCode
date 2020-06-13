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
       int ans[][];
        int gg=0;
    public int[][] kClosest(int[][] points, int k) {
        int K=k;
        gg=k;
           ans=new int[K][2];
           
        Point klist[]=new Point[points.length];
           
        for(int i=0;i<points.length;i++){
            klist[i]=new Point(dist(points[i][0],points[i][1]),points[i][0],points[i][1]);
            
        }
           
        int low=0;int high=points.length-1;
        
         quickselect(klist,low,high);
         return ans;
        
    }
    
    
    
    int dist(int x,int y){
        return (x*x)+(y*y);
        
    }
    
    int sort(Point[] list,int low,int high,int current){
        
        int pindex=low;
        int i=low;
        
        while(i<=high){
            if(list[i].dist<=list[current].dist){
                Point temp=list[pindex];
                list[pindex]=list[i];
                list[i]=temp;
                pindex++;
            }
          
            i++;
            
            
        }
         Point temp=list[pindex];
                list[pindex]=list[current];
                list[current]=temp;
        
        return pindex;
        
        
    }
    
    void quickselect(Point[] klist,int low,int high){
        while(low<=high){
            int p= sort(klist,0,high-1,high);
            System.out.println(p);
            if(p<gg-1){
                quickselect(klist,p+1,high);
                return;
            }
            else if(p>gg-1){
                 quickselect(klist,low,p-1);
                return;
                
            }
            
            else  {
                 for(int i=0;i<gg;i++){
                    ans[i][0]=klist[i].x;
                    ans[i][1]=klist[i].y;
                    }
                  return;
         }
                
        }
    }
}

