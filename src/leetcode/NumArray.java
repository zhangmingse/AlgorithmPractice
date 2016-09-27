package leetcode;

public class NumArray {


	int[] mynums;
	public NumArray(int[] nums) {
		int index;
		if (nums != null) {
			mynums = nums;
			for (index = 1; index < nums.length; index++) {
				nums[index] = nums[index-1] + nums[index];
			}
		}
	}

	public int sumRange(int i, int j) {

		if(mynums == null){
			return 0;
		}
		else{
			if(i==0)
				return mynums[j];
			else
				return mynums[j]-mynums[i-1];
		}
	}

	public static void main(String args[]) {
		int[] arr = new int[5];
		for (int index = 0; index < arr.length; index++) {
			arr[index] = index;
		}
		NumArray numArray = new NumArray(arr);
		System.out.println("0,0  = 0 => " + numArray.sumRange(0, 0));
		System.out.println("0,2  = 3 => " + numArray.sumRange(0, 2));
		System.out.println("1,2  = 3 => " + numArray.sumRange(1, 2));
		System.out.println("3,3  = 3 => " + numArray.sumRange(3, 3));
		System.out.println("0,4  = 10 =>" + numArray.sumRange(0, 4));
	}
}
