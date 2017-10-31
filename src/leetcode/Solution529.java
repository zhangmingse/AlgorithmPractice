package leetcode;

public class Solution529 {

	public static void main(String[] args) {
		char[][] arr = new char[][] { { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M' }, { 'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E' },
				{ 'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E' } };
		char[][] arr1 = new char[][] { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' } };
		char[][] arr2 = new char[][] { { 'B', '1', 'E', '1', 'B' }, { 'B', '1', 'M', '1', 'B' },
				{ 'B', '1', '1', '1', 'B' }, { 'B', 'B', 'B', 'B', 'B' } };
		Solution529 solution529 = new Solution529();
		
		arr = solution529.updateBoard(arr, new int[] { 0, 0 });
		show2dimensionArr(arr);

		System.out.println("===============================");
		arr = solution529.updateBoard(arr1, new int[] { 3, 0 });
		show2dimensionArr(arr1);

		System.out.println("===============================");
		arr = solution529.updateBoard(arr2, new int[] { 1, 2 });
		show2dimensionArr(arr2);
	}

	public char[][] updateBoard(char[][] board, int[] click) {

		int row = click[0];
		int column = click[1];
		if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
			return board;
		}
		if (board[row][column] == 'M') {
			board[row][column] = 'X';
			return board;
		}
		return updateBoard1(board, click);
	}

	public char[][] updateBoard1(char[][] board, int[] click) {
		int row = click[0];
		int column = click[1];
		if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
			return board;
		}
		if (board[row][column] == 'M') {
			return board;
		}
		if (board[row][column] == 'E') {
			int temp = count(board, click);
			if (temp == 0) {
				board[row][column] = 'B';
				click[0]--;
				click[1]--;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (i == 1 && j == 1) {
							continue;
						}
						click[0] += i;
						click[1] += j;
						updateBoard(board, click);
						click[0] -= i;
						click[1] -= j;
					}
				}
				click[0]++;
				click[1]++;
			} else {
				board[row][column] = String.valueOf(temp).charAt(0);
			}

		}
		return board;
	}

	private int count(char[][] board, int[] click) {
		int result = 0;
		int row = click[0];
		int column = click[1];
		if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
			return result;
		}
		for (int i = row - 1; i < row + 2; i++) {
			for (int j = column - 1; j < column + 2; j++) {
				if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
					continue;
				}
				result += add(board, i, j);
			}
		}

		return result;
	}

	private int add(char[][] arr, int row, int column) {
		if (arr[row][column] == 'M' || arr[row][column] == 'X')
			return 1;
		return 0;
	}

	private static void show2dimensionArr(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.format("%4c", arr[i][j]);
			}
			System.out.println();
		}
	}
}
