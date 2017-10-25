package leetcode;

public class Solution14 {

	public static void main(String[] args) {
		Solution14 solution14 = new Solution14();
		String[] str_arr = new String[] { "aaa", "aa","aaa" };
		String result = solution14.longestCommonPrefix(str_arr);
		System.out.println(result);
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0 || strs[0].length() == 0) {
			return "";
		}
		StringBuilder sBuilder = new StringBuilder();
		boolean goon = true;
		int index = 0;
		while (goon) {
			char c;
			if (index < strs[0].length()) {
				c = strs[0].charAt(index);
			} else {
				break;
			}
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() > index && c == strs[i].charAt(index)) {
					continue;
				} else {
					goon = false;
					break;
				}
			}
			if (goon) {
				sBuilder.append(c);
				index++;
			}
		}
		return sBuilder.toString();
	}
}
