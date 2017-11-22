package leetcode;

public class Solution566 {

	public static void main(String[] args) {
		int[][] nums = new int[][]{{1,2},{3,4}};
		Solution566 solution566 = new Solution566();
		int[][] result = solution566.matrixReshape(nums, 4, 1);
		for(int[] arr : result){
			for(int item : arr){
				System.out.print(item +"  ");
			}
			System.out.println();
		}
		
	}
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length == 0 || nums[0].length == 0){
        	return nums;
        }
        
        int temp = nums.length * nums[0].length;
        if(temp != r*c){
        	return nums;
        }
        int index=0;
        int c_source = nums[0].length;
        int[][] result = new int[r][c];
        while(index < temp){
        	result[index/c][index%c] = nums[index/c_source][index%c_source];
        	index++;
        }
        return result;
    }
}
