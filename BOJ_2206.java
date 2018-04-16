import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int[][][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new int[N][M];
		map = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				for (int k = 0; k < 2; k++) {
					map[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		BFS(0, 0);

	}

	public static void BFS(int x, int y) {

		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y, 0));
		map[x][y][0] = 1;

		while (!q.isEmpty()) {
			Dot current = q.poll();

			int currentX = current.x;
			int currentY = current.y;
			int currentWall = current.wall;

			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];
				int nextWall = currentWall;
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}

				// ���� �շ��ִ� ���
				if (arr[nextX][nextY] == 0) {
					// �ִܰŸ��� ��� �ִܰŸ��� �ٲ��ش�.
					if (map[currentX][currentY][currentWall] + 1 < map[nextX][nextY][nextWall]) {
						map[nextX][nextY][nextWall] = map[currentX][currentY][currentWall] + 1;
						q.add(new Dot(nextX, nextY, nextWall));
					}
				}

				// ���� �̵��� ���� ���̰� && ���� ���� �ѹ��� �ȶվ��� ���
				else if (arr[nextX][nextY] == 1 && currentWall == 0) {
					// ���� �մ°� �ִ� �Ÿ����
					if (map[currentX][currentY][currentWall] + 1 < map[nextX][nextY][1]) {
						// ���� �մ´�.
						map[nextX][nextY][1] = map[currentX][currentY][currentWall] + 1;
						q.add(new Dot(nextX, nextY, 1));
					}
				}

			}
		}
		int max = Math.min(map[N - 1][M - 1][0], map[N - 1][M - 1][1]);
		if (max == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(max);
		}

	}

}

class Dot {
	int x;
	int y;
	int wall;

	Dot(int x, int y, int wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}