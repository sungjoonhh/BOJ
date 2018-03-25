import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

		int N = Integer.parseInt(br.readLine());
		String[] str;
		int[][] arr = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < i; j++) {
				arr[i][j + 1] = Integer.parseInt(str[j]);
			}
		}

		dp[1][1] = arr[1][1];
		for (int i = 1; i < N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + arr[i + 1][j + 1]);
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + arr[i + 1][j]);
			}
		}

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[N][i]);
		}
		System.out.println(max);

	}
}