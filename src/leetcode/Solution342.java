package leetcode;

public class Solution342 {

	public static void main(String[] args) {

		System.out.println(new Solution342().isPowerOfFour(1));
	}

	public boolean isPowerOfFour(int num) {

		if (num < 4)
		{
			if(num ==1)
				return true;
			return false;
		}
		int temp = num%4;
		while(temp==0 && num !=4){
			num = num/4;
			temp = num % 4;
		}
		if(num == 4)
			return true;
		else 
			return false;
	}
}
