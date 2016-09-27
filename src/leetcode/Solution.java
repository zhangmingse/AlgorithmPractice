package leetcode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	accessTree(root, tempTree);
    	copyTree(tempTree, root);
        return root;
    }
    
    private void accessTree(TreeNode root,TreeNode tempTree){
    	if(root == null)
    		return;
    	tempTree.val = root.val;
    	TreeNode right_node = new TreeNode(0);
    	TreeNode left_node = new TreeNode(0);
    	tempTree.left = left_node;
    	tempTree.right = right_node;
    	accessTree(root.left, tempTree.right);
    	accessTree(root.right, tempTree.left);
    }
    
    private void copyTree(TreeNode res,TreeNode des){
    	if(res == null || des == null)
    		return;
    	des.val = res.val;
    	copyTree(res.left, des.left);
    	copyTree(res.right, des.right);
    }
    
    private TreeNode tempTree;
    public Solution(){
    	tempTree = new TreeNode(0);
    }
    
    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    }
}
