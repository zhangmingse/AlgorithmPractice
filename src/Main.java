import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			Long long1 = in.nextLong();
			System.out.println(find(long1));
		}

	}
	
	public static long find(long pa){
		
		
		long index1 = pa/10;
		long index2 = pa;
		long middle = 0;
		long temp =0;
		while(index1 < index2){
			middle = (index2 - index1)/2 + index1;
			//当index1 = index2 - 1时，若temp=add(middle) >pa,
			//index2 = middle;而index1仍然不变，所以会死循环
			if(middle == index1)
			{
				middle++;
				index1++;//s所以必须添加这个语句，才能避免死循环；
			}
			temp = add(middle);
			if(temp == pa)
				return middle;
			if(temp < pa){
				index1 = middle;
			}else{
				index2 = middle;
			}
		}
		return -1;
	}
	private static long add(long pa){
		long sum = 0;
		while(pa>0){
			sum += pa;
			pa/=10;
		}
		return sum;
	}

//	public static int minMoves2(int[] nums) {
//		long min_moves = Long.MAX_VALUE;
//		Arrays.sort(nums);
//		long totalsum = 0L;
//		long lesssum = 0L;
//		for (int i : nums) {
//			totalsum += (long) i;
//		}
//		long moves = 0;
//		for (long i = 0; i < nums.length; i++) {
//			long temp1 = nums[(int) i] * i - lesssum;
//			long temp2_1 = (totalsum - lesssum - nums[(int) i]);
//
//			long temp2_2 = (nums.length - i - 1) * nums[(int) i];
//			moves = temp1 + temp2_1 - temp2_2;
//			min_moves = min_moves < moves ? min_moves : moves;
//			lesssum += nums[(int) i];
//		}
//		return (int) min_moves;
//
//	}



	public static int latestAddation(String s) {

		char[] arr = s.toCharArray();
		int size = arr.length;
		int[][] result = new int[size + 1][size + 1];
		for (int i = 1; i <= size; ++i) {
			result[i][i] = 1;
		}
		for (int d = 1; d < size; d++) {
			for (int i = 1; i + d <= size; i++) {
				int j = i + d;
				result[i][j] = Math.min(result[i][j - 1], result[i + 1][j]) + 1;
				for (int k = i; k <= j - 1; k++) {
					if (check(arr[k - 1] ,  arr[j - 1])){
						result[i][j] = Math.min(result[i][j], result[i][k - 1] + result[k + 1][j - 1]);
					}
				}
			}
		}

		return  result[1][size];
	}
	
	static boolean check(char a1, char a2) {
		if (a1 == '(' && a2 == ')')
			return true;
		return false;
	}
}
