package leetcode;

public class Solution547 {
	
	public static void main(String[] args) {
		Solution547 solution547= new Solution547();
		int[][] arr = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		System.out.println(solution547.findCircleNum(arr));
	}
	
	
    public int findCircleNum(int[][] M) {
    	int result = 0;
    	for(int i = 0;i<M.length;i++){
    		if(M[i][i] !=1){
    			continue;
    		}
    		
    		result++;
            findDFS(M, i, i);
    	}
        return result;
    }
    
    private void findDFS(int[][] M,int row,int column){
    	if( column >= M[0].length || row >= M.length ){
    		return;
    	}
    	
    	for(int i = column;i<M[0].length;i++){
    		if(M[row][i] == 1){
    			M[row][i] = -1;
    			M[i][row] = -1;
    			findDFS(M, i, 0);
    			M[row][row] = -1;
    			M[i][i] = -1;
    		}
    	}
    }
    
    

}
