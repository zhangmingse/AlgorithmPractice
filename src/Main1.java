import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			char[] characters = string.toCharArray();
			int[] arr = convert(characters);
			int k = scanner.nextInt();
			find(arr, 0, arr.length - k, 0);
			System.out.println(min);
			scanner.nextLine();
		}
	}

	private static int[] convert(char[] arr) {
		int[] result = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			result[i] = Integer.parseInt(arr[i] + "");
		}
		return result;
	}

	private static int min = Integer.MAX_VALUE;

	private static void find(int[] arr, int index, int left, int current) {
		if (left == 0 ) {
			if (current < min) {
				min = current;
			}
		}
		
		for (int i = index; i < arr.length; i++) {
			find(arr, i + 1, left, current);
			find(arr, i + 1, left - 1, current * 10 + arr[index]);
		}
	}

}
