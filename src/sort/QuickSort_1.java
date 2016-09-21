package sort;

import java.util.Random;

public class QuickSort_1 {
	public static void main(String args[]) {
		int arr_size = 50000000;
		int arr[] = new int[arr_size];
		int index = 0;
		Random random = new Random();
		for(;index<arr_size;index++){
			arr[index] = random.nextInt();
//			arr[index] = index;
		}
		
		long start_time = System.currentTimeMillis();
		quicksort(0, arr_size-1, arr);
		long end_time = System.currentTimeMillis();
		
		
		index = 0;
		for(;index < arr_size;index+=500000){
			System.out.println(arr[index]);
		}
		
		System.out.println("total time " + (end_time - start_time) + "milliseconds");
	}
	
	static void quicksort(int start,int end,int arr[]){
		int p_left = start;
		int p_right = end;
		int key = 0;
		if(start >= end)
			return;
		key = arr[start];
		while(p_left < p_right){
			while(p_left < p_right){
				if(arr[p_right--] < key){					
					arr[p_left++] = arr[++p_right];
					break;
				}
			}
			
			while(p_left < p_right){
				if(arr[p_left++] > key){
					arr[p_right--] = arr[--p_left];
					break;
				}
			}
		}
		if(p_left != p_right){
			System.out.println("error 1");
			System.exit(-2);
		}
		arr[p_left] = key;
		quicksort(start, p_left-1, arr);
		quicksort(p_right+1, end, arr);
		
	}

}
