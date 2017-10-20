package leetcode;

public class Solution111 {

	public static void main(String[] args) {

		Integer[] ss = new Integer[]{1,2,3,null,null,4};
		try {
			TreeNode root =  ArrayToTree.arrayToTree(ss);
			System.out.println(new Solution111().minDepth(root));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		int left_depth = Integer.MAX_VALUE;
		int right_depth = Integer.MAX_VALUE;
		if(root.left!= null){
			left_depth = 1 + minDepth(root.left);
		}
		if(root.right !=null){
			right_depth = 1+ minDepth(root.right);
		}
		
		
		return left_depth < right_depth ? left_depth : right_depth;

	}

}
