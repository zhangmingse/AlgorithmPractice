package sort;

import java.util.Random;

public class MergeSort_3 {

	public static void main(String[] args) {
		int integer_count = 50000000;
		int[] raw = new int[integer_count];
		int[] temp_arr = new int[integer_count];
		Random random = new Random();
		for (int i = 0; i < integer_count; i++) {
			raw[i] = random.nextInt();
		}
		long start_time = System.currentTimeMillis();
		sort(0, integer_count - 1, raw, temp_arr);
		long end_time = System.currentTimeMillis();
		for (int i = 0; i < integer_count; i += 10000) {
			System.out.println(raw[i]);
		}
		
		System.out.println("total time "+(end_time-start_time));

	}

	private static void sort(int start_index, int end_index, int[] raw, int[] temp_arr) {
		if (end_index <= start_index)
			return;
		int middle_index = (end_index - start_index) / 2 + start_index;
		sort(start_index, middle_index, raw, temp_arr);
		sort(middle_index + 1, end_index, raw, temp_arr);

		merge(start_index, middle_index, end_index, raw, temp_arr);

	}

	private static void merge(int start_index, int middle, int end_index, int[] raw, int[] temp_arr) {
		for (int i = start_index; i <= end_index; i++) {
			temp_arr[i] = raw[i];
		}
		int left_point = start_index;
		int right_point = middle + 1;
		for (int i = start_index; i <= end_index; i++) {

			if (left_point > middle) {
				raw[i] = temp_arr[right_point];
				right_point++;
				continue;
			}

			if (right_point > end_index) {
				raw[i] = temp_arr[left_point];
				left_point++;
				continue;
			}

			if (temp_arr[left_point] < temp_arr[right_point]) {
				raw[i] = temp_arr[left_point];
				left_point++;
			} else {
				raw[i] = temp_arr[right_point];
				right_point++;
			}
		}
	}

}
