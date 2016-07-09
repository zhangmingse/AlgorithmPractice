package sort;


public class SortTestData implements Comparable<Object>{
	private int keyValue;
	
	public SortTestData(int i){
		keyValue = i;
	}
	
	public void setKeyValue(int i){
		keyValue = i;
	}
	
	public int getKeyValue(){
		return keyValue;
	}

	@Override
	public int compareTo(Object o) {
		
		if(this.keyValue > ((SortTestData)o).getKeyValue())
			return 1;
		if(this.keyValue < ((SortTestData)o).getKeyValue())
			return -1;
		
		return 0;
	}
}
