package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DPtest {
	private static int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
	private static int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
			{ 1, 0, 3, 0, 5 } };

	public static void main(String[] args) {
		// cnk(6, 3);
		// System.out.println(maxSubArray(nums));
		// NumMatrix obj = new NumMatrix(matrix);
		// System.out.println(obj.sumRegion(2, 1, 4, 3));
		// System.out.println(obj.sumRegion(1, 1, 2, 2));
		// System.out.println(obj.sumRegion(1, 2, 2, 4));s
		// System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));;
		// System.out.println(rob(new int[]{1,1,0,3,1}));
		// int[] result = countBit(5);
		// for(int i = 0;i<result.length;i++){
		// System.out.print(result[i] + " ");
		// }

		// System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
		// System.out.println(countNumbersWithUniqueDigits(3));
		// System.out.println(integerBreak(10));
		// System.out.println(PredictTheWinner(new int[] { 1, 5, 2 }));

		// System.out.println(findTargetSumWays(new int[] {0,0,0,0,0,0,0,0,1},
		// 1));
		// System.out.println(uniquePaths(3, 7));
		// System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 4));
		// System.out.println(longestPalindromeSubseq("abac"));
		// int [] r = productExceptSelf(new int[]{1,0});
		// for(int i =0 ;i<r.length;i++){
		// System.out.print(r[i] + " ");
		// }
		// System.out.println("");

		// TreeNode node1 = new TreeNode(1);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node5 = new TreeNode(5);
		// node1.left = node2;
		// node1.right = node3;
		// node2.right = node5;
		// node3.right = node4;
		//
		// Solution solution = new Solution();
		// List<Integer> list = solution.rightSideView(node1);
		// for (Integer integer : list) {
		// System.out.println(integer + " ");
		// }

		// System.out.println(hammingDistance(1, 4));
		// System.out.println(isValid("(){}[][][]"));
//		List<String> ls = readBinaryWatch(2);
//		for (String string : ls) {
//			System.out.println(string);
//		}
		System.out.println(maxProfit_1(new int[]{4,2,7,1,11}));
	}
    public static int maxProfit_1(int[] prices) {
    	if(prices.length<2)
    		return 0;
    	int[] result = new int[prices.length];
    	int Max_profit = Integer.MIN_VALUE;
    	for(int i = 1;i<prices.length;i++)
    	{
    		int max = Integer.MIN_VALUE;
    		int temp = Integer.MIN_VALUE;
    		int min = Integer.MAX_VALUE;
    		for(int j = i-3;j>-3;j--)
    		{
    			min = min > prices[j+2]?prices[j+2]:min;
    			temp = (j>-1?result[j]:0) + prices[i] - min;
    			if(temp > max)
    				max = temp;
    		}
    		result[i] = max;
    		if(max > Max_profit)
    			Max_profit = max;
    	}
    	return Max_profit > 0?Max_profit:0;
    }
	
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        
        return matrix;
    }

	public static List<String> list;

	public static List<String> readBinaryWatch(int num) {
		List<String> ls = new ArrayList<>();
		list = ls;
		int[] lights_arr = new int[10];
		read(lights_arr, 0, num);
		return ls;
	}

	public static void read(int[] lights_arr, int index, int last_n) {
		if (index < lights_arr.length && last_n > 0) {
			lights_arr[index] = 1;
			if (lights_arr.length -1 - index >= last_n - 1) {
				read(lights_arr, index + 1, last_n - 1);
			}
			lights_arr[index] = 0;
			if (lights_arr.length -1 - index >= last_n) {
				read(lights_arr, index + 1, last_n);
			}
		} else {
			int hour = binaryToInt(lights_arr, 0, 3);
			if(hour>11)
				return;
			int minute = binaryToInt(lights_arr, 4, 9);
			if(minute>59)
				return;
			if(minute>9)
				list.add(hour+":"+minute);
			else if(minute>0)
				list.add(hour+":0"+minute);
			else if(minute == 0)
				list.add(hour+":00");
		}
	}

	public static int binaryToInt(int[] binary_arr, int start, int end) {
		int res = 0;
		for(int i = start;i<=end;i++)
		{
			if(binary_arr[i] == 1)
			{
				res = res | (1<<(end-i));
			}
		}
		return res;
	}

	public static boolean judge(char c1, char c2) {
		if (c1 == '(' && c2 == ')')
			return true;
		if (c1 == '[' && c2 == ']')
			return true;
		if (c1 == '{' && c2 == '}')
			return true;
		return false;
	}

	public static boolean isValid(String s) {
		Stack<Character> sc = new Stack<>();
		char[] char_arr = s.toCharArray();
		if (s.length() <= 1)
			return false;
		sc.push(char_arr[0]);
		for (int i = 1; i < char_arr.length; i++) {

			if (sc.size() > 0) {
				if (judge(sc.peek(), char_arr[i])) {
					sc.pop();
					continue;
				} else {
					sc.push(char_arr[i]);
				}
			} else {
				sc.push(char_arr[i]);
			}
		}
		if (!sc.isEmpty())
			return false;
		else
			return true;
	}

	public static int hammingDistance(int x, int y) {
		int distance = 0;
		int i = 0;
		int xx, yy;
		for (; i < 32; i++) {
			xx = x >> i;
			yy = y >> i;

			xx = xx ^ yy;
			xx = xx & 1;
			if (xx == 1)
				distance++;

		}
		return distance;
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class Solution {
		public List<Integer> rightSideView(TreeNode root) {
			if (root == null)
				return new ArrayList<>();
			Map<Integer, List<TreeNode>> level = new HashMap<>();
			List<TreeNode> list_int = new ArrayList<>();
			level.put(1, list_int);
			list_int.add(root);
			int level_count = access_level(1, level);
			int i = 1;
			List<Integer> list_result = new ArrayList<>();
			for (; i <= level_count; i++) {
				list_int = level.get(i);
				list_result.add(list_int.get(list_int.size() - 1).val);
			}
			return list_result;
		}

		public int access_level(Integer level_number, Map<Integer, List<TreeNode>> level) {
			List<TreeNode> list = level.get(level_number);

			List<TreeNode> list_to_add = new ArrayList<>();
			level.put(level_number + 1, list_to_add);
			boolean flag = false;
			for (TreeNode treeNode : list) {
				if (treeNode.left != null) {
					list_to_add.add(treeNode.left);
					flag = true;
				}
				if (treeNode.right != null) {
					list_to_add.add(treeNode.right);
					flag = true;
				}
			}
			if (!flag)
				return 1;
			return 1 + access_level(level_number + 1, level);
		}
	}

	public static int[] productExceptSelf(int[] nums) {
		int total = 1;
		boolean has_zero = false;
		int[] res = new int[nums.length];
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				has_zero = true;
				break;
			}
			total *= nums[i];
		}
		if (has_zero) {
			total = 1;
			for (int j = 0; j < res.length; j++) {
				if (j != i) {
					res[j] = 0;
					total *= nums[j];
				}
			}
			res[i] = total;
			return res;
		}

		for (i = 0; i < nums.length; i++) {
			res[i] = total / nums[i];
		}
		return res;

	}

	public static int combinationSum4(int[] nums, int target) {
		return 0;
	}

	public static int[][] result;

	public static int uniquePaths(int m, int n) {
		result = new int[m][n];
		for (int i = 0; i < m; i++) {
			result[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			result[0][j] = 1;
		}
		findpath(m - 1, n - 1);
		return result[m - 1][n - 1];
	}

	public static void findpath(int m, int n) {
		if (m < 1 || n < 1)
			return;
		if (result[m][n] == 0) {
			findpath(m - 1, n);
			findpath(m, n - 1);
		}
		result[m][n] = result[m - 1][n] + result[m][n - 1];

		return;
	}

	public static int longestPalindromeSubseq(String _s) {
		StringBuilder sBuilder = new StringBuilder(_s);
		StringBuilder sReverse = sBuilder.reverse();
		char[] s_reverse = sReverse.toString().toCharArray();
		char[] s = _s.toCharArray();
		int n = s.length;
		if (n == 1)
			return 1;
		int[][] result = new int[n][n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (s_reverse[0] == s[i]) {
				for (int j = i; j < n; j++) {
					result[j][0] = 1;
				}
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (s[0] == s_reverse[i]) {
				for (int j = i; j < n; j++) {
					result[0][j] = 1;
				}
				break;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				max = result[i][j - 1] > result[i - 1][j] ? result[i][j - 1] : result[i - 1][j];
				if (s[i] == s_reverse[j]) {
					max = max > (result[i - 1][j - 1] + 1) ? max : result[i - 1][j - 1] + 1;
				} else {
					max = max > result[i - 1][j - 1] ? max : result[i - 1][j - 1];
				}
				result[i][j] = max;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.format("%4d", result[i][j]);
			}
			System.out.println("");
		}
		return result[n - 1][n - 1];
	}

	public static int[][] res;
	public static int[] num_arr;
	public static int distance = 2000;

	public static int findTargetSumWays(int[] nums, int S) {
		int nums_length = nums.length;
		int[][] result_arr = new int[4200][nums_length];
		for (int i = 0; i < nums_length; i++) {
			for (int j = 0; j < 4200; j++) {
				result_arr[j][i] = Integer.MIN_VALUE;
			}
			// System.out.println(result_arr[i][0]);
		}
		int max = 0;
		int min = 0;
		for (int i = 0; i < nums_length; i++) {
			max += nums[i];
			min -= nums[i];
		}
		if (max < S)
			return 0;
		if (min > S)
			return 0;
		res = result_arr;
		num_arr = nums;
		res[num_arr[0] + distance][0] = 1;
		res[-num_arr[0] + distance][0] = 1;
		if (num_arr[0] == 0)
			res[-num_arr[0] + distance][0] = 2;
		find(nums_length - 1, S);
		// for(int i = distance-50;i<distance+50;i++)
		// {
		// System.out.print(i + " ==> ");
		// for(int j = 0;j<nums_length;j++)
		// {
		// System.out.format("%12d ",res[i][j]);
		// }
		// System.out.println("");
		// }

		return res[S + distance][nums_length - 1] > 0 ? res[S + distance][nums_length - 1] : 0;
	}

	public static void find(int n, int m) {
		if (n > 0) {
			if (num_arr[n] == 0) {
				res[m + distance][n] = 0;
				find(n - 1, m);
				res[m + distance][n] = res[m + distance][n - 1] * 2;
				return;
			}
			if (res[m - num_arr[n] + distance][n - 1] == Integer.MIN_VALUE) {
				find(n - 1, m - num_arr[n]);
			}
			if (res[m + num_arr[n] + distance][n - 1] == Integer.MIN_VALUE) {
				find(n - 1, m + num_arr[n]);
			}
			res[m + distance][n] = 0;
			if (res[m - num_arr[n] + distance][n - 1] > 0) {
				res[m + distance][n] += res[m - num_arr[n] + distance][n - 1];
			}
			if (res[m + num_arr[n] + distance][n - 1] > 0) {
				res[m + distance][n] += res[m + num_arr[n] + distance][n - 1];
			}
		}
	}

	public static boolean PredictTheWinner(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		if (nums.length == 1 || nums.length == 2)
			return true;
		int result;
		int[][] f = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			f[i][i] = nums[i];
			if (i + 1 < nums.length) {
				f[i][i + 1] = nums[i] > nums[i + 1] ? nums[i] : nums[i + 1];
			}
		}

		int min1_1, min1_2, min2_1, min2_2;
		for (int left_len = 2; left_len < nums.length; left_len++) {
			int i = 0;
			for (int j = left_len; j < nums.length; j++) {
				min1_1 = f[i][j - 2] + nums[j];
				min1_2 = f[i + 1][j - 1] + nums[j];
				min2_1 = f[i + 2][j] + nums[i];
				min2_2 = f[i + 1][j - 1] + nums[i];

				min1_1 = min1_1 < min1_2 ? min1_1 : min1_2;
				min2_1 = min2_1 < min2_2 ? min2_1 : min2_2;

				f[i][j] = min1_1 > min2_1 ? min1_1 : min2_1;
				i++;
			}
		}
		// for(int i = 0;i<nums.length;i++){
		// for(int j = 0;j<nums.length;j++){
		// System.out.print(f[i][j]+ " ");
		// }
		// System.out.println("");
		// }
		result = f[0][nums.length - 1];
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		return (total - result) > result ? false : true;

	}

	public static int integerBreak(int n) {
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		int[] fi = new int[n + 1];
		fi[1] = 1;
		fi[2] = 2;
		int max = 0;
		int temp = 0;
		for (int i = 3; i <= n; i++) {

			for (int j = i - 2; j >= i / 2; j--) {
				temp = fi[j] * fi[i - j];
				max = temp > max ? temp : max;
			}
			fi[i] = max > i ? max : i;
		}
		return max;
	}

	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 10;
		if (n > 1) {
			int sum = 1;
			int pre = 9;
			sum += pre;
			for (int i = 2; i <= n; i++) {
				pre = (11 - i) * pre;
				sum += pre;
			}
			return sum;
		}
		return 0;
	}

	public static int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length < 2)
			return 0;

		int sum = 0;
		int latestLen = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				latestLen++;
			} else {
				sum += latestLen * (latestLen + 1) / 2;
				latestLen = 0;
			}
		}
		sum += latestLen * (latestLen + 1) / 2;
		return sum;
	}

	public static int[] countBit(int num) {
		if (num < 0)
			return null;
		int[] result = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			result[i] = result[i >> 1] + (i & 1);
		}
		return result;
	}

	public static int climbStairs(int n) {
		// if(n==1 || n ==0)
		// return 1;
		// else{
		// return climbStairs(n-1) + climbStairs(n-2);
		// }
		if (n == 0 || n == 1)
			return 1;
		int pre = 1;
		int aft = 1;
		int result = pre + aft;
		for (int i = 2; i <= n; i++) {
			result = pre + aft;
			pre = aft;
			aft = result;
		}
		return result;
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int fi = 0;
		int max = Integer.MIN_VALUE;
		int temp = 0;
		fi = prices[0];
		for (int i = 1; i < prices.length; i++) {
			temp = prices[i] - fi;
			if (temp > max)
				max = temp;

			if (fi > prices[i]) {

				fi = prices[i];
			}

		}
		if (max < 0)
			max = 0;
		return max;
	}

	public static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int fi = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (fi <= 0) {
				fi = nums[i];
			} else {
				fi = fi + nums[i];
			}
			if (fi > max) {
				max = fi;
			}
		}
		return max;
	}

	public static void cnk(int n, int k) {
		int[][] arr_cnk = new int[n + 1][k + 1];
		for (int i_n = 0; i_n <= n; i_n++) {
			System.out.print(i_n + " : ");
			for (int j_k = 0; j_k <= (i_n < k ? i_n : k); j_k++) {
				if (j_k == 0 || i_n == j_k) {
					arr_cnk[i_n][j_k] = 1;
					System.out.print(arr_cnk[i_n][j_k]);
				} else {
					arr_cnk[i_n][j_k] = arr_cnk[i_n - 1][j_k - 1] + arr_cnk[i_n - 1][j_k];
					System.out.print(arr_cnk[i_n][j_k]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println(arr_cnk[n][k]);
	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return nums[0] > nums[1] ? nums[0] : nums[1];

		nums[1] = nums[0] > nums[1] ? nums[0] : nums[1];
		for (int i = 2; i < nums.length; i++) {
			nums[i] = nums[i - 1] > nums[i - 2] + nums[i] ? nums[i - 1] : nums[i - 2] + nums[i];
		}
		return nums[nums.length - 1];
	}

	public static class NumMatrix {

		int[][] myMatrix;

		public NumMatrix(int[][] matrix) {
			if (matrix == null)
				return;
			myMatrix = matrix;
			int temp = 0;
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					temp = 0;
					if (j - 1 < 0) {
						if (i - 1 >= 0) {
							temp = matrix[i - 1][j] + matrix[i][j];
						} else {
							temp = matrix[0][0];
						}
					} else {
						if (i - 1 >= 0) {
							temp = matrix[i][j] + matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1];
						} else {
							temp = matrix[i][j - 1] + matrix[i][j];
						}
					}
					matrix[i][j] = temp;
					// System.out.print(matrix[i][j] + " ");
				}
				// System.out.println(" ");
			}
			myMatrix = matrix;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (col1 - 1 < 0) {
				if (row1 - 1 >= 0) {
					return myMatrix[row2][col2] - myMatrix[row1 - 1][col2];
				} else {
					return myMatrix[row2][col2];
				}
			} else {
				if (row1 - 1 >= 0) {
					return myMatrix[row2][col2] - myMatrix[row2][col1 - 1] - myMatrix[row1 - 1][col2]
							+ myMatrix[row1 - 1][col1 - 1];
				} else {
					return myMatrix[row2][col2] - myMatrix[row2][col1 - 1];
				}
			}
		}
	}
}
