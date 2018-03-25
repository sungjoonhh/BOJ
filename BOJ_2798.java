import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static BufferedReader br;
	static int N;
	static int M;
	static int max;
	static int result;
	static int[] arr;
	static boolean[] visited;
	static String[] str;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		max = Integer.MAX_VALUE;
		arr = new int[N];
		visited = new boolean[N];
		str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		for (int i = 0; i < N; i++) {
			visited[i] = true;
			DFS(i, 0, arr[i]);
			visited[i] = false;
		}
		System.out.println(result);
	}

	public static void DFS(int start, int depth, int sum) {
		if (depth == 2) {
			if (Math.abs(M - sum) < max && sum <= M) {
				max = Math.abs(M - sum);
				result = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			DFS(i + 1, depth + 1, sum + arr[i]);
			visited[i] = false;
		}
	}

}