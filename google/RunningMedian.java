class MovingAverage {

    /** Initialize your data structure here. */
    int startEle;
    int currentIndex = -1;
    double sum = 0;
    int count = 0;
    int size =0;
    Queue<Integer> q;
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
       q.add(val);
        count++;
        if(count <=size) {
            sum+=val;
            return (sum)/count;
        }
        else { // size ==
            // System.out.println(q.size()+" "+ sum);
            sum-= q.poll();
            sum+=val;
            return sum/size;
            
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 
 
 we want the median odd number or even number
 if stream size is less than window we return entire average
 pointer i at start and as size increases remove ith element from the sum and return average
 */
