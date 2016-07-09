package other;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
	
	public static void main(String[] args) {
		SortedSet<ItemTest> set = new TreeSet<>();
		set.add(new ItemTest("Tom",1234));
		set.add(new ItemTest("Widget", 5678));
		set.add(new ItemTest("Modem", 9912));
		System.out.println(set);
		
		SortedSet<ItemTest> set_1 = new TreeSet<>(new Comparator<ItemTest>() {
			public int compare(ItemTest a,ItemTest b) {
				String str_a = a.getDescription();
				String str_b = b.getDescription();
				return str_a.compareTo(str_b);
				
			}
		});
		set_1.addAll(set);
		
		System.out.println(set_1);
	}

}
