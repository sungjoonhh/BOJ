import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int up;
	static int down;
	static int left;
	static int right;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc1 = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int dir = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int nextX;
		int nextY;
		while (true) {

			for(int i=0; i<4; i++){
			nextX = x+dx[i];
			nextY = y+dy[i];
			
			}
		}

	}

}