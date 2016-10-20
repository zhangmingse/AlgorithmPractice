package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	/***************************************************************/
	// invert tree
	public TreeNode invertTree(TreeNode root) {
		accessTree(root, tempTree);
		copyTree(tempTree, root);
		return root;
	}

	private void accessTree(TreeNode root, TreeNode tempTree) {
		if (root == null)
			return;
		tempTree.val = root.val;
		TreeNode right_node = new TreeNode(0);
		TreeNode left_node = new TreeNode(0);
		tempTree.left = left_node;
		tempTree.right = right_node;
		accessTree(root.left, tempTree.right);
		accessTree(root.right, tempTree.left);
	}

	private void copyTree(TreeNode res, TreeNode des) {
		if (res == null || des == null)
			return;
		des.val = res.val;
		copyTree(res.left, des.left);
		copyTree(res.right, des.right);
	}

	private TreeNode tempTree;

	public Solution() {
		tempTree = new TreeNode(0);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/********************************************************/
	// nim game

	private Map<Integer, Boolean> map = new HashMap<>();

	public boolean canWinNim(int n) {
		if (n < 4) {
			map.put(n, true);
			return true;
		} else if (map.containsKey(n)) {
			return map.get(n);
		} else {
			if (canWinNim(n - 1) && canWinNim(n - 2) && canWinNim(n - 3)) {
				map.put(n, false);
				return false;
			} else {
				map.put(n, true);
				return true;
			}
		}
	}

	/***********************************************************/
	// problem 283 leetcode
	public void moveZeroes(int[] nums) {
		int pre, aft;
		pre = aft = 0;
		while (pre < nums.length && aft < nums.length) {
			if (nums[aft] != 0) {
				if (aft > pre) {
					nums[pre] = nums[aft];
				}
				pre++;
			}

			aft++;
		}
		while (pre < nums.length) {
			nums[pre++] = 0;
		}
	}

	/***********************************************************/

	// * Definition for singly-linked list.*/
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		return false;
	}

	/***********************************************************/
	/***********************************************************/
	public static void main(String args[]) {
		Solution solution = new Solution();
		int index = 1;
		for (; index < 20; index++) {
			System.out.println("can win ?  " + index + " " + solution.canWinNim(index));
		}

	}
}
