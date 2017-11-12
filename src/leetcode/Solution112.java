package leetcode;

public class Solution112 {

	public static void main(String[] args) {
		Solution112 solution112 = new Solution112();
		try {
			TreeNode root = ArrayToTree.arrayToTree(new Integer[]{5,4,8,11,null,13,14,7,2,null,null,null,1});
			System.out.println(solution112.hasPathSum(root, 22));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        hasPathSumHutil(root, 0, sum);
    	return flag;
    }
    
    private void hasPathSumHutil(TreeNode root,int pre,int sum){
    	if(root == null){
    		return;
    	}
    	if(root.left == null && root.right == null){
    		if(pre + root.val == sum){
    			flag = true;
    		}
    		return;
    	}
    	
    	hasPathSumHutil(root.left, pre+root.val, sum);
    	hasPathSumHutil(root.right, pre+root.val, sum);
    }
}
