class Solution {
public int[] prisonAfterNDays(int[] cells, int N) {
	int rem = ((N-1)%14)+1;
	int temp[] = new int[cells.length];
	for(int day=0; day<rem; day++) {
		for(int i=1; i<temp.length-1; i++) 
			temp[i] = cells[i-1]==cells[i+1]? 1 : 0;
		System.arraycopy(temp, 0, cells, 0, cells.length);
	}
	return cells;
}
    
}
