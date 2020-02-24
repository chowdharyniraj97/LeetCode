/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println(compute(arr,0,arr.length-1));
		}
	}
	
	static int compute(int arr[],int i,int j){
	    if(i==j)
	    return 0;
	    if(j-i==1)
	        return 0;
	        
	    if(j-i+1==3)
	    {
	        return arr[i]*arr[i+1]*arr[j];
	    }
	    
	   int a=0;
	   int b=0;
	   int min=Integer.MAX_VALUE;
	   int k=0;
	   for( k=i+1;k<j;k++){
            a=compute(arr,i,k);
            b=compute(arr,k,j);
         
            min=Math.min(min,arr[i]*arr[k]*arr[j]+a+b);
	   }
	 
	   return min;
	}
}

//-----------------------------------Matrix Mult---------------------------------------------------

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static HashMap<String,Integer> map;
	public static void main (String[] args) {
	    
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    map=new HashMap<>();
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println(compute(arr,0,arr.length-1));
		}
	}
	
	static int compute(int arr[],int i,int j){
	    if(i==j)
	    return 0;
	    if(j-i==1)
	        return 0;
	        
	    if(j-i+1==3)
	    {
	        return arr[i]*arr[i+1]*arr[j];
	    }
	    
	    if(map.containsKey(i+"|"+j))
	        return map.get(i+"|"+j);
	    
	   int a=0;
	   int b=0;
	   int min=Integer.MAX_VALUE;
	   int k=0;
	   for( k=i+1;k<j;k++){
            a=compute(arr,i,k);
            b=compute(arr,k,j);
         
            min=Math.min(min,arr[i]*arr[k]*arr[j]+a+b);
            
	   }
	  // System.out.println(i+" "+j+" "+min);
	   // map.put(i+"|"+j,min);
	   return min;
	}
}