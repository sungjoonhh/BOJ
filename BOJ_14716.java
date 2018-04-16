
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int M;
	static int[][] arr;

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new int[N][M];
		int count = 0;
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) {
					BFS(i, j);
					count++;
				}
			}
		}
		System.out.println(count);

	}

	public static void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();

		q.add(new Dot(x, y));

		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 8; i++) {

				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				if (arr[nextX][nextY] == 0) {
					continue;
				}

				arr[nextX][nextY] = 0;
				q.add(new Dot(nextX, nextY));
			}
		}

	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}