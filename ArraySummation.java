import java.util.*;
class Node{
	int state[][];
	int p;
	int q;
	Node(int s[][],int l,int m){
		state=new int[s.length][s[0].length];
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[0].length;j++){
				state[i][j]=s[i][j];
			}
		}
		p=l;
		q=m;
	}
}
class ArraySummation{
	static Queue<Node> q;
	public static void main(String args[]){
			int start[][]={{1,6,3},{8,7,2},{4,0,5}};
			int p=0;
			int qq=0;
			boolean flag=false;
			int k=0;
			int n=start.length;
			int m=start[0].length;
			int target[][]=new int[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){

					target[i][j]=k++;
				}
			}
			q=new LinkedList<Node>();
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					if(start[i][j]==0){
						p=i;
						qq=j;
						flag=true;
						break;
					}
				}
				if(flag)
					break;
			}
			q.add(new Node(start,p,qq));
			System.out.println(begin(start,target,start.length,start[0].length));


	}

	static int begin(int start[][],int [][] target,int n,int m){
		HashSet<int[][]> vis=new HashSet<>();
		int size;
		int s=1;
		int p =0;
		int qq=0;
		// for(int i=0;i<start.length;i++){
		// 			for(int j=0;j<m;j++){
		// 				if(start[i][j]==0)
		// 				{
  //                            p=i;
  //                            q=j;
  //                            flag=true;
  //                            break;
		// 				}
		// 			}
		// 			if(flag)
		// 				break;
		// 		}
		int steps=0;
		while(!q.isEmpty()){
			size=s;
			s=0;
			for(int k=0;k<size;k++){
				Node cur=q.poll();
				if(compare(cur.state,target))
					return steps;
				
				p=cur.p;
				qq=cur.q;
				//boolean flag=false;
				

				if(p+1<n){
					int temp=cur.state[p][qq];
					cur.state[p][qq]=cur.state[p+1][qq];
					cur.state[p+1][qq]=temp;
					if(!vistied(vis,cur.state)){
					    
					    int new_State[][]=new int[n][m];
					    for(int i=0;i<n;i++){
					    	for(int j=0;j<m;j++){
					    		new_State[i][j]=cur.state[i][j];
					    	}
					    }
					    temp=cur.state[p][qq];
					    cur.state[p][qq]=cur.state[p+1][qq];
					    cur.state[p+1][qq]=temp;
					    q.add(new Node(new_State,p+1,qq));
					    vis.add(new_State);
					    s++;

					}
				}

				if(p-1>=0){
					int temp=cur.state[p][qq];
					cur.state[p][qq]=cur.state[p-1][qq];
					cur.state[p-1][qq]=temp;
					if(!vistied(vis,cur.state)){
					    
					    int new_State[][]=new int[n][m];
					    for(int i=0;i<n;i++){
					    	for(int j=0;j<m;j++){
					    		new_State[i][j]=cur.state[i][j];
					    	}
					    }
					    temp=cur.state[p][qq];
					    cur.state[p][qq]=cur.state[p-1][qq];
					    cur.state[p-1][qq]=temp;
					    q.add(new Node(new_State,p-1,qq));
					    vis.add(new_State);
					    s++;


					}

				}

				if(qq+1<m){
					int temp=cur.state[p][qq];
					cur.state[p][qq]=cur.state[p][qq+1];
					cur.state[p][qq+1]=temp;
					if(!vistied(vis,cur.state)){
					    
					    int new_State[][]=new int[n][m];
					    for(int i=0;i<n;i++){
					    	for(int j=0;j<m;j++){
					    		new_State[i][j]=cur.state[i][j];
					    	}
					    }
					    temp=cur.state[p][qq];
					    cur.state[p][qq]=cur.state[p][qq+1];
					    cur.state[p][qq+1]=temp;
					    q.add(new Node(new_State,p,qq+1));
					    vis.add(new_State);
					    s++;


					}
				}

				if(qq-1>=0){
					int temp=cur.state[p][qq];
					cur.state[p][qq]=cur.state[p][qq-1];
					cur.state[p][qq-1]=temp;
					if(!vistied(vis,cur.state)){
					    
					    int new_State[][]=new int[n][m];
					    for(int i=0;i<n;i++){
					    	for(int j=0;j<m;j++){
					    		new_State[i][j]=cur.state[i][j];
					    	}
					    }
					    temp=cur.state[p][qq];
					    cur.state[p][qq]=cur.state[p][qq-1];
					    cur.state[p][qq-1]=temp;
					    q.add(new Node(new_State,p,qq-1));
					    vis.add(new_State);
					    s++;


					}
				}
				
			}
			steps++;

		}
		return steps;
	}








	static boolean vistied(HashSet<int[][]> dict,int cur[][]){
		if(dict.contains(cur))
			return true;
		return false;
	}
	static boolean compare(int a[][],int target[][]){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(a[i][j]!=target[i][j])
					return false;
			}
		}

		return true;
	}

	

}
