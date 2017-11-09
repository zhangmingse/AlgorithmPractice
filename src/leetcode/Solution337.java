package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution337 {

	public static void main(String[] args) {
		Solution337 solution337 = new Solution337();

		try {
			TreeNode root = ArrayToTree.arrayToTree(new Integer[] { 3, 2, 3, null, 3, null, 1 });

			System.out.println(solution337.rob(root));

			root = ArrayToTree.arrayToTree(new Integer[] { 3, 4, 5, 1, 3, null, 1 });

			System.out.println(solution337.rob(root));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int rob(TreeNode root) {
		int temp = 0;
		int result = Integer.MIN_VALUE;
		temp = robUtil(root, true);
		result = temp > result ? temp : result;

		temp = robUtil(root, false);
		result = temp > result ? temp : result;
		return result;

	}

	Map<TreeNode, Integer> map = new HashMap<>();
	private int robUtil(TreeNode root, boolean taken) {
		if (root == null) {
			return 0;
		}

		int result = Integer.MIN_VALUE;
		int temp = 0;
		int templeft = 0;
		int tempright = 0;
		if (taken) {
			if(map.containsKey(root)){
				return map.get(root);
			}
			result = root.val + robUtil(root.left, false) + robUtil(root.right, false);
			map.put(root, result);
		} else {
			
			if(map.containsKey(root.left)){
				templeft = map.get(root.left);
			}else{
				temp = robUtil(root.left, false) ;
				templeft = robUtil(root.left, true);
				
				templeft = temp>templeft?temp:templeft;
				map.put(root.left, templeft);
			}
			
			if(map.containsKey(root.right)){
				tempright = map .get(root.right);
			}else{
				temp =  robUtil(root.right, false);
				tempright =  robUtil(root.right, true);
				
				tempright = temp > tempright?temp:tempright;
				map.put(root.right, tempright);
			}
			result = templeft + tempright;
		}
		return result;
	}

}
