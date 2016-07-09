package sort;


import tools.StopWatch;

public class BaseSort {
	
	public static void main(String[] args){
		int count = 10000000;
		int step_length = 100000;
		SortTestData[] tdata = TestDataProducerForSort.geTestDatas(count);

//		for(int i = 0;i<count;i+=step_length){
//			System.out.print(tdata[i].getKeyValue() + " ");
//			if((i+1)%10 == 0)
//				System.out.println("");
//			
//		}
		System.out.println("");
		System.out.println("###################################");
		System.out.println("size     mergeL  merge   quick");
		count = 100000;
		for(int i = 1;i<=10;i++){
			
			int count_current = count*i;
			System.out.format("%-9d", count_current);
			SortTestData[] testData1 = new SortTestData[count_current];
			SortTestData[] testData2 = new SortTestData[count_current];
			SortTestData[] testData3 = new SortTestData[count_current];
			
			for(int j = 0;j<count_current;j++){
				testData1[j]=new SortTestData(tdata[j].getKeyValue());
				testData2[j]=new SortTestData(tdata[j].getKeyValue());
				testData3[j]=new SortTestData(tdata[j].getKeyValue());
				
			}
			
			StopWatch stopWatch = new StopWatch();
			MergeSortL.mergeSortL(testData1);
			double time_length = stopWatch.elapsedTime();
			System.out.format("%5.3f", time_length);
			System.out.print("s  ");
			//MergeSortL.show_result(step_length);
			
			stopWatch = new StopWatch();
			MergerSort_1.sort(testData2);
			time_length = stopWatch.elapsedTime();
			System.out.format("%5.3f", time_length);
			System.out.print("s  ");
			
			
			stopWatch = new StopWatch();
			QuickSort.sort(testData3);
			time_length = stopWatch.elapsedTime();
			System.out.format("%5.3f", time_length);
			System.out.println("s  ");
		}
		
		
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
