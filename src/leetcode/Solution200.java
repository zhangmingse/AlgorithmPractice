package leetcode;

public class Solution200 {

	public static void main(String[] args) {
		Solution200 solution200 = new Solution200();
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		System.out.println(solution200.numIslands(grid));

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
				System.out.println(solution200.numIslands(grid));
	}

	int count = 0;

	public int numIslands(char[][] grid) {
		count = 0;
		if (grid == null || grid.length <=0 || grid[0].length <= 0) {
			return 0;
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (numIslandsUtil(grid, i, j)) {
					count++;
				}
			}
		}
		return count;

	}

	private boolean numIslandsUtil(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return false;
		}
		if (grid[i][j] != '1') {
			return false;
		}
		grid[i][j] = 'A';
		numIslandsUtil(grid, i - 1, j);
		numIslandsUtil(grid, i + 1, j);
		numIslandsUtil(grid, i, j - 1);
		numIslandsUtil(grid, i, j + 1);

		return true;

	}
}
