package sort;

import java.util.Random;

public class MergeSort_7 {
	public static void main(String args[]){
		int arr_count = 500;
		int arr[] =new  int[arr_count];
		int arr_2[] = new int[arr_count];
		Random random = new Random();
		int index = 0;
		for(index=0;index<arr_count;index++){
			arr[index] = random.nextInt();
		}
		long start_time = System.currentTimeMillis();
		sort(0, arr_count-1, arr, arr_2);
		long end_time = System.currentTimeMillis();
		for(index = 0;index<arr_count;index+=1){
			System.out.println(arr[index]);
		}
		System.out.println("total time : " + (end_time - start_time) + "mille seconds");
	}
	
	private static void sort(int start,int end,int arr[],int arr_2[]){
		int middle = 0;
		middle = (end - start)/2 + start;
		if(start < end){
			sort(start, middle, arr, arr_2);
			sort(middle+1, end, arr, arr_2);
			merge(start, middle, end, arr, arr_2);
		}else if(start == end){
			return;
		}else{
			System.out.println("error in sort");
		}
	}
	
	private static void merge(int start,int middle,int end,int arr[],int arr_2[]) {
		int index = start;
		for(;index<=end;index++){
			arr_2[index] = arr[index];
		}
		int p_left = start;
		int p_right = middle+1;
		index = start;
		for(;index<=end;index++){
			if(p_left > middle){
				arr[index] = arr_2[p_right++];
			}else if(p_right > end){
				arr[index] = arr_2[p_left++];
			}else if(arr_2[p_left] < arr_2[p_right]){
				arr[index] = arr_2[p_left++];
			}else {
				arr[index] = arr_2[p_right++];
			}
		}
	}

}
