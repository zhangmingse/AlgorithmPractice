package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		TreeNode l1 = new TreeNode();
		TreeNode r1 = new TreeNode();
		TreeNode l2 = new TreeNode();
		root.val=1;
		l1.val = 2;
		r1.val = 3;
		l2.val = -5;
		root.left= l1;
		root.right = r1;
		l1.right = l2;
		
		List<String> lStrings= new Solution1().binaryTreePaths(root);
		for(String s:lStrings){
			System.out.println(s);
		}
	}

	List<String> result = new LinkedList<>();
	StringBuilder sbTemp = new StringBuilder();
	int index = 0;

	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null)
			return result;
		sbTemp.append(root.val + "->");
		if (root.left != null) {
			binaryTreePaths(root.left);
		}
		if (root.right != null) {
			binaryTreePaths(root.right);
		} 

		if(root.left == null && root.right == null){//leaf

			index = sbTemp.lastIndexOf("->");
			sbTemp.delete(index, index+2);
			result.add(sbTemp.toString());
		}

		String string= root.val + "";
		index = sbTemp.lastIndexOf(string);
		sbTemp.delete(index, sbTemp.length());
		return result;
	}

}
