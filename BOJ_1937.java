import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int arr[][];
	static int visited[][];
	static int n;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int max;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc1 = new Scanner(System.in);
		n = sc.nextInt();

		arr = new int[n][n]; // arr[][] = 대나무 숲
		visited = new int[n][n]; // visited[][] = 시간 방지를 위한 배열
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		max = 0; // max = 최대 이동 횟수
		// 모든 대나무 시작을 하나씩 돌아다닌다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				/*
				 * 만약 0이라면 시작한다. 그러나 0이 아닐경우 이전에 구해놨던 값보다 최대 이동 횟수가 작을 수 밖에 없다.
				 * 그렇기 때문에 visited[i][j]==0 이라는 조건을 걸어놨다.
				 */
				if (visited[i][j] == 0) {
					dfs(i, j, 1);
				}
			}
		}
		System.out.println(max);
	}

	static void dfs(int x, int y, int count) {

		int nextX, nextY;

		if (max < count) {
			max = count;
		}
		// 이동할 경로 (상,하,좌,우)
		for (int i = 0; i < 4; i++) {
			nextX = x + dx[i];
			nextY = y + dy[i];

			// 배열의 인덱스를 넘었을 때 건너뛴다.
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
				continue;
			}
			// 그 다음 대나무가 적다면 건너뛴다.
			if (arr[nextX][nextY] <= arr[x][y]) {
				continue;
			}
			/*
			 * 다음 방문할 경로가 이전에 있고 이전 경로가 현재 경로보다 횟수가 크다면 건너 뛴다. 당연히 이전의 경로 횟수가
			 * 크다면 더 탐색할 이유가 없다.
			 */
			if (visited[nextX][nextY] > visited[x][y] + 1) {
				continue;
			}
			// 그렇지 않다면, 현재 경로의 +1을 해주고 다음 이동경로로 넘어간다.
			visited[nextX][nextY] = visited[x][y] + 1;
			dfs(nextX, nextY, count + 1);

		}
	}

}