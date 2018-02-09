import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Main {
	static int[][] arr;
	static int[] result;
	static int N;
	static int count;
	static int[] start;
	static int[] link;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);

		arr = new int[N][N];
		result = new int[N];
		start = new int[N];
		link = new int[N];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				// arr[i] = integer.parseint(str[i + 1]);
			}
		}
		DFS(0, 0);
		System.out.println(min);
	}

	public static void DFS(int start, int depth) {

		for (int i = start; i < N; i++) {
			result[i] = 1;
			count++;

			DFS(i + 1, depth + 1);
			result[i] = 0;
			count--;
		}
		if (count == N / 2){
			//print();
			calc();
		}

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static void calc() {
		int start_sum = 0;
		int liNk_sum = 0;
		int start_cNt = 0;
		int liNk_cNt = 0;
		for (int k = 0; k < N; k++) {
			if (result[k] == 1) {
				start[start_cNt++] = k;
			} else {
				link[liNk_cNt++] = k;
			}
		}

		for (int x = 0; x < N / 2; x++) {
			for (int y = 0; y < N / 2; y++) {
				start_sum += arr[start[x]][start[y]];
				liNk_sum += arr[link[x]][link[y]];
			}
		}
		if (min > Math.abs(start_sum - liNk_sum)) {
			min = Math.abs(start_sum - liNk_sum);
		}

	}
}
