package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution345 {
	public static void main(String[] args) {

		String s1 = "leetcode";
		String s2 = "leotcede";
		String s3 = new Solution345().reverseVowels(s1);
		System.out.println(s3);
		
	}

	public String reverseVowels(String s) {

		if (s == null || s.length() == 0) {
			return "";
		}
		char[] arr = s.toCharArray();
		int forward_index = 0;
		int backward_index = arr.length - 1;
		while (forward_index < backward_index) {
			while (forward_index < backward_index) {
				if (!isVowel[arr[forward_index]]) {
					forward_index++;
				} else {
					break;
				}
			}

			while (forward_index < backward_index) {
				if (!isVowel[arr[backward_index]]) {
					backward_index--;
				} else {
					break;
				}
			}
			if (forward_index < backward_index) {
				char c = arr[forward_index];
				arr[forward_index] = arr[backward_index];
				arr[backward_index] = c;

				forward_index++;
				backward_index--;
			}
		}

		return new String(arr, 0, arr.length);
	}
	
	static boolean[] isVowel = new boolean[128];//default false
	static {
		isVowel['a'] = true;
		isVowel['e'] = true;
		isVowel['i'] = true;
		isVowel['o'] = true;
		isVowel['u'] = true;
		isVowel['A'] = true;
		isVowel['E'] = true;
		isVowel['I'] = true;
		isVowel['O'] = true;
		isVowel['U'] = true;
	}

	private boolean check(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||
				c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			return true;
		}
		return false;
	}

	@Test
	public void test() {
		String s1 = "leetcode";
		String s2 = "leotcede";
		Assert.assertEquals(new Solution345().reverseVowels(s1), s2);
	}
}
