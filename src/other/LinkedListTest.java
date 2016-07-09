package other;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
	public static void main(String[] args) {
		List<String> a = new LinkedList<>();
		a.add("Carl");
		a.add("Emma");
		a.add("Throl");
		List<String> b = new LinkedList<>();
		b.add("Robort");
		b.add("Lynan");
		b.add("Arya");
		b.add("Snow");
		
		ListIterator<String> aIterator = a.listIterator();
		Iterator<String> bIterator = b.listIterator();
		
		while(bIterator.hasNext()){
			if(aIterator.hasNext()){
				aIterator.next();
			}
			aIterator.add(bIterator.next());
			
		}
		System.out.println(a);
		
		bIterator = b.iterator();
		while(bIterator.hasNext()){
			bIterator.next();
			if(bIterator.hasNext()){
				bIterator.next();
				bIterator.remove();
			}
		}
		System.out.println(b);
		
		a.removeAll(b);
		System.out.println(a);
		
		
	}

}
