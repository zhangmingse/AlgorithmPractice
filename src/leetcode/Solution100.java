package leetcode;

public class Solution100 {

	public static void main(String[] args) {
		try {
			TreeNode root1 = ArrayToTree.arrayToTree(new Integer[] { 1, 2 });
			TreeNode root2 = ArrayToTree.arrayToTree(new Integer[] { 1, null, 2 });
			Solution100 solution100 = new Solution100();

			System.out.println(solution100.isSameTree(root1, root2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}
}
