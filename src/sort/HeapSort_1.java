package sort;

import java.util.Random;

public class HeapSort_1 {
	public static void main(String args[]){
		int arr_size = 50000000;
		int arr[] = new int[arr_size];
		Random random = new Random();
		int index = 0;
		for(;index < arr_size;index++){
			arr[index] = random.nextInt();
		}
		
		long start_time = System.currentTimeMillis();
		heapsort(arr);
		long end_time = System.currentTimeMillis();
		for(index = 0;index  < arr_size;index +=500000){
			System.out.println(arr[index]);
		}
		System.out.println("total time : " + (end_time - start_time) + "  milliseconds");
		
	}
	
	private static void heapsort(int arr[]) {
		heapbuild(arr);
		int index = arr.length-1;
		while(index > 0){
			int temp = index;
			temp = arr[0];
			arr[0] = arr[index];
			arr[index] = temp;
			
			index--;
			adjustheap(0, index, arr);
		}
	}
	
	private static void heapbuild(int arr[]) {
		int index = arr.length/2-1;
		for(;index>=0;index--){
			adjustheap(index, arr.length-1, arr);
		}
	}
	
	private static void adjustheap(int index,int end,int arr[]){
		int temp = index * 2;
		int temp_ch = 0;
		if((temp+2) <= end){//two children
			if(arr[temp+1] > arr[temp+2]){
				if(arr[temp+1] > arr[index]){
					temp_ch = arr[index];
					arr[index] = arr[temp+1];
					arr[temp+1] = temp_ch;
					adjustheap(temp+1, end, arr);
				}
			}else{
				if(arr[temp+2] > arr[index]){
					temp_ch = arr[temp+2];
					arr[temp+2] = arr[index];
					arr[index] = temp_ch;
					adjustheap(temp+2, end, arr);
				}
			}
		}else if((temp + 1)== end){// one child
			if(arr[index] < arr[end]){
				temp_ch = arr[end];
				arr[end] = arr[index];
				arr[index] = temp_ch;
			}
		}else{//have no  child
			return;
		}
	}

}
