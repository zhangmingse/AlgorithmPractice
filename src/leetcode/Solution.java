package leetcode;

import java.awt.print.Printable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import leetcode.DPtest.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	

	public static void showTree_rootFirst(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		showTree_rootFirst(root.left);
		showTree_rootFirst(root.right);
	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		TreeNode node = null;
		if (t1 != null) {
			if (t2 != null) {
				node = new TreeNode(t1.val + t2.val);
				node.left = mergeTrees(t1.left, t2.left);
				node.right = mergeTrees(t1.right, t2.right);
			} else {
				node = new TreeNode(t1.val);
				node.left = mergeTrees(t1.left, null);
				node.right = mergeTrees(t1.right, null);
			}
		} else {
			if (t2 != null) {
				node = new TreeNode(t2.val);
				node.left = mergeTrees(null, t2.left);
				node.right = mergeTrees(null, t2.right);
			} else {
				return null;
			}
		}
		return node;
	}

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

	/************************************************************/
	// problem 3
	// https://leetcode.com/problems/longest-substring-without-repeating-characters/
	// ��Ĳ��ظ��Ӵ�
	public int lengthOfLongestSubstring1(String s) {
		int longestLen = 0;
		if (s == null || s.isEmpty())
			return longestLen;
		char[] chars = s.toCharArray();
		int headIndex = 0;
		int tailIndex = headIndex + 1;
		longestLen = 1;
		Map<Character, Integer> charSet = new HashMap<>();
		while (tailIndex < chars.length) {
			charSet.clear();
			charSet.put(chars[headIndex], headIndex);
			tailIndex = headIndex + 1;
			while (tailIndex < chars.length && !charSet.keySet().contains(chars[tailIndex])) {
				charSet.put(chars[tailIndex], tailIndex);
				tailIndex++;
			}

			int tempLongestLen = tailIndex - headIndex;
			if (tempLongestLen > longestLen) {
				longestLen = tempLongestLen;
			}
			if (tailIndex == chars.length) {
				tailIndex = chars.length - 1;
			}
			headIndex = charSet.get(chars[tailIndex]) + 1;
			tailIndex = headIndex + 1;
		}

		return longestLen;
	}

	public int lengthOfLongestSubstring(String s) {
		int longestLen = 0;
		if (s == null || s.isEmpty())
			return longestLen;
		char[] chars = s.toCharArray();

		Map<Character, Integer> charIndex = new HashMap<>();
		int i = 0;
		int pre = -1;
		for (; i < chars.length; i++) {
			int tempLen = 0;
			if (charIndex.containsKey(chars[i])) {

				if (pre < charIndex.get(chars[i])) {
					pre = charIndex.get(chars[i]);
					tempLen = i - charIndex.get(chars[i]);
				} else {
					tempLen = i - pre;
				}
			} else {
				tempLen = i - pre;
			}
			if (tempLen > longestLen)
				longestLen = tempLen;

			charIndex.put(chars[i], i);
		}

		return longestLen;
	}

	public boolean upOverflowCheck(int i, int j) {
		if (i < 0) {
			return false;
		} else {
			return j > (Integer.MAX_VALUE - i);
		}
	}

	public boolean downOverflowCheck(int i, int j) {
		if (i > 0) {
			return false;
		} else {
			return j < Integer.MIN_VALUE - i;
		}

	}

	public boolean overflowCheck(int i, int j) {
		return upOverflowCheck(i, j) || downOverflowCheck(i, j);
	}

	/***********************************************************/

	public static String reverseString(String s) {
		if (s == null)
			return null;
		StringBuilder sb = new StringBuilder(s);

		return sb.reverse().toString();
	}

	/***********************************************************/

	public static void sort_char_arr(char[] str_arr) {
		quick_sort_char_arr(0, str_arr.length - 1, str_arr);
	}

	public static void quick_sort_char_arr(int start, int end, char[] arr) {
		if (start >= end)
			return;
		int p_left = start;
		int p_right = end;
		char key = arr[p_left];
		while (p_left < p_right) {
			while (p_left < p_right) {
				if (arr[p_right--] < key) {
					arr[p_left++] = arr[++p_right];
					break;
				}
			}
			while (p_left < p_right) {
				if (arr[p_left++] > key) {
					arr[p_right--] = arr[--p_left];
					break;
				}
			}
		}
		arr[p_left] = key;
		quick_sort_char_arr(start, p_left - 1, arr);
		quick_sort_char_arr(p_left + 1, end, arr);

	}

	public static char findTheDifference(String s, String t) {
		if (s.length() == 0)
			return t.charAt(0);
		char[] s_arr = s.toCharArray();
		char[] t_arr = t.toCharArray();
		sort_char_arr(s_arr);
		sort_char_arr(t_arr);
		int i = 0;
		for (; i < s_arr.length; i++) {
			if (s_arr[i] != t_arr[i])
				return t_arr[i];
		}

		return t_arr[t_arr.length - 1];
	}

	public static int countArrangement(int N) {
		int[] arr = new int[N + 1];
		for (int i = 0; i < N + 1; i++)
			arr[i] = i;
		fullRange(arr, 1);

		return num;
	}

	public static int num = 0;

	public static void fullRange(int[] arr, int n) {
		if (n >= arr.length)
			num++;
		int temp = 0;
		int i = n;
		for (; i < arr.length; i++) {
			if (arr[i] % n == 0 || n % arr[i] == 0) {
				temp = arr[n];
				arr[n] = arr[i];
				arr[i] = temp;
				fullRange(arr, n + 1);
				temp = arr[i];
				arr[i] = arr[n];
				arr[n] = temp;
			}
		}
	}

	public static void quick_sort_int(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int p_left = start;
		int p_right = end;
		int key = arr[p_left];
		while (p_left < p_right) {
			while (p_left < p_right) {
				if (arr[p_right--] < key) {
					arr[p_left++] = arr[++p_right];
					break;
				}
			}
			while (p_left < p_right) {
				if (arr[p_left++] > key) {
					arr[p_right--] = arr[--p_left];
					break;
				}
			}
		}
		arr[p_left] = key;
		quick_sort_int(arr, start, p_left - 1);
		quick_sort_int(arr, p_left + 1, end);
	}

	public static int arrayPairSum(int[] nums) {
		quick_sort_int(nums, 0, nums.length - 1);
		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		return sum;
	}

	public String compose(int[] arr, int start, int end, int[][] max_division_position, int[][] min_division_position,
			boolean need_max) {
		if (start == end)
			return arr[start] + "";
		int n = 0;
		if (need_max) {
			n = max_division_position[start][end];
		} else {
			n = min_division_position[start][end];
		}

		if (n == end - 1)
			return compose(arr, start, n, max_division_position, min_division_position, need_max) + "/" + arr[end];
		else
			return compose(arr, start, n, max_division_position, min_division_position, need_max) + "/("
					+ compose(arr, n + 1, end, max_division_position, min_division_position, !need_max) + ")";

	}

	public String optimalDivision(int[] nums) {
		int size_n = nums.length;
		float[][] max = new float[size_n][size_n];
		float[][] min = new float[size_n][size_n];
		int[][] max_division_position = new int[size_n][size_n];
		int[][] min_division_position = new int[size_n][size_n];
		char[] pa = new char[size_n + 1];
		for (int i = 0; i < size_n; i++) {
			for (int j = i; j < size_n; j++) {
				if (i == j) {
					max[i][i] = nums[i];
					min[i][i] = nums[i];
					pa[i] = '-';
				} else {
					max[i][j] = Float.MIN_VALUE;
					min[i][j] = Float.MAX_VALUE;
				}
				max_division_position[i][j] = Integer.MIN_VALUE;
				min_division_position[i][j] = Integer.MAX_VALUE;
			}

		}
		pa[pa.length - 1] = '-';
		float max_current;
		float min_current;
		for (int i = 1; i < size_n; i++) {
			int i_i = i;
			for (int j = 0; j < size_n - i; j++, i_i++) {

				for (int m = j; m < i_i; m++) {
					max_current = max[j][m] / min[m + 1][i_i];
					if (max[j][i_i] < max_current) {

						max_division_position[j][i_i] = m;
						max[j][i_i] = max_current;
					}

					min_current = min[j][m] / max[m + 1][i_i];
					if (min[j][i_i] > min_current) {
						min[j][i_i] = min_current;
						min_division_position[j][i_i] = m;
					}

				}
			}
		}

		// System.out.println("max========================================");
		// for (int a = 0; a < size_n; a++) {
		// for (int b = 0; b < size_n; b++) {
		// System.out.format("%14f ", max[a][b]);
		// }
		// System.out.println();
		// }
		// System.out.println("min========================================");
		// for (int a = 0; a < size_n; a++) {
		// for (int b = 0; b < size_n; b++) {
		// System.out.format("%14f ", min[a][b]);
		// }
		// System.out.println();
		// }
		// System.out.println("div========================================");
		// for (int a = 0; a < size_n; a++) {
		// for (int b = 0; b < size_n; b++) {
		// System.out.format("%14d ", max_division_position[a][b]);
		// }
		// System.out.println();
		// }
		// System.out.println("end========================================");
		//
		return compose(nums, 0, size_n - 1, max_division_position, min_division_position, true);
	}

	public void add_tree_node(Map<Integer, List<TreeNode>> level, int n) {
		boolean flag = false;
		List<TreeNode> list = new LinkedList<>();

		for (TreeNode node : level.get(n - 1)) {
			if (node.left != null) {
				list.add(node.left);
				flag = true;
			}
			if (node.right != null) {
				list.add(node.right);
				flag = true;
			}
		}
		if (flag) {
			level.put(n, list);
			add_tree_node(level, n + 1);

		}
	}

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res_list = new LinkedList<>();
		if (root == null)
			return res_list;

		Map<Integer, List<TreeNode>> map = new HashMap<>();
		List<TreeNode> list = new LinkedList<>();
		list.add(root);
		map.put(0, list);
		add_tree_node(map, 1);
		int index = 0;

		for (; index < Integer.MAX_VALUE; index++) {
			int max = Integer.MIN_VALUE;
			if ((list = map.get(index)) != null) {
				for (TreeNode treeNode : list) {
					if (max < treeNode.val) {
						max = treeNode.val;
					}
				}
				res_list.add(max);
			} else {
				break;
			}
		}
		return res_list;
	}

	List<List<Integer>> res_list = new LinkedList<>();
	List<Integer> temp_list = new LinkedList<>();

	public List<List<Integer>> subsets(int[] nums) {
		pick(nums, 0);
		return res_list;
	}

	private void pick(int[] nums, int index) {
		if (index >= nums.length) {

			res_list.add(new LinkedList<>(temp_list));
			return;
		}
		pick(nums, index + 1);
		temp_list.add(nums[index]);
		pick(nums, index + 1);
		temp_list.remove(temp_list.indexOf(nums[index]));
	}

	/***********************************************************/
	public int findKthLargest(int[] nums, int k) {
		quick_sort_int(nums, 0, nums.length);
		return nums[nums.length - k];
	}

	/***********************************************************/
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;
		int row_num = matrix.length;
		int column_num = matrix[0].length;
		int column_i = 0, row_j = 0;
		for (column_i = column_num - 1; column_i > -1; column_i--) {
			if (matrix[0][column_i] == target)
				return true;
			else if (matrix[0][column_i] < target) {
				for (; row_j < row_num; row_j++) {
					if (matrix[row_j][column_i] == target)
						return true;
					else if (matrix[row_j][column_i] > target)
						break;
				}
			}

		}
		return false;
	}

	/***********************************************************/
	@SuppressWarnings("unused")
	public static void main(String args[]) {

		/*******************************************/
		// 2018届网易校招笔试题

		/********************************************/
		// 2017届网易校招笔试题
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();

		}
		int k = scanner.nextInt();
		int d = scanner.nextInt();

		scanner.close();

		long[][] result = new long[n][k + 1];

		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<k+1;j++)
			{
				result[i][j] = Long.MIN_VALUE;
			}
		}
		result[0][1] = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] < result[i - 1][1])
				result[i][1] = result[i - 1][1];
			else
				result[i][1] = arr[i];
		}

		long max = Long.MIN_VALUE;
		for (int k_index = 2; k_index <= k; k_index++) {
			for (int n_index = k_index-1; n_index < n; n_index++) {
				for (int i = n_index - 1; i >= k_index-2 && i >= n_index - d; i--) {
					max = arr[n_index] * result[i][k_index-1];
					if(max > result[n_index][k_index])
						result[n_index][k_index] = max;
				}
			}
		}
		
