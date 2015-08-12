package sort;

public class BaseSort {

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
