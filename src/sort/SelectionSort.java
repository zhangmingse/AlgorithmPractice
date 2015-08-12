package sort;

import java.util.Random;

public class SelectionSort extends BaseSort{
	public static void sort(Comparable<Object>[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a,i,min);
		}
	}
	
	public static void main(String[] args){
		int count = 1000;
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
		
		SelectionSort.sort(tdata);
		
		for(int i = 0;i<count;i++){
			System.out.print(tdata[i].getKeyValue() + " ");
			if((i+1)%10 == 0)
				System.out.println("");
			
		}
		
		
	}

	
}
