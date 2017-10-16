package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ArrayToTree {
	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1, 2, 3, null, 4, 5 };
		
		TreeNode root = null;
		try {
			root = arrayToTree(arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(access(root));
	}

	
	static String access(TreeNode root){
		if(root == null){
			return "";
		}
		return root.val + access(root.left) + access(root.right);
	}

	//convert arrat to binary tree.
	static TreeNode arrayToTree(Integer[] arr) throws Exception {
		if (arr == null || arr.length == 0) {
			return null;
		}

		TreeNode root = null;
		Queue<TreeNode> queue = new LinkedList<>();

		root = new TreeNode(arr[0]);
		queue.add(root);
		TreeNode temp = null;
		TreeNode node = null;
		int arr_index = 0;

		for (arr_index = 1; arr_index < arr.length;) {
			temp = queue.poll();
			if (temp == null) {
				if (arr[arr_index++] == null && arr[arr_index++] == null) {
					continue;
				} else {
					throw new Exception(
							"Element numbered " + (arr_index - 1) + "  should be null as it's parent is null.");
				}

			}
			if (arr[arr_index] != null) {
				node = new TreeNode(arr[arr_index]);
			} else {
				node = null;
			}

			temp.left = node;
			queue.add(node);

			arr_index++;
			if(arr_index == arr.length)
				break;
			if (arr[arr_index] != null) {
				node = new TreeNode(arr[arr_index]);
			} else {
				node = null;
			}
			temp.right = node;
			queue.add(node);

			arr_index++;

		}

		return root;
	}
}
