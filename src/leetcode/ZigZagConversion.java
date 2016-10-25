package leetcode;

public class ZigZagConversion {
	// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	static public String reverse_str(String s, int numRows) {

		int dis_l = 0;
		int dis_r = 0;
		dis_l = numRows + numRows - 2;
		int current_row = 0;
		int current_index = 0;
		int length = s.length();
		if (numRows == 1)
			return s;
		StringBuilder sBuilder = new StringBuilder();
		while (current_row < numRows) {
			current_index = current_row;
			for (; current_index < length;) {
				sBuilder.append(s.charAt(current_index));

				if (dis_r == 0 || dis_l == 0) {
					current_index += (dis_l + dis_r);
					continue;
				}
				current_index += dis_l;
				if (current_index < length)
					sBuilder.append(s.charAt(current_index));
				else
					break;
				current_index += dis_r;
			}
			dis_l -= 2;
			dis_r += 2;
			current_row++;
		}
		return sBuilder.toString();
	}
}
