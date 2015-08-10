package ioPrctice;

public class Hanoi {
	public static void solve(int levelCount,int a,int b,int c){
		if(levelCount < 0){
			System.out.println("the level count is negative number .exit !");
			return;
		}
		if(levelCount == 0){
			System.out.println("the level count is zero .exit !");
			return;
		}
		if(levelCount == 1){
			System.out.println(a+"->"+c);
			return;
		}
		solve(levelCount-1,a,c,b);
		System.out.println(a+"->"+c);
		solve(levelCount-1,b,a,c);
		
	}

}
