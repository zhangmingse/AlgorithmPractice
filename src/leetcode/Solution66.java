package leetcode;

public class Solution66 {
	public static void main(String[] args) {
		int[] result = new Solution66().plusOne(new int[]{9,9,9});
		for(int i : result){
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	public int[] plusOne(int[] digits){
		int temp = digits[digits.length -1] + 1;
		int i = digits.length -1;
		for(;i>0 && temp > 9;i--){
			digits[i] = temp - 10;
			temp = digits[i-1] + 1;
		}
		if(temp<10){
			digits[i] = temp;
			return digits;
		}else{
			int[] new_res = new int[digits.length + 1];
			new_res[0] = 1;
			return new_res;
		}
		
	}

}
