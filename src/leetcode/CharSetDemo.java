package leetcode;


//八皇后、递归全排列解法
public class CharSetDemo  {
	
	static int column_sum = 8;
	static int result_index = 0;
	public static void main(String[] args) {
		System.out.println("begin");


		int[] column_index = new int[column_sum];
		for(int i = 0;i<column_sum;i++){
			column_index[i] = i;
		}
		arrange(column_index, 0);
		
		
	}
	private static void print_map(int[] column_index){
		System.out.println(result_index + ":");
		result_index++;
		for(int i = 0;i<column_sum;i++){
			for(int j = 0;j<column_sum;j++){
				if(column_index[j] == i){
					System.out.print("@");
				}else{
					System.out.print("#");
				}
				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void arrange(int[] column_index,int begin_index){
		if(begin_index<column_sum-1){
			for(int i = begin_index;i<column_sum;i++){
				int temp = column_index[i];
				column_index[i] = column_index[begin_index];
				column_index[begin_index] = temp;
				arrange(column_index, begin_index+1);
				temp = column_index[begin_index];
				column_index[begin_index] = column_index[i];
				column_index[i] = temp;
			}
		}else{
			if(check(column_index)){
				print_map(column_index);
			}
		}
	}
	
	private static boolean check(int[] column_index){
		for(int i = 0;i<column_sum;i++){
			for(int j = i+1;j<column_sum;j++){
				if(i-j == column_index[i] - column_index[j]  ||
						j - i == column_index[i] - column_index[j])
					return false;
			}
		}
		return true;
	}
	
}