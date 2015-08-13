package sort;

import java.util.Random;

public class InsertionSort extends BaseSort {

	public static void sort(Comparable<Object>[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for(int j=i;j>0;j--){
				if(less(a[j],a[j-1])){
					exch(a,j,j-1);
				}else{
					break;
				}
			}
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
		
		InsertionSort.sort(tdata);
		
		for(int i = 0;i<count;i++){
			System.out.print(tdata[i].getKeyValue() + " ");
			if((i+1)%10 == 0)
				System.out.println("");
			
		}
		
		
	}

}
