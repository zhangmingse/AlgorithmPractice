package ioPrctice;

import javax.swing.LayoutFocusTraversalPolicy;

public class Hanoi {
	public static void solve(int levelCount, int a, int b, int c) {
		if (levelCount < 0) {
			System.out.println("the level count is negative number .exit !");
			return;
		}
		if (levelCount == 0) {
			System.out.println("the level count is zero .exit !");
			return;
		}
		if (levelCount == 1) {
			System.out.println(a + "->" + c);
			return;
		}
		solve(levelCount - 1, a, c, b);
		System.out.println(a + "->" + c);
		solve(levelCount - 1, b, a, c);

	}

	public static void solve_my_practice1(int levelcount, int a, int b, int c) {
		if (levelcount > 1) {
			solve_my_practice1(levelcount - 1, a, c, b);
			System.out.println(a + "=>" + c);
			solve_my_practice1(levelcount - 1, b, a, c);
		} else if (levelcount == 1) {
			System.out.println(a + "=>" + c);
		} else {
			System.out.println("input error");
		}
	}

}
