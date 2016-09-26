package sort;

import java.util.Random;

public class HeapSort_2 {
	public static void main(String args[]){
		int arr_size = 50000000;
		int arr[] = new int[arr_size+1];//arr[1] as start ,arr[arr_size]as end
		Random random = new Random();
		int index = 1;
		for(;index < arr_size+1;index++){
			arr[index] = random.nextInt();
//			arr[index] = arr_size+1 -index;
		}
		
		long start_time = System.currentTimeMillis();
		heapsort(arr);
		long end_time = System.currentTimeMillis();
		for(index = 1;index  < arr_size+1;index +=500000){
			System.out.println(arr[index]);
		}
		System.out.println("total time : " + (end_time - start_time) + "  milliseconds");
		
	}
	
	private static void heapsort(int arr[]){
		int index = arr.length - 1;
		int start = 1;
		heapbuild(arr);
		int temp = 0;
		
		while(index > start){
			temp = arr[start];
			arr[start] = arr[index];
			arr[index] = temp;
			index--;
			adjustheap(start, index, arr);
		}
	}
	
	private static void heapbuild(int arr[]){
		int index = arr.length/2 ;
		int start = 1;
		int end  =arr.length - 1;
		for(;index >= start;index--){
			adjustheap(index, end, arr);
		}
	}
	
	private static void adjustheap(int index,int end,int arr[]){
		if(index <= end/2 ){
			int temp = 0;
			temp = index*2;
			int max = index;
			if(temp <= end && arr[max] < arr[temp]){
				max = temp;
			}
			temp+=1;
			if(temp<=end && arr[max] < arr[temp]){
				max = temp;
			}
			if(max != index){
				temp = arr[index];
				arr[index] = arr[max];
				arr[max] = temp;
				adjustheap(max, end, arr);
			}
		}
	}
	
	

}
