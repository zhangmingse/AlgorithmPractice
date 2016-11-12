package access;

import access.cookie2.Cookie;

public class ChocolateChip extends Cookie {
	public ChocolateChip() {
		// TODO Auto-generated constructor stub
		System.out.println("Chocolatechip constructor");
	}
	public void bump() {
		bite();
	}

	public static void main(String[] args) {
		ChocolateChip chocolateChip = new ChocolateChip();
		chocolateChip.bump();
		ChocolateChip3 chip3 = new ChocolateChip3();
		chip3.drink();
	}
}
