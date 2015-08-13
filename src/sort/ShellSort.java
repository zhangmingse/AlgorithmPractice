package sort;

import java.util.Random;

public class ShellSort extends BaseSort{
	public static void sort(Comparable<Object>[] a) {
		int N = a.length;
		int h = 1;
		while(h<N/3)h=h*3+1;
		
		while(h>=1){
			for(int i = h;i<N;i++){
				for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h){
					exch(a,j,j-h);
				}
			}
			h=h/3;
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
		
		ShellSort.sort(tdata);
		
		for(int i = 0;i<count;i++){
			System.out.print(tdata[i].getKeyValue() + " ");
			if((i+1)%10 == 0)
				System.out.println("");
			
		}
		
		
	}


}
