package leetcode;

public class IntegetReverse {
	static public int reverse(int x) {
		char[] cs = Integer.toString(x).toCharArray();
		int left = 0;
		int right = cs.length - 1;
		if (cs[0] < '0' || cs[0] > '9') {
			left = 1;
		}
		char c;
		while (left < right) {
			c = cs[right];
			cs[right] = cs[left];
			cs[left] = c;
			left++;
			right--;
		}
		try {
			return Integer.parseInt(cs.toString());
		} catch (NumberFormatException e) {
			return 0;
		}

	}

	static public int reverse_1(int x) {
		int item = 0;
		int result = 0;
		int newResult = 0;

		while (x != 0) {
			item = x % 10;
			newResult = item + result * 10;
			if ((newResult - item) / 10 != result)
				return 0;
			result = newResult;
			x = x / 10;
		}
		return result;
	}

	static public int reverse_2(int x) {
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x=-x;
		}

		StringBuffer sBuffer = new StringBuffer();
		String string = sBuffer.append(x).reverse().toString();
		try {
			if(isNegative)
				return -Integer.parseInt(string);
			else
				return Integer.parseInt(string);
		} catch (Exception e) {
			return 0;
		}

	}

	
}
