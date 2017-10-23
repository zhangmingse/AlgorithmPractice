package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution219 {

	public static void main(String[] args) {
		Solution219 solution219 = new Solution219();
		int[] arr = new int[]{1,2,1};
		System.out.println(solution219.containsNearbyDuplicate(arr, 1));
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		
		Set<Integer> set = new HashSet<Integer>();
		if(nums == null || nums.length <2 || k == 0){
			return false;
		}
		set.add(nums[0]);
		int count = 1;
		for(int i = 1;i<nums.length;i++){
			if(set.contains(nums[i]))
				return true;
			if(count>= k){
				set.remove(nums[i-k]);
				count--;
			}
			set.add(nums[i]);
			count++;
		}
		return false;
	}

}
