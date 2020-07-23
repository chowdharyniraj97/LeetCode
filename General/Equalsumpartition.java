//Check if array can be partitioned into 2 parts having same sum
//copy this to following link:
//https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static HashMap<Integer, Boolean> map;
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
		    int sum=0;
		    for(int i:arr)
		        sum+=i;
		    int min=sum;
		   if(min%2!=0)
		    System.out.println("NO");
		   else{
		    if(findmin(arr,0,sum,0))
		    System.out.println("YES");
		    else
		    System.out.println("NO");
		   }
		}
	}
	
	static boolean findmin(int arr[],int s1,int s2,int i){
	   boolean b=false;
	    if(map.containsKey(s1)||map.containsKey(s2))
	    return map.get(s1)||map.get(s2);
	    if(s1==s2)
	    {
	       // ispossi=true;
	        return true;
	    }
	   if(i==arr.length)
	        return false;
	    if(s1>s2)
	        return false ;
	   boolean a=findmin(arr,s1+arr[i],s2-arr[i],i+1);
	   if(!a)
	    b=findmin(arr,s1,s2,i+1);   
	   map.put(s1,a||b);
	   map.put(s2,a||b);
	   return a||b;
	  
	}
}