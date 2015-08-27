package sort;

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

}
