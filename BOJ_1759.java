import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static char[] arr;
	static int[] result;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new char[M];
		result = new int[M];
		str = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			arr[i] = str[i].charAt(0);
		}

		Arrays.sort(arr); // ������ ���� ���ĵǾ� �־���Ѵ�....
		DFS(0, 0, 0, 0);
	}

	// ������, ���õ� ���ڰ���, ��������, ��������
	public static void DFS(int start, int depth, int ja, int mo) {

		for (int i = start; i < M; i++) {
			result[i] = 1; // ���õ� ���� Ȯ�ο�
			// ������ ���� ������ �ľ��ؼ� �������� �Ѱ��ش�.
			DFS(i + 1, depth + 1, ja + (!check(arr[i]) ? 1 : 0), mo + (!check(arr[i]) ? 0 : 1));

			result[i] = 0; // 0�̸� ���� �ȵ�
		}
		// ���ڰ����� N���̸� ������ ������ ������ ��Ģ�� �������� ����Ѵ�.
		if (depth == N && ja >= 2 && mo >= 1) {
			print();
		}
	}

	public static void print() {
		for (int i = 0; i < M; i++) {
			// result�� 0�̶�� ���õ��� �ʾұ� ������ �ѱ��.
			if (result[i] == 1)
				System.out.print(arr[i]);
		}
		System.out.println();
	}

	// ���� ���� �ľ� �Լ�
	public static boolean check(char a) {
		if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
			return true;
		else
			return false;
	}

}
