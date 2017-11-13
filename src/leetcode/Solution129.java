package leetcode;

public class Solution129 {
	
	public static void main(String[] args) {
		Solution129 solution129 = new Solution129();
		try {
			TreeNode root = ArrayToTree.arrayToTree(new Integer[]{1,2,3});
			System.out.println(solution129.sumNumbers(root));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public int sumNumbers(TreeNode root) {
        sumNumbersUtil(0, root);
        return totalSum;
    }
    
    int totalSum = 0;
    private void sumNumbersUtil(int parent,TreeNode root){
    	if(root == null){
    		return;
    	}
    	if(root.left == null && root.right == null){
    		totalSum += (parent*10 + root.val);
    		return;
    	}
    	parent = parent*10 + root.val;
    	sumNumbersUtil(parent, root.left);
    	sumNumbersUtil(parent, root.right);
    }

}
