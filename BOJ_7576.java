import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);

			}
		}
		//----------------- �Է� �� ------------------
		BFS(arr, N, M);
	}

	public static void BFS(int[][] arr, int N, int M) {
		Queue<DOT> q = new LinkedList<DOT>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1)
					//���� �丶�䰡 �ִ� ��� ��ġ�� ť�� ��´�.
					q.add(new DOT(i, j));
			}
		}

		while (!q.isEmpty()) {
			//���� �丶���� �����¿�� ������ �ͱ� ������ ť�� ��ƾ��Ѵ�.
			DOT dot = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = dot.x + dx[i];
				int nextY = dot.y + dy[i];

				//���� �� �н�
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				//���� ��ġ�� ���� ���� �丶�䰡 �ƴϸ� �н�
				if (arr[nextX][nextY] != 0) {
					continue;
				}
				//�ִ� �ϼ��� ���ϱ� ������ 1�� �ٲٴ� ���� �ƴ϶� ���� �ϼ� +1 �� ������Ѵ�.
				arr[nextX][nextY] = arr[dot.x][dot.y] + 1;
				q.add(new DOT(nextX, nextY));
			}
			//print(arr, N, M); // ���� ��ü ���
			//System.out.println();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					//�丶�䰡 ��� ���� ���� ��Ȳ�̶�� -1 �� ����Ѵ�.
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		//�׷��� �ʴٸ� �ִ밪�� ����Ѵ�.
		System.out.println(max - 1);

	}
	//������ ��ü �����ִ� �Լ�
	public static void print(int[][] arr, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class DOT {
	int x;
	int y;

	DOT(int x, int y) {
		this.x = x;
		this.y = y;
	}
}