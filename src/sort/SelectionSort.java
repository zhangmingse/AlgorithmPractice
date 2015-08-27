package sort;

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
	
}
