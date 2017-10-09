package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class Solution462 {
	public static void main(String[] args) {

		System.out.println(new Solution462().minMoves2(new int[] { 203125577, -349566234, 230332704, 48321315, 66379082,
				386516853, 50986744, -250908656, -425653504, -212123143 }));
		System.out.println(new Solution462().minMoves2(new int[]{-1,-2,-2}));
	}

	public int minMoves2(int[] nums) {// solution from leetcode
		long min_moves = Long.MAX_VALUE;
		Arrays.sort(nums);
		long totalsum = 0L;
		long lesssum = 0L;
		for (int i : nums) {
			totalsum += (long) i;
		}
		long moves = 0;
		for (long i = 0; i < nums.length; i++) {
			long temp1 = nums[(int)i] * i - lesssum ;
			long temp2_1 =  (totalsum - lesssum - nums[(int)i]) ;
			//下边这行代码的问题。等号右边全是int类型的值时，计算按int类型的表达范围来进行
			//但是计算的结果溢出了int的范围，并将溢出后的结果存储到了long类型的temp2_2中。
			//要修正这个问题，就要将等号右边任意一个变量变为long类型，这样会自动的将等号右边
			//所有的变量都转变为long类型，再参与计算，这样就不会产生溢出。所以for循环中的i设为long类型
			//得到了正确的结果
			//产生溢出的case { 203125577, -349566234, 230332704, 48321315, 66379082,
			// 386516853, 50986744, -250908656, -425653504, -212123143 }
			long temp2_2 = (nums.length - i -1) * nums[(int)i];//可能是这里产生了溢出
			moves = temp1 + temp2_1 - temp2_2;
			min_moves = min_moves < moves ? min_moves : moves;
			lesssum += nums[(int)i];
		}
		return (int) min_moves;
	}

	public int minMoves(int[] nums) {
		int average = 0;
		int total = 0;
		int result = 0;
		for (int i : nums) {
			total += i;
		}
		average = total / nums.length;
		int temp = total % nums.length;
		if ((temp != 0) && (temp * 10 / nums.length > 4))
			average++;
		for (int i : nums) {
			result += Math.abs(i - average);
		}
		return result;
	}
}
