package access.cookie2;

import access.Chocolatechip2;

public class Cookie extends Chocolatechip2{
	public Cookie() {
		// TODO Auto-generated constructor stub
		System.out.println("Cookie Constructor");
	}
	
	protected void bite() {
		System.out.println("bite");
		eat();
		ChocolateChip4 chocolateChip4 = new ChocolateChip4();
		chocolateChip4.eat();
	}

}
