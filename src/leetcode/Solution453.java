package leetcode;

public class Solution453 {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2147483647};
		System.out.println(new Solution453().minMoves1(arr));
	}
	public int minMoves1(int[] nums) {//solution from leetcode
		int min = Integer.MAX_VALUE;
		for(int i : nums){
			if(min > i)
				min = i;
		}
		int result = 0;
		for(int i :nums){
			result += (i - min);
		}
		return result;
	}
    public int minMoves(int[] nums) {
        int n = 0;
        int result = 0;
        boolean equal = false;
        int max_index = 0;
        while(!equal){
        	equal = true;
        	max_index = 0;
        	for(int i = 1;i<nums.length;i++){
        		if(nums[i]!=nums[i-1]){
        			equal = false;
        			if(nums[i]>nums[i-1]){
        				max_index = i;
        			}
        		}
        		nums[i-1]++;
        		
        	}
        	result++;
        	nums[nums.length-1]++;
        	nums[max_index]--;
        }
        return result-1;
    }
}
