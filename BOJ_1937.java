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

		arr = new int[n][n]; // arr[][] = �볪�� ��
		visited = new int[n][n]; // visited[][] = �ð� ������ ���� �迭
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		max = 0; // max = �ִ� �̵� Ƚ��
		// ��� �볪�� ������ �ϳ��� ���ƴٴѴ�.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				/*
				 * ���� 0�̶�� �����Ѵ�. �׷��� 0�� �ƴҰ�� ������ ���س��� ������ �ִ� �̵� Ƚ���� ���� �� �ۿ� ����.
				 * �׷��� ������ visited[i][j]==0 �̶�� ������ �ɾ����.
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
		// �̵��� ��� (��,��,��,��)
		for (int i = 0; i < 4; i++) {
			nextX = x + dx[i];
			nextY = y + dy[i];

			// �迭�� �ε����� �Ѿ��� �� �ǳʶڴ�.
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
				continue;
			}
			// �� ���� �볪���� ���ٸ� �ǳʶڴ�.
			if (arr[nextX][nextY] <= arr[x][y]) {
				continue;
			}
			/*
			 * ���� �湮�� ��ΰ� ������ �ְ� ���� ��ΰ� ���� ��κ��� Ƚ���� ũ�ٸ� �ǳ� �ڴ�. �翬�� ������ ��� Ƚ����
			 * ũ�ٸ� �� Ž���� ������ ����.
			 */
			if (visited[nextX][nextY] > visited[x][y] + 1) {
				continue;
			}
			// �׷��� �ʴٸ�, ���� ����� +1�� ���ְ� ���� �̵���η� �Ѿ��.
			visited[nextX][nextY] = visited[x][y] + 1;
			dfs(nextX, nextY, count + 1);

		}
	}

}