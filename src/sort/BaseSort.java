package sort;

import java.util.Random;

public class BaseSort {
	
	public static void main(String[] args){
		int count = 20;
		SortTestData[] tdata = new SortTestData[count];
		Random random = new Random();
		for(int i = 0;i<count;i++){
			tdata[i] = new SortTestData(random.nextInt(count));
		}
		
		for(int i = 0;i<count;i++){
			System.out.print(tdata[i].getKeyValue() + " ");
			if((i+1)%10 == 0)
				System.out.println("");
			
		}
		System.out.println("");
		System.out.println("###################################");
		System.out.println("");
		
		
//		SelectionSort.sort(tdata);
//		InsertionSort.sort(tdata);
//		ShellSort.sort(tdata);
		MergeSort.sort(tdata);
		
		
		for(int i = 0;i<count;i++){
			System.out.print(tdata[i].getKeyValue() + " ");
			if((i+1)%10 == 0)
				System.out.println("");
			
		}
		
		
	}

	protected static boolean less(Comparable<Object> a, Comparable<Object> b) {
		return a.compareTo(b) < 0;

	}

	protected static void exch(Comparable<Object>[] a, int i, int min) {
		Comparable<Object> b = a[i];
		a[i] = a[min];
		a[min] = b;
	}
	
	protected static boolean isSorted(Comparable<Object>[] a){
		int N = a.length;
		for(int i = 1;i<N;i++){
			if(less(a[i],a[i-1]))
				return false;
		}
		return true;
	}
}
