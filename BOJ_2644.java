import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int[] total;
	static int x;
	static int y;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		arr = new int[N + 1][2];	//1�̰��踦 ������ �迭
		visited = new boolean[N + 1];	// �湮�ߴ� ���� �ٽ� �湮�ϸ� ���ѷ����� ������ �ȴ�.
		total = new int[N + 1];		//��ĭ�� ���ĿԴ����� ���� �迭
		x = sc.nextInt();		//�Է� X��
		y = sc.nextInt();		//�Է� Y��

		
		int K = sc.nextInt();
		for (int i = 1; i <= K; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		System.out.println(BFS(x, N));
	}

	public static int BFS(int x, int N) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		//ť�� ������� ������ �������ٴ� �Ҹ��̴�.
		while (!q.isEmpty()) {
			int nextX = q.poll();
			visited[nextX] = true;
			//�湮�� ���� true�� �ٲ����ν� ��湮 ���� �ȵ��� �Ѵ�.
			for (int i = 0; i < N; i++) {
				//��ü �迭�� ���鼭 ����������鼭 �湮 �������� �ֳ� üũ�Ѵ�
				//�ִٸ� ť�� �־��ش�.
				if (arr[i][0] == nextX && !visited[arr[i][1]]) {
					//1�̰��谡 �������� �Ǿ������Ƿ� ���� ���� �ѹ�
					q.add(arr[i][1]);
					//�������� +1 �� ���� �����Ѵ�
					total[arr[i][1]] = total[arr[i][0]] + 1;
				} else if (arr[i][1] == nextX && !visited[arr[i][0]]) {
					//������ ���� �ѹ�
					q.add(arr[i][0]);
					//�������� +1�Ȱ��� �����Ѵ�.
					total[arr[i][0]] = total[arr[i][1]] + 1;
				}
			}
			//q�� ����ų� ã�°��� ������ �����Ѵ�.
			if (!q.isEmpty() && q.peek() == y) {
				return total[y];
			}

		}
		return -1;
	}
}
