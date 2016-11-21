package think_in_java_practice;

public class Interface_test  implements Interface_grandson,Interface_child_left{

	@Override
	public void function_child_left() {
		// TODO Auto-generated method stub
		System.out.println("function child left");
		
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub
		System.out.println("function");
		
	}

	@Override
	public void function_child_right() {
		// TODO Auto-generated method stub
		System.out.println("function child right");
	}

	@Override
	public void function_grandson() {
		// TODO Auto-generated method stub
		System.out.println("function grandson");
		
	}

	@Override
	public void function_child() {
		// TODO Auto-generated method stub
		System.out.println("functiong child");
		
	}
	
	public static void main(String[] args) {
		Interface_test test = new Interface_test();
		Interface_child_left interface_child_left = test;
		Interface_child_right interface_child_right = test;
		Interface_grandson interface_grandson = test;
		Interface_parent interface_parent = test;
		interface_child_left.function_child_left();
		interface_child_right.function_child_right();
		interface_child_left.function_child();
		interface_child_right.function_child();
		interface_grandson.function_grandson();
		interface_parent.function();
	}

}
