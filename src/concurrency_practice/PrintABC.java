package concurrency_practice;

import java.util.Random;

public class PrintABC {

	CurrentState currentState;

	class CurrentState {
		String state;

		public void setState(String s) {
			state = s;
		}

		public String getState() {
			return state;
		}
	}

	public void print() {
		currentState = new CurrentState();
		currentState.setState("A");
		new PrintChracter("A", currentState).print();
		new PrintChracter("B", currentState).print();
		new PrintChracter("C", currentState).print();
		new PrintChracter("D", currentState).print();
	}

	class PrintChracter {
		String string;
		CurrentState current;

		public PrintChracter(String s, CurrentState _current) {
			// TODO Auto-generated constructor stub
			this.string = s;
			this.current = _current;
		}

		public void print() {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						while (true) {
							synchronized (current) {
								while (!string.equals(current.getState())) {
									// System.out.println(string+" is waiting");
									current.wait();

								}
								System.out.println(string);
								Thread.sleep(100 * (new Random().nextInt(3) + 1));
								if (string.equals("A"))
									current.setState("B");
								else if (string.equals("B"))
									current.setState("C");
								else if (string.equals("C"))
									current.setState("D");
								else
									current.setState("A");
//									System.err.println("err  current:" + current.getState());
								current.notifyAll();
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
		new PrintABC().print();
	}

}
