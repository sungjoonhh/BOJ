import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;
	static int M;
	static int[][] arr;
	static int[][] reset;

	public static void main(String args[]) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		arr = new int[N][M];
		reset = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		Reset();
		int max = Integer.MIN_VALUE;

		for (int x1 = 0; x1 < N; x1++) {
			for (int y1 = 0; y1 < M; y1++) {
				//�� ���� ��ġ�� 0�� �ƴϸ� �н�
				if (reset[x1][y1] != 0)
					continue;
				for (int x2 = 0; x2 < N; x2++) {
					for (int y2 = 0; y2 < M; y2++) {
						//��ǥ�� ������ ���ʿ� �����Ƿ� �н�
						if (x1 == x2 && y1 == y2)
							continue;
						//�� ���� ��ġ�� 0�� �ƴϸ� �н�
						if (reset[x2][y2] != 0)
							continue;
						for (int x3 = 0; x3 < N; x3++) {
							for (int y3 = 0; y3 < M; y3++) {
								//��ǥ�� ������ ���ʿ� �����Ƿ� �н�
								if (x1 == x3 && y1 == y3)
									continue;
								if (x2 == x3 && y2 == y3)
									continue;
								//�� ���� ��ġ�� 0�� �ƴϸ� �н�
								if (reset[x3][y3] != 0)
									continue;

								//���̷����� �ִ� ���� ã�� ���� �ݺ���
								for (int i = 0; i < N; i++) {
									for (int j = 0; j < M; j++) {
										//���̷����� ���� ���� �ùķ��̼� ����
										if (reset[i][j] == 2) {
											//������ ���� ����
											reset[x1][y1] = 1;
											reset[x2][y2] = 1;
											reset[x3][y3] = 1;
											BFS(i, j);
										}
									}
								}
								max = Math.max(max, Check());
								Reset();
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}

	public static void BFS(int x, int y) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));

		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];

				//�迭 ������ �Ѿ�� �н�
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				//���� �����ְų� �̹� ���̷����� �����ƴٸ� �н�
				if (reset[nextX][nextY] == 1 || reset[nextX][nextY] == 2) {
					continue;
				}
				//���̷��� ����
				q.add(new Dot(nextX, nextY));
				reset[nextX][nextY] = 2;
			}
		}

	}
	//���� �ùķ��̼��� �ؾ��ϹǷ� �迭�� �ʱ�ȭ ������Ѵ�.
	public static void Reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				reset[i][j] = arr[i][j];
			}
		}
	}

	//0�� ����� üũ, �� �������� ���� üũ
	public static int Check() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (reset[i][j] == 0)
					count++;
			}
		}
		return count;
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