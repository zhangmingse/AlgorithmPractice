package sort;

public class MergerSort_1 extends BaseSort{

	private static Comparable<Object>[] aux;
	public static void merge(Comparable<Object>[] arr_to_sort,int low,int middle,int high) {
		for(int i=low;i<=high;i++){
			aux[i] = arr_to_sort[i];
		}
		
		int point_l=low,point_r=middle+1;
		for(int des_index=low;des_index<=high;des_index++){
			if(point_r>high){
				arr_to_sort[des_index] = aux[point_l++];
			}else if(point_l>middle){
				arr_to_sort[des_index] = aux[point_r++];
			}else if(less(aux[point_l],aux[point_r])){
				arr_to_sort[des_index] = aux[point_l++];
			}else{
				arr_to_sort[des_index] = aux[point_r++];
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void sort(Comparable<Object>[] arr_to_sort) {
		aux = new Comparable[arr_to_sort.length];
		sort(arr_to_sort, 0, arr_to_sort.length-1);
	}
	
	private static void sort(Comparable<Object>[] arr_to_sort,int low,int high){
		if(low==high||low>high)return;
		int middle =low + (high-low)/2;
		sort(arr_to_sort, low, middle);
		sort(arr_to_sort, middle+1, high);
		merge(arr_to_sort, low, middle, high);
	}
}
