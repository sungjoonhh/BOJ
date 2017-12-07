import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	static int result;
	static int[][] visited;
	static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int arr[][];
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		n = sc.nextInt();
		m = sc.nextInt();
		result = 0;
		arr = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				visited[i][j] = -1;
			}
		}
		result = dfs(0, 0);
		System.out.println(result);
	}

	static int dfs(int X, int Y) {

		if (X == n-1 && Y == m-1) {
			return 1;
		}
		if (visited[X][Y] != -1) {
			return visited[X][Y];
		}
		visited[X][Y] = 0;
		for (int i = 0; i < 4; i++) {
			int next_X = X + dir[i][0];
			int next_Y = Y + dir[i][1];

			if (next_X >= 0 && next_Y >= 0 && next_X < n && next_Y < m&& arr[next_X][next_Y] < arr[X][Y]) {

				visited[X][Y] += dfs(next_X, next_Y);
			}
		}
		return visited[X][Y];

	}
}