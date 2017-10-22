package leetcode;

public class Solution101 {

	public static void main(String[] args) {

		Integer[] arr = new Integer[]{1,2,2,3,4,4,3};
		Integer[] arr1 = new Integer[]{1,2,2,null,3,null,3};
		Integer[] arr2 = new Integer[]{1,2};
		Solution101 solution101 = new Solution101();
		try {
			TreeNode root = ArrayToTree.arrayToTree(arr2);
			System.out.println(solution101.isSymmetric(root));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isSymmetric(TreeNode root) {

		if(root == null || (root.left == null && root.right == null))
			return false;
		return isSymmetric(root.left,root.right);
	}

	private boolean isSymmetric(TreeNode node_left, TreeNode node_right) {
		if(node_left == null && node_right == null)
			return true;
		if(node_left == null || node_right == null){
			return false;
		}
		if (node_left.val == node_right.val) {
			return isSymmetric(node_left.left, node_right.right) && isSymmetric(node_left.right, node_right.left);
		} else {
			return false;
		}
	}
}
