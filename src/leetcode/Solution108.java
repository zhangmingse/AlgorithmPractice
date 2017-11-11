package leetcode;

public class Solution108 {
	public static void main(String[] args) {
		Solution108 solution108 = new Solution108();
		int[] nums = new int[]{1,2,3,4,5,6};
		TreeNode node = solution108.sortedArrayToBST(nums);
		System.out.println(node);
		
		
		
	}
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums == null || nums.length == 0){
    		return null;
    	}
        return sortedArrayToBSTUtil(nums, 0	, nums.length-1);
    }
    private TreeNode sortedArrayToBSTUtil(int[] nums,int start,int end){
    	if(start > end ){
    		return null;
    	}
    	TreeNode treeNode = new TreeNode();
    	if(start == end){
    		treeNode.val = nums[start];
    		return treeNode;
    	}
    	int middle = start + (end - start)/2;
    	treeNode.val = nums[middle];
    	treeNode.left = sortedArrayToBSTUtil(nums, start, middle-1);
    	treeNode.right = sortedArrayToBSTUtil(nums, middle + 1, end);
    	return treeNode;
    }

}
