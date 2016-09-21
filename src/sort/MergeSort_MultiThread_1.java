package sort;

import java.util.Random;

public class MergeSort_MultiThread_1 {

	  static int layer_limit = 1;

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
		sort(0, arr_count-1, arr, arr_2,0);
		end_time = System.currentTimeMillis();
		index = 0;
		for(;index<arr_count;index+=500000){
			System.out.println(arr[index]);
		}
		System.out.println("total time : " +(end_time - start_time));
	}
	
	private static void sort(int start,int end,int arr[],int arr_2[],int layer) {
		int middle = 0;
		middle = (end - start) /2 + start;
		if(end>start){
			if(layer > layer_limit){
				sort(start, middle, arr, arr_2,layer+1);
				sort(middle+1, end, arr, arr_2,layer+1);
				merge(start, middle, end, arr, arr_2);
			}else{
				Thread t1 = new workerThread(start, middle, arr, arr_2, layer);
				Thread t2 = new workerThread(middle+1, end, arr, arr_2, layer);
				t1.start();
				t2.start();
				try {
					t1.join();
					t2.join();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("accept exception");
					System.exit(-1);
				}

				merge(start, middle, end, arr, arr_2);
			}

		}else if(end == start){
			return;
		}else{
			System.out.println("sort error");
			return;
		}
		
	}
	
	private static class workerThread extends Thread {
		int start;
		int end;
		int arr[];
		int arr_2[];
		int layer;
		public  workerThread(int _start ,int _end,int _arr[],int _arr_2[],int _layer) {
			// TODO Auto-generated constructor stub
			start = _start;
			end = _end;
			arr = _arr;
			arr_2 = _arr_2;
			layer = _layer;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			sort(start, end, arr, arr_2, layer+1);
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
