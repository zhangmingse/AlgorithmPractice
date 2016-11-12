package think_in_java_practice;

public class A {
	public void f_in() {
		System.out.println("A in");
	}
	public void f_out() {
		System.out.println("A out");
		f_in();
	}
}
