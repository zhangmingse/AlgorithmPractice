package sort;


import tools.StopWatch;

public class BaseSort {
	
	public static void main(String[] args){
		int count = 10000000;
		int step_length = 100000;
		SortTestData[] tdata = TestDataProducerForSort.geTestDatas(count);
		SortTestData[] tdata1 = new SortTestData[count];
		for(int i=0;i<count;i++){
			tdata1[i] = tdata[i];
		}
		for(int i = 0;i<count;i+=step_length){
			System.out.print(tdata[i].getKeyValue() + " ");
			if((i+1)%10 == 0)
				System.out.println("");
			
		}
		System.out.println("");
		System.out.println("###################################");
		System.out.println("");
		StopWatch stopWatch = new StopWatch();
		
		
//		SelectionSort.sort(tdata);
//		InsertionSort.sort(tdata);
//		ShellSort.sort(tdata);
//		MergeSort.sort(tdata);
//		MergeSort.sort_BU(tdata);
//		MergerSort_1.sort(tdata);
//		QuickSort.sort(tdata);
		MergeSortL.mergeSortL(tdata);
		double time_length = stopWatch.elapsedTime();
		System.out.println("merge sort 1 time:"+time_length);
		//MergeSortL.show_result(step_length);
		
		stopWatch = new StopWatch();
		MergerSort_1.sort(tdata);
		time_length = stopWatch.elapsedTime();
		System.out.println("merge sort 2 time:" + time_length);
		
		
		stopWatch = new StopWatch();
		QuickSort.sort(tdata1);
		time_length = stopWatch.elapsedTime();
		System.out.println("quick sort time:" + time_length);
		
//		for(int i = 0;i<count;i+=step_length){
//			System.out.print(tdata[i].getKeyValue() + " ");
//			if((i+1)%10 == 0)
//				System.out.println("");			
//		}
		
		
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
