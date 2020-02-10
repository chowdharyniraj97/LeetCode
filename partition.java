/*package whatever //do not write package name here */
// Copy either of the code to https://practice.geeksforgeeks.org/problems/minimum-sum-partition/0
// ------------------------------recursive way--------------------------------------------------------------------------
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

//-----------------------------------------------------------------------dp---------------------------------------------------------


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
	
		while(t-->0){
		 // map=new HashMap<>();
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		        
		    }
		    int sum=0;
		    for(int i:arr)
		        sum+=i;
		        
		    boolean dp[][]=new boolean[n+1][sum/2+1];
		  //  for(int i=0;i<dp[0].length;i++)
		  //      dp[0][i]=false;
		  
		   for(int i=0;i<dp.length;i++){
		       dp[i][0]=true;
		   }
		   findsubsets(arr,dp);
		   for(int j=sum/2;j>=0;j--){
		       if(dp[n][j]){
		          int other=sum-j;
		          System.out.println(Math.abs(other-j));
		          break;
		           
		           
		       }
		   }
		    
		}
		
	}
	
	
		static void findsubsets(int arr[],boolean dp[][]){
		    for(int i=1;i<dp.length;i++){
		        for(int j=1;j<dp[0].length;j++){
		            dp[i][j]=dp[i-1][j];
		            if(j>=arr[i-1])
		                dp[i][j]=dp[i][j] || dp[i-1][j-arr[i-1]];
		        }
		    }
		    
		    
		}
	
	 
}