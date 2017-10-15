package leetcode;

public class Solution104 {

	public static void main(String[] args) {
		
	}
    public int maxDepth(TreeNode root) {
        
        int left = 0;
        int right = 0;
        if(root == null){
        	return 0;
        }
        left = 1 + maxDepth(root.left);
        right = 1 + maxDepth(root.right);
        
        return left > right ? left:right;
    }
}
