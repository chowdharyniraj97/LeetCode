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

//============================================bottom up============================================

class rodCutting{

 public static void main(String args[]) 
    { 
    	
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20,65,123}; 
        int ans[];
        int size = arr.length; 
        ans=new int[size+1];
        ans[0]=0;
        System.out.println("Maximum Obtainable Value is "+ 
                            cutRod(arr, size,ans)); 
  
    } 

    static int cutRod(int arr[],int size,int ans[]){
    	int index=-1;
    	int s[]=new int[size+1];
    	for(int i=1;i<=size;i++){
    		ans[i]=arr[i-1];
    		 s[i] = i;
    		for(int j=i;j>=1;j--)
    		{
    			if(ans[i]<arr[j-1]+ans[i-j]){
    			    			ans[i]=arr[j-1]+ans[i-j];
    			    			s[i]=j;


    			    		}
    		}
    		
    	}
    	int sk=size;
    	while(size>0)
    	{
    		System.out.print(s[size]+" ");
    		size-=s[size];
    	}
    	System.out.println();
    	return ans[sk];

    }
}
