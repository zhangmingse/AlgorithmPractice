package sort;

public class MergeSort extends BaseSort {

	private static Comparable<Object>[] aux;

	private static void merge(Comparable<Object>[] a, int lo, int mid, int hi) {
		int i = lo, j = mid+1;

		for (int k = i; k <= hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j]))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];
		}
	}

	public static void sort(Comparable<Object>[] a) {

		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}

	private static void sort(Comparable<Object>[] a, int lo, int hi) {

		if(hi<=lo)
			return;
		
		int mid = lo + (hi - lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}

}
