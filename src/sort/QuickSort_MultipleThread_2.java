package sort;

import java.util.Random;

public class QuickSort_MultipleThread_2 {
	private static int layer_limit = 1;
	public static void main(String args[]) {
		int arr_size = 50000000;
		int arr[] = new int[arr_size];
		int index = 0;
		Random random = new Random();
		for(;index<arr_size;index++){
			arr[index] = random.nextInt();
		}
		long start_time = System.currentTimeMillis();
		quicksort(0, arr_size-1, arr, 0);
		long end_time = System.currentTimeMillis();
		
		for(index = 0;index<arr_size;index+=5000000){
			System.out.println(arr[index]);
		}
		System.out.println("ttal time : " + (end_time - start_time) + "  milliseconds");
	}
	
	private static void quicksort(int start,int end,int arr[],int layer){
		int p_left = start;
		int p_right = end;
		if(start >=end)
			return;
		int key = arr[start];
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
		arr[p_left] = key;
		if(layer > layer_limit){
			quicksort(start, p_left-1, arr, layer+1);
			quicksort(p_left+1, end, arr, layer+1);
		}else{
			Thread t1 = new workerThread(start, p_left-1, arr,layer);
			Thread t2 = new workerThread(p_right+1, end, arr,layer);
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("join exception");
				System.exit(-1);
			}
			
		}
		
	}
	
	private static class workerThread extends Thread{
		int start;
		int end;
		int layer;
		int arr[];
		public workerThread(int _start,int _end,int[] _arr, int _layer){
			start = _start;
			end = _end;
			arr = _arr;
			layer = _layer;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			quicksort(start, end, arr, layer+1);
		}

	}

}
