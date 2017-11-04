package leetcode;

public class Solution98 {

	public static void main(String[] args) {

		TreeNode root = null;
		try {
			root = ArrayToTree.arrayToTree(new Integer[] { 2,1,3});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		Solution98 solution98 = new Solution98();
		System.out.println(solution98.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		State state = isValidBSTutli(root);
		return state == null ? true : state.isBST;
	}

	private State isValidBSTutli(TreeNode root) {
		State state_result = new State();
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			state_result.isBST = true;
			state_result.maxVal = root.val;
			state_result.minVal = root.val;
			return state_result;
		}
		State state_left = null;
		State state_right = null;

		state_left = isValidBSTutli(root.left);

		state_right = isValidBSTutli(root.right);

		if (state_left == null) {
			if (state_right.isBST == false || root.val >= state_right.minVal) {
				return state_result;
			}

			state_result.isBST = true;
			state_result.minVal = root.val;
			state_result.maxVal = state_right.maxVal;
			return state_result;

		}

		if (state_right == null) {
			if (state_left.isBST == false || root.val <= state_left.maxVal) {
				return state_result;
			}
			state_result.isBST = true;
			state_result.maxVal = root.val;
			state_result.minVal = state_left.minVal;
			return state_result;
		}

		if (state_left.isBST && state_right.isBST && root.val > state_left.maxVal && root.val < state_right.minVal) {
			state_result.isBST = true;
			state_result.minVal = state_left.minVal;
			state_result.maxVal = state_right.maxVal;
			return state_result;

		}
		state_result.isBST = false;

		return state_result;
	}

	static class State {
		boolean isBST = false;
		int maxVal = 0;
		int minVal = 0;
	}
}
