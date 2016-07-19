package sort;

import java.util.Random;

public class MergeSort_2 {
	public static void main(String[] args) {

		int number_count = 50000000;
		int[] int_arr = new int[number_count];
		int[] int_arr_2 = new int[number_count];
		Random random = new Random();
		
		for (int i = 0; i < number_count; i++) {
			int_arr[i] = random.nextInt();
			// System.out.println(int_arr[i]);
		}
		long start_time = System.currentTimeMillis();
		sort(0, number_count - 1, int_arr, int_arr_2);
		long end_time = System.currentTimeMillis();

		System.out.println("total time => " + (end_time - start_time));
		for (int i = 0; i < number_count; i += 50000) {
			System.out.println(int_arr[i]);
		}
	}

	static void sort(int start, int end, int[] arr, int[] arr_2) {
		if (end <= start)
			return;
		int middle = (end - start) / 2 + start;
		sort(start, middle, arr, arr_2);
		sort(middle + 1, end, arr, arr_2);

		merge(start, middle, end, arr, arr_2);

	}

	static void merge(int start, int middle, int end, int[] arr, int[] arr_2) {
		for (int i = start; i <= end; i++) {
			arr_2[i] = arr[i];
		}
		int left_p = start;
		int right_p = middle + 1;
		for (int i = start; i <= end; i++) {
			if (left_p > middle) {
				arr[i] = arr_2[right_p];
				right_p++;
				continue;
			}
			if (right_p > end) {
				arr[i] = arr_2[left_p];
				left_p++;
				continue;
			}
			if (arr_2[left_p] < arr_2[right_p]) {
				arr[i] = arr_2[left_p];
				left_p++;
			} else {
				arr[i] = arr_2[right_p];
				right_p++;
			}
		}
	}

}
