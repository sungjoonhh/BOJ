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
				//벽 세울 위치가 0이 아니면 패스
				if (reset[x1][y1] != 0)
					continue;
				for (int x2 = 0; x2 < N; x2++) {
					for (int y2 = 0; y2 < M; y2++) {
						//좌표가 같으면 돌필요 없으므로 패스
						if (x1 == x2 && y1 == y2)
							continue;
						//벽 세울 위치가 0이 아니면 패스
						if (reset[x2][y2] != 0)
							continue;
						for (int x3 = 0; x3 < N; x3++) {
							for (int y3 = 0; y3 < M; y3++) {
								//좌표가 같으면 돌필요 없으므로 패스
								if (x1 == x3 && y1 == y3)
									continue;
								if (x2 == x3 && y2 == y3)
									continue;
								//벽 세울 위치가 0이 아니면 패스
								if (reset[x3][y3] != 0)
									continue;

								//바이러스가 있는 점을 찾기 위한 반복문
								for (int i = 0; i < N; i++) {
									for (int j = 0; j < M; j++) {
										//바이러스가 있을 때만 시뮬레이션 실행
										if (reset[i][j] == 2) {
											//세개의 벽을 세움
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

				//배열 범위를 넘어가면 패스
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				//벽에 막혀있거나 이미 바이러스에 감염됐다면 패스
				if (reset[nextX][nextY] == 1 || reset[nextX][nextY] == 2) {
					continue;
				}
				//바이러스 전파
				q.add(new Dot(nextX, nextY));
				reset[nextX][nextY] = 2;
			}
		}

	}
	//다음 시뮬레이션을 해야하므로 배열을 초기화 해줘야한다.
	public static void Reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				reset[i][j] = arr[i][j];
			}
		}
	}

	//0의 계수를 체크, 즉 안전지역 개수 체크
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