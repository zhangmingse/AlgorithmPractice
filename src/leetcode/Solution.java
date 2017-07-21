package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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

	/************************************************************/
	// problem 3
	// https://leetcode.com/problems/longest-substring-without-repeating-characters/
	// 最长的不重复子串
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
	
	public boolean upOverflowCheck(int i,int j){
		if(i<0){
			return false;
		}else{
			return j > (Integer.MAX_VALUE - i);
		}
	}
	public boolean downOverflowCheck(int i,int j){
		if(i > 0){
			return false;
		}else{
			return j < Integer.MIN_VALUE - i;
		}
		
	}
	public boolean overflowCheck(int i,int j){
		return upOverflowCheck(i, j)||downOverflowCheck(i, j);
	}

	/***********************************************************/
	/***********************************************************/
	@SuppressWarnings("unused")
	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		Long x ,k;
		while(scanner.hasNext()){
			x = new Long(scanner.nextInt());
			k = new Long(scanner.nextInt());
			int[] x_binaryArr = longToBinaryArr(x);
			int[] k_binaryArr = longToBinaryArr(k);
			int[] result_arr = new int[64];
			for(int i =result_arr.length-1,j=k_binaryArr.length-1 ;i>=0;i--){
				if(x_binaryArr[i] == 1){
					result_arr[i] = 0;
				}else{
					result_arr[i] = k_binaryArr[j--];
				}
			}
			Long result = 0L;
			Long temp=1L;
			for(int i = 63;i>=0;i--){
				result = result+  (result_arr[i]*temp);
				temp*=2;
			}
			System.out.println(result);
		}
		
		scanner.close();

	}
	public static int[] longToBinaryArr(Long i){
		int [] binaryArr = new int[64];
		char[] charArr = Long.toBinaryString(i).toCharArray();
		for(int j = charArr.length-1,h = binaryArr.length-1;j>=0;j--,h--){
			if(charArr[j] == '1'){
				binaryArr[h] = 1;
			}
			
		}
		return binaryArr;
	}
}
