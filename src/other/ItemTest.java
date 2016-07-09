package other;

import java.util.Objects;

public class ItemTest implements Comparable<ItemTest> {

	private String description;
	private int number;
	
	public ItemTest(String des,int num) {
		description = des;
		number = num;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String toString() {
		return "description:"+description+",number="+number;
	}
	

	public String getDescription() {
		return description;
	}

	@Override
	public int compareTo(ItemTest o) {
		if(this == o)
			return 0;
		
		return Integer.compare(number, o.getNumber());
	}
	
	public int hashCode() {
		return Objects.hash(description,number);
	}
	
	
}
