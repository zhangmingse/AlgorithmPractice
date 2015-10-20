package sort;

public class MergeSortL extends BaseSort {
	private static int[] LINK;
	private static Comparable<Object>[] arr_to_sort;
	private static int LINK_HEAD;

	private static int MergeL(int link_l, int link_r) {

		int next_link_node = LINK_HEAD;

		while (link_l != LINK_HEAD && link_r != LINK_HEAD) {
			if (less(arr_to_sort[link_l], arr_to_sort[link_r])) {
				LINK[next_link_node] = link_l;
				next_link_node = link_l;
				link_l = LINK[link_l];

			} else {
				LINK[next_link_node] = link_r;
				next_link_node = link_r;
				link_r = LINK[link_r];
			}
		}
		if (link_l == LINK_HEAD) {
			LINK[next_link_node] = link_r;
		} else {
			LINK[next_link_node] = link_l;
		}

		return LINK[LINK_HEAD];

	}

	public static void mergeSortL(Comparable<Object>[] arr_to_sort_paragram) {
		LINK_HEAD = arr_to_sort_paragram.length;
		arr_to_sort = arr_to_sort_paragram;
		LINK = new int[arr_to_sort.length + 1];
		
		for (int i = 0; i <= arr_to_sort.length; i++) {
			LINK[i] = LINK_HEAD;// 初始化为头节点，凡是指向该节点的节点视为结尾
		}
		mergeSortL(0, arr_to_sort.length);

	}

	private static int mergeSortL(int low, int high) {
		if (low >= high)
			return low;// low = high
		int middle = low + (high - low) / 2;
		int link_l = 0, link_r = 0;
		link_l = mergeSortL(low, middle);
		link_r = mergeSortL(middle + 1, high);
		MergeL(link_l, link_r);

		return LINK[LINK_HEAD];
	}
	
	public static void show_result(int step_length) {
		System.out.println("start output result");
		int next_node = LINK[LINK_HEAD];
		int i=0;
		do{
			if(i%step_length==0){
				System.out.print(((SortTestData)arr_to_sort[next_node]).getKeyValue()+" ");
			}
			i++;
			next_node = LINK[next_node];
		}while(next_node!=LINK_HEAD);
	}

}
