package leetcode;


public class Solution606 {

	public static void main(String[] args) {

		TreeNode root = null;
		try {
			root = ArrayToTree.arrayToTree(new Integer[]{1,2,3,null,4});
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println(new Solution606().tree2str(root));
		System.out.println(new Solution606().tree2str_from_leetcode(root));

	}

	StringBuilder sBuilder = new StringBuilder();

	public String tree2str(TreeNode t) {
		tree2str_util(t);
		return sBuilder.toString();
	}

	private void tree2str_util(TreeNode t) {
		if (t == null) {
			return;
		}
		if (t.left == null && t.right == null) {
			sBuilder.append(t.val);
			return;
		}
		sBuilder.append(t.val);
		if (t.left == null) {
			sBuilder.append("()(");
			tree2str_util(t.right);
			sBuilder.append(")");
		} 
		else if (t.right == null) {
			sBuilder.append("(");
			tree2str_util(t.left);
			sBuilder.append(")");
		}else{
			sBuilder.append("(");
			tree2str_util(t.left);
			sBuilder.append(")(");
			tree2str_util(t.right);
			sBuilder.append(")");
		}
		return;
	}
	
    public String tree2str_from_leetcode(TreeNode t) {
        if (t == null) return "";
        
        String result = t.val + "";
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }

}
