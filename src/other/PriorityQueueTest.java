package other;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
		pq.add(new GregorianCalendar(2001,1,2));
		pq.add(new GregorianCalendar(1990,2,14));
		pq.add(new GregorianCalendar(1872,4,1));
		pq.add(new GregorianCalendar(1000,2,3));
		
		for(GregorianCalendar date : pq){
			System.out.println(date.get(GregorianCalendar.YEAR));
		}
		System.out.println("--------------------");
		
		Iterator<GregorianCalendar> iterator = pq.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().get(GregorianCalendar.YEAR));
		}
		
		System.out.println("Removing Elements");
		
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(GregorianCalendar.YEAR));
		}
	}

}
