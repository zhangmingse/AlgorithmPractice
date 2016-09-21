package sort;

import java.util.Random;

public class MergeSort_9 {
	public static void main(String args[]){
		int arr_count = 50000000;
		int arr[] = new int[arr_count];
		int arr_2[] = new int[arr_count];
		long start_time = 0;
		long end_time =0;
		
		Random random = new Random();
		int index = 0;
		start_time = System.currentTimeMillis();
		for(;index<arr_count;index++){
			arr[index] = random.nextInt();
		}
		end_time = System.currentTimeMillis();
		System.out.println("random total time : " + (end_time - start_time));
		
		start_time = System.currentTimeMillis();
		sort(0, arr_count-1, arr, arr_2);
		end_time = System.currentTimeMillis();
		index = 0;
		for(;index<arr_count;index+=500000){
			System.out.println(arr[index]);
		}
		System.out.println("total time : " +(end_time - start_time));
	}
	
	private static void sort(int start,int end,int arr[],int arr_2[]) {
		int middle = 0;
		middle = (end - start) /2 + start;
		if(end>start){
			sort(start, middle, arr, arr_2);
			sort(middle+1, end, arr, arr_2);
			merge(start, middle, end, arr, arr_2);
		}else if(end == start){
			return;
		}else{
			System.out.println("sort error");
			return;
		}
		
	}
	
	private static void merge(int start, int middle,int end,int arr[],int arr_2[]) {
		int p_left = start;
		int p_right = middle+1;
		int index = start;
		for(;index<=end;index++){
			arr_2[index] = arr[index];
		}
		index = start;
		for(;index<=end;index++){
			if(p_left > middle){
				arr[index] = arr_2[p_right++];
				continue;
			}
			if(p_right > end){
				arr[index] = arr_2[p_left++];
				continue;
			}
			if(arr_2[p_left] < arr_2[p_right]){
				arr[index] = arr_2[p_left++];
			}else{
				arr[index] = arr_2[p_right++];
			}
		}
	}
}
