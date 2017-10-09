package leetcode;

public class Solution171 {

	public static void main(String[] args) {
		System.out.println(new Solution171().titleToNumber("AA"));
	}
	public int titleToNumber(String s) {

		int result = 0;
		for(char c:s.toCharArray()){
			result = result * 26 + (c-'A' + 1);
		}
		
		return result;
	}
}
