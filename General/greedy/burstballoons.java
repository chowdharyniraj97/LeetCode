class Solution {
    Stack<Interval> st;
    public int findMinArrowShots(int[][] points) {
        List<Interval> list = new ArrayList<Interval>();
        Stack<Interval> st = new Stack<>();
        
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y= points[i][1];
            Interval cur = new Interval(x,y);
            
            list.add(cur);
        }
        Collections.sort(list,new mySort());
        
        for(Interval  x  : list){
            System.out.println(x.s+" "+x.e);
        }
        int count =0;
        int i =0;
        int start;
        int end;
        if(list.size()==0){
            return 0;
        }
        Interval initial = list.get(list.size()-1);
        
        st.add(initial);
        for( i=list.size()-2;i>=0;i--){
            Interval cur = list.get(i);
            Interval top = st.peek();
            if(top.s<=cur.e){
                st.pop();
                cur.s = Math.max(top.s,cur.s);
            }
            st.push(cur);
        }
        return st.size();
    }
}


class Interval{
    int s;
    int e;
    Interval(int a,int b){
        s=a;
        e=b;
    }
}

class mySort implements Comparator<Interval>{
    public int compare(Interval i1,Interval i2){
//         int x = i1.e-i1.s;
//         int y=i2.e-i2.s;
        
//         if(x<y)
//             return 1;
//         else
//             return -1;
        
        if(i1.e!=i2.e)
            return i1.e-i2.e;
        else{
            return i1.s-i2.s;
        }
    }
}




/*
find the overlapping sets
count those set
those many arrows required



*/
