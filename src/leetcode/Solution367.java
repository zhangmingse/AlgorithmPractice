package leetcode;

public class Solution367 {
	public static void main(String[] args) {
		Solution367 solution367 = new Solution367();
		System.out.println(solution367.isPerfectSquare(16));
		System.out.println(solution367.isPerfectSquare(12));

	}

	public boolean isPerfectSquare(int num) {
		return isPerferct(num, 0, num);
	}

	private boolean isPerferct(long num, long start, long end) {
		if (start > end) {
			return false;
		}

		if (start == end) {
			if (start * start == num) {
				return true;
			}
			return false;
		}

		long middle = start + (end - start) / 2;
		long temp = middle * middle;
		if (temp == num) {
			return true;
		} else if (temp > num) {
			return isPerferct(num, start, middle - 1);
		} else {
			return isPerferct(num, middle + 1, end);
		}

	}

}