//		for(int i = 0;i<n;i++)
//		{
//			for(int j = 0;j<k+1;j++)
//			{
//				System.out.format("%30d", result[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------------------");
		System.out.println(result[n - 1][k]);
		/********************************************/
		// int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6,
		// 9, 16, 22 }, { 10, 13, 14, 17, 24 },
		// { 18, 21, 23, 26, 30 } };
		// int[][] ma = {};
		// System.out.println(new Solution().searchMatrix(ma,0));
		/********************************************/
		// Scanner scanner = new Scanner(System.in);
		// Long x ,k;
		// while(scanner.hasNext()){
		// x = new Long(scanner.nextInt());
		// k = new Long(scanner.nextInt());
		// int[] x_binaryArr = longToBinaryArr(x);
		// int[] k_binaryArr = longToBinaryArr(k);
		// int[] result_arr = new int[64];
		// for(int i =result_arr.length-1,j=k_binaryArr.length-1 ;i>=0;i--){
		// if(x_binaryArr[i] == 1){
		// result_arr[i] = 0;
		// }else{
		// result_arr[i] = k_binaryArr[j--];
		// }
		// }
		// Long result = 0L;
		// Long temp=1L;
		// for(int i = 63;i>=0;i--){
		// result = result+ (result_arr[i]*temp);
		// temp*=2;
		// }
		// System.out.println(result);
		// }
		//
		// scanner.close();
		//
		//
		///////////////////////////////////////////////
		TreeNode node1_1 = new TreeNode(1);
		TreeNode node1_3 = new TreeNode(3);
		// TreeNode node1_2 = new TreeNode(2);
		// TreeNode node1_5 = new TreeNode(5);
		TreeNode node2_2 = new TreeNode(2);
		// TreeNode node2_1 = new TreeNode(1);
		TreeNode node2_3 = new TreeNode(3);
		// TreeNode node2_4 = new TreeNode(4);
		TreeNode node3_5 = new TreeNode(5);
		TreeNode node3_3 = new TreeNode(3);
		TreeNode node3_9 = new TreeNode(9);

		node1_1.left = node2_3;
		node1_1.right = node2_2;
		node3_3.left = node3_5;
		node3_3.right = node3_3;
		node2_2.right = node3_9;
		// node2_1.right = node2_4;
		// node2_3.right = node2_7;
		//
		// TreeNode node = mergeTrees(node1_1, node2_2);
		// showTree_rootFirst(node);
		///////////////////////////////////////////////////////////
		// System.out.println(reverseString("abcd"));
		/***********************************/
		// System.out.println(findTheDifference("abcd", "cbade"));
		/**********************************/
		// System.out.println(countArrangement(2));
		/*************************************/
		// System.out.println(arrayPairSum(new int[]{2,1,4,3}));
		/**************************************/
		// System.out.println(new Solution().optimalDivision(new int[] {
		// 1000,100,10 }));
		// for (int val : new Solution().largestValues(node1_1)) {
		// System.out.println(val + " ");
		// }

		// List<List<Integer>> list = new Solution().subsets(new int[] { 1, 2, 3
		// });
		// for (List<Integer> list2 : list) {
		// for (Integer integer : list2) {
		// System.out.print(integer + " ");
		// }
		// System.out.println();
		// }
	}

	public static int[] longToBinaryArr(Long i) {
		int[] binaryArr = new int[64];
		char[] charArr = Long.toBinaryString(i).toCharArray();
		for (int j = charArr.length - 1, h = binaryArr.length - 1; j >= 0; j--, h--) {
			if (charArr[j] == '1') {
				binaryArr[h] = 1;
			}

		}
		return binaryArr;
	}
}
