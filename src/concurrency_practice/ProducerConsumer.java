package concurrency_practice;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

	LinkedList<String> list = new LinkedList<>();
	final int MAX = 10;

	public void start() {
		new Producer(list).start();
		new Consumer(list).start();

	}

	private class Producer {
		LinkedList<String> list;

		public Producer(LinkedList<String> list) {
			this.list = list;
		}

		public void start() {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {

						synchronized (list) {
							try {
								while (list.size() == MAX) {
									list.wait();
								}
								String string = new Date().toString();
								list.add(string);
								System.out.println(">>>>>>>> producer add a string to list");
								Thread.sleep(new Random().nextInt(3) * 1000);
								list.notify();

							} catch (Exception e) {
								// TODO: handle exception
								System.err.println("producer interrupted.");
								e.printStackTrace();
								break;
							}
						}

					}

				}
			}).start();
		}

	}

	private class Consumer {
		LinkedList<String> list;

		public Consumer(LinkedList<String> list) {
			// TODO Auto-generated constructor stub
			this.list = list;
		}

		public void start() {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {

						synchronized (list) {
							try {

								while (list.size() == 0) {
									list.wait();
								}
								String string = list.getFirst();
								System.out.println("<<<<<<<<<<<<<consumer remove a string : " + string);
								list.removeFirst();

								Thread.sleep(new Random().nextInt(3) * 1000);
								list.notify();

							} catch (Exception e) {
								// TODO: handle exception
								System.err.println("consumer interrupted.");
								e.printStackTrace();
								break;
							}
						}
					}
				}
			}).start();

		}
	}

	public static void main(String[] args) {
		new ProducerConsumer().start();
	}

}
