package sort;

public class QuickSort extends BaseSort{

	public static void sort(Comparable<Object>[] arr_to_sort){
		sort(arr_to_sort,0,arr_to_sort.length-1);
	}
	
	private static void sort(Comparable<Object>[] arr_to_sort,int low,int high){
		if(high<=low)
			return;
		int j = partition(arr_to_sort, low, high);
		sort(arr_to_sort, low, j-1);
		sort(arr_to_sort, j+1, high);
	}
	private static int partition(Comparable<Object>[] arr_to_sort,int low,int high) {
		int i=low;
		int j=high+1;
		Comparable<Object> v = arr_to_sort[low];
		while(true){
			while(less(arr_to_sort[++i],v)){
				if(i==high){
					break;
				}
			}
			while(less(v,arr_to_sort[--j])){
				if(j==low){
					break;
				}
			}
			if(i>=j)
				break;
			exch(arr_to_sort, i, j);
		}
		exch(arr_to_sort, low, j);
		return j;
	}
}
