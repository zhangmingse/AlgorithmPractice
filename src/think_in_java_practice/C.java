package think_in_java_practice;

public class C extends A{


	public void f_in() {
		System.out.println("C in");
	}
	public static void main(String[] args) {
		C cc = new C();
		A a= cc;
		cc.f_out();
		a.f_out();
	}

}
