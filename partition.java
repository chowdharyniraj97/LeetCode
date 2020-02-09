/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class partition {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		while(t-->0){
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		        
		    }
		    int sum=0;
		    for(int i:arr)
		        sum+=i;
		    int min=sum;
		    int x=findmin(arr,0,sum,0);
		    System.out.println(x);
		}
	}
	
	static int findmin(int arr[],int s1,int s2,int i){
	    if(i==arr.length)
	        return Math.abs(s1-s2);
	        
	   int sum1=findmin(arr,s1+arr[i],s2-arr[i],i+1);
	   int sum2=findmin(arr,s1,s2,i+1);
	   return Math.min(sum1,sum2);
	}
}