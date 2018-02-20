import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N;
	static int M;
	static int count = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int start_x = Integer.parseInt(str[0]);
		int start_y = Integer.parseInt(str[1]);
		int start_dir = Integer.parseInt(str[2]);

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		//--------------입력--------------
		
		Search(arr, start_x, start_y, start_dir);	//청소 실행 함수
		Check(arr);	//청소한 칸의 개수를 구함
		System.out.println(count);
	}

	public static void Search(int[][] arr, int start_x, int start_y, int start_dir) {
		Queue<Dot> q = new LinkedList<Dot>();
		arr[start_x][start_y] = 2;
		q.add(new Dot(start_x, start_y, start_dir));
		while (!q.isEmpty()) {
			Dot d = q.poll();
			int currentX = d.x;	//현재 x좌표
			int currentY = d.y;	//현재 y좌표
			int currentD = d.dir;	//현재 방향
			System.out.println(currentX +" "+currentY);
			Boolean flags = false;	//4방향이 다 청소돼있거나 벽일 경우를 판단해줌.
			int nextX;
			int nextY;
			int nextD;

			for (int i = 0; i < 4; i++) {
				currentD = (currentD + 3) % 4;	//다음 이동할 방향
				nextX = currentX + (dx[currentD]);	//다음 이동할 X좌표
				nextY = currentY + (dy[currentD]);	//다음 이동할 Y좌표

				Dot nextDot = new Dot(nextX, nextY, currentD);
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				//다음 이동할 위치가  청소되지 않은 곳이라면 ㄱ
				if (arr[nextX][nextY] == 0) {
					q.add(nextDot);
					arr[nextX][nextY] = arr[currentX][currentY]+1;
					flags = true;
					break;
				}
			}
			if (!flags) {
				nextD = (currentD + 2) % 4;
				nextX = currentX + dx[nextD];
				nextY = currentY + dy[nextD];

				if (arr[nextX][nextY] != 1) {
					arr[nextX][nextY] = arr[currentX][currentY]+1;
					q.add(new Dot(nextX, nextY, currentD));
				}
			}
		}
	}

	//청소한 칸의 개수를 구하는 함수
	public static void Check(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 9)
					count++;
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

class Dot {
	int x;
	int y;
	int dir;

	Dot(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}