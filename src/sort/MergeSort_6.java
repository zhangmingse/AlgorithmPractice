package sort;

import java.util.Random;

public class MergeSort_6 {

	public static void main(String[] args){
		int arr_count = 50000000;
		int[] raw = new int[arr_count];
		int[] temp_arr = new int[arr_count];
		
		
		Random random = new Random();
		for(int i = 0;i<arr_count;i++){
			raw[i] = random.nextInt();
		}
		
		long start_time = System.currentTimeMillis();
		sort(0, arr_count-1, raw, temp_arr);
		long end_time = System.currentTimeMillis();
		
		for(int i = 0;i<arr_count;i+=1000000){
			System.out.println(raw[i]);
		}
		
		System.out.println("total time : " + (end_time - start_time) + " mill seconds");
	}
	
	private static void sort(int start_index,int end_index,int[] raw,int[] temp_arr){
		if(start_index>=end_index)
			return;
		
		int middle = (end_index-start_index)/2 + start_index;
		
		sort(start_index, middle, raw, temp_arr);
		sort(middle+1, end_index, raw, temp_arr);
		
		merge(start_index, middle, end_index, raw, temp_arr);
	}
	
	private static void merge(int start_index,
			int middle,
			int end_index,
			int[] raw,
			int[] temp_arr) {

		for(int i = start_index;i<=end_index;i++){
			temp_arr[i] = raw[i];
		}
		
		int left_point = start_index;
		int right_point = middle+1;
		
		for(int i = start_index;i<=end_index;i++){
			if(left_point>middle){
				raw[i] = temp_arr[right_point++];
				continue;
			}
			
			if(right_point>end_index){
				raw[i] = temp_arr[left_point++];
				continue;
			}
			if(temp_arr[left_point]<temp_arr[right_point]){
				raw[i] = temp_arr[left_point++];
			}else{
				raw[i] = temp_arr[right_point++];
			}
		}
	}

}
