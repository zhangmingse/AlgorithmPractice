package sort;

import java.util.Random;

public class QuickSort_2 {
	private static int layer_limit = 0;

	public static void main(String args[]) {
		int arr_size = 50000000;
		int arr[] = new int[arr_size];
		Random random = new Random();
		int index = 0;
		for (; index < arr_size; index++) {
			arr[index] = random.nextInt();
//			arr[index] = index;
		}
		long start_time = System.currentTimeMillis();
		quicksort(0, arr_size - 1, arr, 0);
		long end_time = System.currentTimeMillis();
		index = 0;
		for (; index < arr_size; index+=5000000) {
			System.out.println(arr[index]);
		}
		System.out.println("total time : " + (end_time - start_time) + "milliseconds");
	}

	private static void quicksort(int start, int end, int arr[], int layer) {
		int p_left;
		int p_right;
		int key;
		p_left = start;
		p_right = end;

		if (p_left >= p_right)
			return;
		key = arr[p_right];
		while (p_left < p_right) {
			while (p_left < p_right) {
				if(arr[p_left ++ ] < key){
					arr[p_right--] = arr[--p_left];
					break;
				}
			}
			
			while (p_left < p_right) {
				if(arr[p_right--] > key){
					arr[p_left++] = arr[++p_right];
					break;
				}
			}

		}
		arr[p_left] = key;
		quicksort(start, p_left-1, arr, layer+1);
		quicksort(p_left+1, end, arr, layer+1);
	}

}
