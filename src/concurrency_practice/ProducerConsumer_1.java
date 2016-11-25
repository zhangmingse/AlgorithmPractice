package concurrency_practice;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer_1 {
	LinkedList<Object> list = new LinkedList<>();
	final int MAX = 10;
	
	void start(){
		new Producer().start();
		new Consumer().start();
	}
	
	class Producer{
		public void start() {
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						synchronized (list) {
							while(true){
								while(list.size() == MAX){
									list.wait();
								}
								String string = new Date().toString();
								list.add(string);
								System.out.println(">>>>>>>>>>>> put an object");
								list.notify();
								Thread.sleep((new Random().nextInt(3)+1)*100);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}
			}).start();
		}
	}
	
	class Consumer{

		public void start() {
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						synchronized (list) {
							while(true){
								while(list.size() == 0){
									list.wait();
								}
								String string  = list.getFirst().toString();
								list.removeFirst();
								System.out.println("<<<<<<<<<<<<<<<<<<<< get an object : " + string);
								list.notify();
								int sleep_time = (new Random().nextInt(3)+1)*100;
								//System.out.println("sleep time : " + sleep_time);
								Thread.sleep(sleep_time);
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}
			}).start();
		}
	
	}
	
	public static void main(String[] args) {
		new ProducerConsumer_1().start();
	}

}
