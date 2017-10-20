package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution169 {

	public static void main(String[] args) {
		int[] a = new int[] { 1 ,2,2};
		System.out.println(new Solution169().majorityElement(a));
		System.out.println(new Solution169().majorityElement_from_leetcode(a));
	}

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>(nums.length);
		int middle = nums.length / 2;
		for (int i = 0; i < nums.length; i++) {
			Integer value = count.get(nums[i]);
			if (value == null) {
				value = 0;
			}
			count.put(nums[i], value + 1);
			if (value + 1 > middle) {
				return nums[i];
			}
		}
		return 0;

	}
	
	public int majorityElement_from_leetcode(int[] nums) {
		int major = nums[0];
		int count = 1;
		for(int i = 1;i<nums.length;i++){
			if(count == 0){
				major = nums[i];
				count = 1;
			}else if(major == nums[i]){
				count ++;
			}else{
				count--;
			}
		}
		return major;

	}
}
