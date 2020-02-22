import java.util.*;
class rodCutting{

	 public static void main(String args[]) 
    { 
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        System.out.println("Maximum Obtainable Value is "+ 
                            cutRod(arr, size)); 
  
    } 

    static int cutRod(int arr[],int size){
    	if(size==0)
    		return 0;
    	if(size==1)
    		return arr[0];

    	int max=arr[size-1];
    	for(int i=1;i<size;i++){
    		max=Math.max(max,arr[i-1]+cutRod(arr,size-i));
    	}
    	return max;

    }
}

//============================================MEMO==============================================================
class rodCutting{

static HashMap<Integer,Integer> map;
 public static void main(String args[]) 
    { 
    	map=new HashMap<>();
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        System.out.println("Maximum Obtainable Value is "+ 
                            cutRod(arr, size)); 
  
    } 

    static int cutRod(int arr[],int size){
    	if(size==0)
    		return 0;
    	if(size==1)
    		return arr[0];
    	if(map.containsKey(size))
    		return map.get(size);

    	int max=arr[size-1];
    	for(int i=1;i<size;i++){
    		max=Math.max(max,arr[i-1]+cutRod(arr,size-i));
    	}
    	map.put(size,max);
    	return max;

    }
}